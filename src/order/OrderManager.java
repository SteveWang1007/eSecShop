package order;

import support.DataManager;
import support.OrderNotFoundException;
import usr.UserCatalog;

/**
 * Class {@code OrderManager} is the management class for all order. It extend from the
 * class {@code DataManager}
 *
 * @author  Tianqi Cheng
 * @see     support.DataManager;
 */
public class OrderManager extends DataManager{
    /**
     * The default constructor.
     */
    public OrderManager() {
        super.currentCatalog = new OrderCatalog();
    }

    /**
     * Handle the add method to the database.
     *
     * @param order the order
     */
    public void newOrder(Order order){
        OrderCatalog oc = (OrderCatalog) currentCatalog;
        if (!oc.newOrder(order))
            oc = new OrderCatalog();
    }

    /**
     * Find the order with ID
     *
     * @param ID the id
     * @return the order that match the record.
     * @throws OrderNotFoundException the order not found exception
     */
    public Order orderLocater(String ID) throws OrderNotFoundException {
        String catalogID = ID.substring(0,ID.length()-2);
        String userID = ID.substring(ID.length()-2,ID.length());
        OrderCatalog oc = new OrderCatalog(catalogID);
        return oc.orderLocator(userID);
    }
}
