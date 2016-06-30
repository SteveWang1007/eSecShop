package order;

import support.Catalog;
import support.OrderNotFoundException;



import java.util.ArrayList;

/**
 * Class {@code OrderCatalog} is the bridge between the {@code Order} Object and the text file.
 * It extend from Class {@code Catalog}
 *
 * @author  Tianqi Cheng
 * @see     support.Catalog
 */
public class OrderCatalog extends Catalog {

    private ArrayList<Order> catalog;
    private String catalogID;

    /**
     * default Constructor.
     */
    public OrderCatalog(){
        super("order");
    }

    /**
     * constructor for loading pacific text file.
     *
     * @param ID the id
     */
    public OrderCatalog(String ID){
        super("order",ID);
    }

    /**
     * Add the order into the database.
     *
     * @param order the new order
     * @return if adding is success.
     */
    public boolean newOrder(Order order){
        if (super.isFull()) {
            order.setOrderID(super.getCatalogID()+ catalog.size());
            catalog.add(order);
            save();
            return true;
        }
        else {
            save();
            return false;
        }
    }

    /**
     * Search the database with the ID.
     *
     * @param id the Order ID
     * @return the Order that match the ID
     * @throws OrderNotFoundException report error when cannot find the order.
     */
    public Order orderLocator(String id) throws OrderNotFoundException {
        for (Object i : catalog) {
            Order tem = (Order) i;
            if (tem.getOrderID().equals(id)){
                return tem;
            }
        }
        throw new OrderNotFoundException(id);
    }

    @Override
    public String toString() {
        return catalogID+":"+catalog;
    }
}
