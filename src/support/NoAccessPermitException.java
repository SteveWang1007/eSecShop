package support;

/**
 * Exception {@code NotLogInException} report that when user attempt read/write data without correct user type.
 */
public class NoAccessPermitException extends Exception {
    /**
     * Instantiates a new No access permit exception.
     *
     * @param msg the msg
     */
    public NoAccessPermitException(String msg){
        super("Read/Write request to"+msg+"denied");
    }
}
