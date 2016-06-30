package support;

import productData.Product;

/**
 * Exception {@code NotLogInException} report that when user attempt to add the product that already exit.
 */
public class RepeatProductException extends Exception {
    /**
     * Instantiates a new Repeat product exception.
     *
     * @param msg the msg
     */
    public RepeatProductException(Product msg){
        super("Product "+msg.toString()+" has already added");
    }
}
