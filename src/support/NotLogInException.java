package support;

/**
 * Exception {@code NotLogInException} report that when user attempt read/write data without login.
 */
public class NotLogInException extends Exception {
    /**
     * Instantiates a new Not log in exception.
     */
    public NotLogInException(){
        super("You are currently not log in.");
    }
}
