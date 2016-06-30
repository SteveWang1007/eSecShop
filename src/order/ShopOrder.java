package order;

import productData.Product;
import support.Address;
import support.NoAccessPermitException;
import support.PayMethod;
import usr.Customer;
import usr.Employee;
import usr.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class {@code ShopOrder} handle the purchase request and generate a object for user
 * to tracking the status.
 *
 * @author  Tianqi Cheng
 * @see     order.Order
 */
public class ShopOrder extends Order{
    private Customer customer;
    private ArrayList<Product> orderList;
    private PayMethod payment;
    private DeliverOrder delivery;


    /**
     * Constructor for user check out only.
     *
     * @param ID        the id
     * @param orderList the shopping list
     * @param payment   the payment method
     * @param delO      the Deliver Order
     */
    public ShopOrder(String ID, ArrayList<Product> orderList, PayMethod payment, DeliverOrder delO) {
        super(ID);
        this.orderList = orderList;
        this.payment = payment;
        this.delivery = delO;
        super.status = new ArrayList<String>();
        super.status.add("Wait for confirm,system,"+currentDate());
    }

    /**
     * The constructor for loading or duplicate.
     *
     * @param orderID    the order id
     * @param supervisor the supervisor
     * @param customer   the customer
     * @param orderList  the order list
     * @param payment    the payment
     * @param delivery   the delivery
     * @param status     the status
     */
    public ShopOrder(String orderID, User supervisor, Customer customer, ArrayList<Product> orderList, PayMethod payment, DeliverOrder delivery, ArrayList<String> status) {
        super(orderID, supervisor, status);
        this.customer = customer;
        this.orderList = orderList;
        this.payment = payment;
        this.delivery = delivery;
    }

    /**
     * Gets customer.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Gets order list.
     *
     * @return the order list
     */
    public ArrayList<Product> getOrderList() {
        return (ArrayList<Product>) orderList.clone();
    }

    /**
     * Sets order list.
     *
     * @param orderList the order list
     */
    public void setOrderList(ArrayList<Product> orderList) {
        this.orderList = orderList;
    }

    /**
     * Gets payment.
     *
     * @return the payment
     */
    public PayMethod getPayment() {
        return payment;
    }

    /**
     * Gets delivery.
     *
     * @return the delivery
     */
    public DeliverOrder getDelivery() {
        return delivery;
    }

    /**
     * Sets delivery.
     *
     * @param delivery the delivery
     */
    public void setDelivery(DeliverOrder delivery) {
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "Shopping" + super.toString()
                + customer.getUserName() + customer.getUserID() + '\n'
                + payment.toString() + '\n'
                + delivery.getOrderID();

    }

    /**
     * Return the total price.
     *
     * @return the total price
     */
    public int total() {
        int result = 0;
        for(Product i:orderList){
            result += i.getPrice();
        }
        return result;
    }


    //    public void confirm(String id, Employee supervisor){
//        super.setOrderID(id);
//        super.setSupervisor(supervisor);
//        update("confirmed",supervisor);
//    }
//
//    public void shipped(DeliverOrder DO, Employee logistics){
//        delivery = DO;
//        update("shipped",logistics);
//    }
//
//    public void delivered(User logistics){
//        update("delivered",logistics);
//    }



}
