package order;

import usr.User;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class {@code Order} is the superclass for all order
 *
 * @author      Tianqi Cheng
 *
 */
public class Order implements Serializable{
    private String orderID;
    private User operator;
    protected ArrayList<String> status;

    /**
     * The constructor with one argument, for user crate new order only.
     *
     * @param orderID the order id
     */
    public Order(String orderID){
        this.orderID = orderID;
        operator = null;

    }

    /**
     * The constructor for loading or duplicate.
     *
     * @param orderID    the order id
     * @param supervisor the supervisor
     * @param status     the status
     */
    public Order(String orderID, User supervisor, ArrayList<String> status) {
        this.orderID = orderID;
        this.operator = supervisor;
        this.status = status;
    }

    /**
     * Getter for order ID
     *
     * @return the order id
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * Setter for order ID
     *
     * @param orderID the order id
     */
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    /**
     * Getter for supervisor.
     *
     * @return the supervisor
     */
    public String getSupervisor() {
        return operator.toString();
    }

    /**
     * Setter for supervisor.
     *
     * @param supervisor the supervisor
     */
    public void setSupervisor(User supervisor) {
        this.operator = supervisor;
    }

    /**
     * Getter for status.
     *
     * @return the status
     */
    public ArrayList<String> getStatus() {
        return status;
    }

    /**
     * Setter for status.
     *
     * @param status the status
     */
    public void setStatus(ArrayList<String> status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order: "
                + orderID + ','
                + operator.getUserID() + '\n'
                + status + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        return orderID != null ? orderID.equals(order.orderID) : order.orderID == null;

    }

    /**
     * Return currentDate stamp in String format. internal use only.
     *
     * @return Current Date in String
     */
    protected String currentDate(){
        return (new SimpleDateFormat("MM.dd")).format(new Date());
    }

    /**
     * Update method for user to update status.
     *
     * @param msg Massage Content
     * @param usr The user who update the message.
     */
    public void update(String msg, User usr){
        status.add(msg+usr.getUserID()+currentDate());
    }

}
