package danilovich.dev.forvikalove.controller;

import danilovich.dev.forvikalove.model.Coupon;
import danilovich.dev.forvikalove.service.CouponService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/coupons")
public class CouponController {
    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping
    public List<Coupon> getCoupons() {
        return couponService.getAllCoupons();
    }

    @PostMapping("/{id}/take")
    public Coupon takeCoupon(@PathVariable("id") long id) {
        return couponService.takeCoupon(id);
    }

    @PostMapping
    public Coupon createCoupon(@RequestBody Coupon coupon) {
        return couponService.addCoupon(coupon);
    }

    @PostMapping("/complete")
    public Coupon completeCoupon(@PathVariable("id") Long id) {
        return couponService.completeCoupon(id);
    }
}
