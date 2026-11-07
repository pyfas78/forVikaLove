package danilovich.dev.forvikalove.exception;

public class CouponIsAlreadyUsedException extends RuntimeException {
    public CouponIsAlreadyUsedException(Long id) {
        super("Coupon with id:" + id + " is already used");
    }
}
