package productData;

import support.NoAccessPermitException;
import support.ProductNotFoundException;
import support.RepeatProductException;
import usr.Manager;
import usr.User;

import java.util.ArrayList;

/**
 * Class {@code ProductManager} handles the searching and editing of all product.
 *
 * @author  Tianqi Cheng
 **/
public class ProductManager {


    /**
     * New product.
     *
     * @param product the product
     * @param pt      the pt
     * @param usr     the usr
     * @throws RepeatProductException  the repeat product exception
     * @throws NoAccessPermitException the no access permit exception
     */
    public static void newProduct(Product product, ProductType pt, User usr) throws RepeatProductException,NoAccessPermitException {
        isAccessible(usr, product.getProductID());
        ProductCatalog p;
        switch (pt) {
            case SecurityCamera:
                p = new SecurityCamera();
                p.newProduct(product);
                break;
            case DVR:
                p = new DVR();
                p.newProduct(product);
                break;
            case Accessories:
                p = new Accessories();
                p.newProduct(product);
        }
    }

    /**
     * Rm product.
     *
     * @param ID  the id
     * @throws ProductNotFoundException the product not found exception
     */
    public static void rmProduct(String ID) throws ProductNotFoundException {
        String pt = ID.substring(0,1);
        ProductCatalog p;
        switch (pt) {
            case "1":
                p = new SecurityCamera();
                p.rmProduct(ID);
                break;
            case "2":
                p = new DVR();
                p.rmProduct(ID);
                break;
            case "3":
                p = new Accessories();
                p.rmProduct(ID);

        }
    }

    public static Product productLocator(String ID) throws ProductNotFoundException {
        String pt = ID.substring(0,1);
        ProductCatalog p;
        switch (pt) {
            case "1":
                p = new SecurityCamera();
                return p.productLocater(ID);
            case "2":
                p = new DVR();
                return p.productLocater(ID);
            case "3":
                p = new Accessories();
                return p.productLocater(ID);

        }
        throw new ProductNotFoundException(ID);
    }

    /**
     * Browse product array list.
     *
     * @return the array list
     */
    public static ArrayList<Product> browseProduct()  {
        ArrayList<Product> result = (new SecurityCamera()).browseProduct();
        result.addAll((new DVR()).browseProduct());
        result.addAll((new Accessories()).browseProduct());
        return result;
    }

    private static void isAccessible(User usr, String ID) throws NoAccessPermitException {
        if (!(usr instanceof Manager))
            throw new NoAccessPermitException("Product "+ID);
    }
}
