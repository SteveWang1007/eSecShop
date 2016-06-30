import productData.*;
import support.RepeatProductException;

/**
 * Created by mac on 16/6/27.
 */
public class init {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        ProductCatalog sc = new Accessories();
        Product dc = new Product("307","Microphone",20.0,100,"Microphone accessory","Accessories");
        System.out.print(sc.toString());
        try{
            sc.newProduct(dc);
        }
        catch (RepeatProductException rpe){
            System.err.println(rpe.getMessage());
            rpe.printStackTrace();
        }

    }
}
