package support;

/**
 * Exception {@code OrderNotFoundException} handles if method cannot find the user.
 *
 * @author  Tianqi Cheng
 */
public class UserNotFoundException extends Exception {
    /**
     * Instantiates a new User not found exception.
     *
     * @param id the id
     */
    public UserNotFoundException(String id){
        super("User:"+id+"cannot found.");
    }
}
