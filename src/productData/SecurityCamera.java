package productData;

import support.ProductNotFoundException;

/**
 * Class {@code SecurityCamera} handles the product list for Accessories session. it extend ProductCatalog
 *
 * @author  Tianqi Cheng
 * @see     productData.ProductCatalog
 */
public class SecurityCamera extends ProductCatalog {
    /**
     * Default constructor
     */
    public SecurityCamera(){
        super("SecurityCamera");
    }

    public Product productLocater(String productID) throws ProductNotFoundException{
        return super.productLocater(productID);
    }
}
