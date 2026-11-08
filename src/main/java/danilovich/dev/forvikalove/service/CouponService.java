package danilovich.dev.forvikalove.service;

import danilovich.dev.forvikalove.exception.CouponIsAlreadyUsedException;
import danilovich.dev.forvikalove.exception.IlegalStateException;
import danilovich.dev.forvikalove.exception.NoExistCouponException;
import danilovich.dev.forvikalove.model.Coupon;
import danilovich.dev.forvikalove.model.CouponStatus;
import danilovich.dev.forvikalove.repository.CouponRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CouponService {
    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    public Coupon takeCoupon(Long id) {
        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(() -> new NoExistCouponException(id));
        if(CouponStatus.IN_PROGRESS.equals(coupon.getStatus()) || CouponStatus.COMPLETED.equals(coupon.getStatus())) {
            throw new CouponIsAlreadyUsedException(id);
        } else {
            coupon.setStatus(CouponStatus.IN_PROGRESS);
            coupon.setUsedAt(LocalDate.now());
        }
        return couponRepository.save(coupon);
    }

    public Coupon completeCoupon(Long id) {
        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(() -> new NoExistCouponException(id));
        if(CouponStatus.IN_PROGRESS.equals(coupon.getStatus())) {
            coupon.setStatus(CouponStatus.COMPLETED);
            coupon.setUsedAt(LocalDate.now());
        } else{
            throw new IlegalStateException(id);
        }
        return couponRepository.save(coupon);
    }


    public Coupon addCoupon(Coupon coupon) {
        coupon.setStatus(CouponStatus.AVAILABLE);
        coupon.setUsedAt(null);
        return couponRepository.save(coupon);
    }

    @PostConstruct
    public void init() {
        if(couponRepository.count() == 0) {
            couponRepository.saveAll(List.of(
            new Coupon("Массаж спинки?", "Блаблаблабла", "Приятности"),
            new Coupon("Сделать лабы", "Опять работа...", "Учеба"),
            new Coupon("Пообниматься", "Мгхмгмх", "Приятности")));
        }
    }
}
