package danilovich.dev.forvikalove.exception;

public class NoExistCouponException extends RuntimeException {
    public NoExistCouponException(Long id) {
        super("Coupon with id " + id + " doesn't exist");
    }
}
