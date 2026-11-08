package danilovich.dev.forvikalove.exception;

public class NoExistHamsterException extends RuntimeException {
    public NoExistHamsterException(Long id) {
        super("Could not find Hamster with id " + id);
    }
}
