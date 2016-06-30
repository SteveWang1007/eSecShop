package productData;

import support.FileAccessable;
import support.ProductNotFoundException;
import support.RepeatProductException;

import java.io.*;
import java.util.ArrayList;

/**
 * Class {@code ProductCatalog} handles the product list.
 *
 * @author  Tianqi Cheng
 **/

public class ProductCatalog implements FileAccessable{
    private ArrayList<Product> catalog;
    private String name;

    /**
     * Constructor
     *
     * @param Name the name
     */
    public ProductCatalog(String Name){
        catalog = new ArrayList<Product>();
        this.name = Name;
        try{
            FileInputStream fis = new FileInputStream("src/productData/"+Name+".txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true){
                catalog.add((Product)ois.readObject());
            }
        }
        catch (EOFException eofe){
            System.out.println(("File \""+Name+".txt complete\""));
        }
        catch (FileNotFoundException fnf){
            System.err.println("File \""+Name+".txt is missing\"");
        }
        catch (IOException ioe){
            System.err.print("Cannot read from file \""+Name+".txt\"");

        }
        catch (ClassNotFoundException cnf){
            cnf.printStackTrace();
        }
    }

    public void save(){
        try{
            FileOutputStream fos = new FileOutputStream("src/productData/"+name+".txt",false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Product i:catalog){
                oos.writeObject(i);
            }
            oos.close();

        }
        catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }

    }

    /**
     * Browse product
     *
     * @return the full product list
     */
    public ArrayList<Product> browseProduct(){
        ArrayList<Product> result = new ArrayList<>();
        for(Product i:catalog){
            result.add(i);
        }
        return result;
    }

    /**
     * Locate product with ID
     *
     * @param productID the product id
     * @return the product
     * @throws ProductNotFoundException the product not found exception
     */
    public Product productLocater(String productID) throws ProductNotFoundException{
        for(Product i:catalog){
            if (productID == i.getProductID()) {
                return i;
            }
        }
        throw new ProductNotFoundException(productID);
    }

    /**
     * Add product in to this catalog
     *
     * @param np the np
     * @throws RepeatProductException the repeat product exception
     */
    public void newProduct(Product np) throws RepeatProductException{
        np.setType(name);
        for(Product i:catalog){
            if (i.equals(np)) {
                throw new RepeatProductException(np);
            }
        }
        catalog.add(np);
        save();
    }

    /**
     * Rm product.
     *
     * @param ID the id
     * @throws ProductNotFoundException the product not found exception
     */
    public void rmProduct(String ID) throws ProductNotFoundException{
        Product p=productLocater(ID);
        if (catalog.remove(p)) {
            throw new ProductNotFoundException(ID);
        }
        save();
    }

    @Override
    public String toString() {
        return catalog.toString();
    }
}
