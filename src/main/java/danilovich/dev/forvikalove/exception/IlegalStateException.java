package danilovich.dev.forvikalove.exception;

public class IlegalStateException extends RuntimeException {
    public IlegalStateException(Long id) {
        super(id + " is not a valid coupon ID");
    }
}
