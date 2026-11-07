package danilovich.dev.forvikalove.service;

import danilovich.dev.forvikalove.exception.CouponIsAlreadyUsedException;
import danilovich.dev.forvikalove.exception.NoExistCouponException;
import danilovich.dev.forvikalove.model.Coupon;
import danilovich.dev.forvikalove.repository.CouponRepository;
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

    public Optional<Coupon> useCoupon(Long id) {
        Optional<Coupon> coupon = couponRepository.findById(id)
                .orElseThrow(() -> new NoExistCouponException(id));
        if(coupon.get().isUsed()) {
            throw new CouponIsAlreadyUsedException(id);
        } else {
            coupon.get().setUsed(true);
            coupon.get().setUsedAt(LocalDate.now());
            couponRepository.save(coupon.get());
        }
        return coupon;
    }
}
