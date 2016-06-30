package order;

import productData.Product;
import support.ProductNotFoundException;

import java.util.ArrayList;

/**
 * Class {@code ShoppingCart} handle the shopping list before the check out.
 *
 * @author  Scott Rigg

 */

public class ShoppingCart {
    private ArrayList<Product> cart;

    /**
     * Instantiates a new Shopping cart.
     */
    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    /**
     * Gets cart.
     *
     * @return the cart
     */
    public ArrayList<Product> getCart() {
        return cart;
    }

    /**
     * Locater product.
     *
     * @param ID the id
     * @return the product
     * @throws ProductNotFoundException the product not found exception
     */
    public Product locater(String ID) throws ProductNotFoundException{
        for(Product i: cart){
            if (i.getProductID().equals(ID))
                return i;
        }
        throw new ProductNotFoundException(ID);
    }

    /**
     * Add cart.
     *
     * @param ID the id
     * @throws ProductNotFoundException the product not found exception
     */
    public void addCart(String ID) throws ProductNotFoundException{
        cart.add(locater(ID));
    }

    /**
     * Rm cart.
     *
     * @param ID the id
     * @throws ProductNotFoundException the product not found exception
     */
    public void rmCart(String ID) throws ProductNotFoundException{
        cart.remove(locater(ID));
    }

    /**
     * Clear cart.
     */
    public void clearCart(){
        cart.clear();
    }
}
