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

    @PostMapping("/{id}/used")
    public Coupon useCoupon(@PathVariable("id") long id) {
        return couponService.useCoupon(id);
    }

    @PostMapping
    public Coupon createCoupon(@RequestBody Coupon coupon) {
        return coupon;
    }


}
