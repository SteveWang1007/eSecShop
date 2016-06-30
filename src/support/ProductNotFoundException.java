package support;

/**
 * Exception {@code OrderNotFoundException} handles if method cannot find the product.
 *
 * @author  Tianqi Cheng
 */
public class ProductNotFoundException extends Exception {
    /**
     * Instantiates a new Product not found exception.
     *
     * @param msg the msg
     */
    public ProductNotFoundException(String msg){
        super("Product "+msg+" not exist");
    }
}
