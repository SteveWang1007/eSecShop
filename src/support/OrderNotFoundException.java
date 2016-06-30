package support;

/**
 * Exception {@code OrderNotFoundException} handles if method cannot find the order.
 *
 * @author  Tianqi Cheng
 */
public class OrderNotFoundException extends Exception{
    /**
     * Instantiates a new Order not found exception.
     *
     * @param id the id
     */
    public OrderNotFoundException(String id){
        super("Order "+id+"does not exist");
    }
}
