package danilovich.dev.forvikalove.service;

import danilovich.dev.forvikalove.exception.CouponIsAlreadyUsedException;
import danilovich.dev.forvikalove.exception.NoExistCouponException;
import danilovich.dev.forvikalove.model.Coupon;
import danilovich.dev.forvikalove.repository.CouponRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CouponService {
    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    public Coupon useCoupon(Long id) {
        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(() -> new NoExistCouponException(id));
        if(coupon.isUsed()) {
            throw new CouponIsAlreadyUsedException(id);
        } else {
            coupon.setUsed(true);
            coupon.setUsedAt(LocalDate.now());
        }
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
