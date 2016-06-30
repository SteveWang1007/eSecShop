package usr;

import order.Order;
import productData.Product;
import support.Address;
import support.PayMethod;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class {@code Customer} handle the customer information it extends User
 *
 * @author  Tianqi Cheng
 * @see     usr.User
 */
public class Customer extends User {
    private String emailAddress;
    private ArrayList<Address> addressBook;
    private ArrayList<PayMethod> payBook;
    private ArrayList<Order> orderHistory;

    /**
     * Instantiates a new Customer.
     */
    public Customer() {
        super();
        emailAddress = null;
        addressBook =  new ArrayList<Address>();
        payBook = new ArrayList<PayMethod>();
        orderHistory = new ArrayList<Order>();
    }

    /**
     * Instantiates a new Customer.
     *
     * @param un           the un
     * @param pw           the pw
     * @param id           the id
     * @param st           the st
     * @param emailAddress the email address
     * @param addressBook  the address book
     * @param payBook      the pay book
     * @param orderHistory the order history
     */
    public Customer(String un, String pw, String id, boolean st, String emailAddress, ArrayList<Address> addressBook, ArrayList<PayMethod> payBook, ArrayList<Order> orderHistory) {
        super(un, pw, id, st);
        this.emailAddress = emailAddress;
        this.addressBook = addressBook;
        this.payBook = payBook;
        this.orderHistory = orderHistory;
    }

    /**
     * Gets email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets email address.
     *
     * @param emailAddress the email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Get default address string.
     *
     * @return the string
     */
    public String getDefaultAddress(){
        return  addressBook.get(0).toString();
    }

    /**
     * Get default payment string.
     *
     * @return the string
     */
    public String getDefaultPayment(){
        return payBook.get(0).toString();
    }

    /**
     * Gets order history.
     *
     * @return the order history
     */
    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    /**
     * Add order history.
     *
     * @param o the o
     */
    public void addOrderHistory(Order o){
        orderHistory.add(o);
    }

    /**
     * View all address array list.
     *
     * @return the array list
     */
    public ArrayList<String> viewAllAddress(){
        ArrayList<String> result=new ArrayList<>();
        for (Address i: addressBook){
            result.add(i.toString());
        }
        return result;
    }

    /**
     * View all payment array list.
     *
     * @return the array list
     */
    public ArrayList<String> viewAllPayment(){
        ArrayList<String> result=new ArrayList<>();
        for (PayMethod i: payBook){
            result.add(i.toString());
        }
        return result;
    }

    /**
     * Set address.
     *
     * @param index the index
     * @param add   the add
     */
    public void setAddress(int index, Address add){
        addressBook.set(index, add);
    }

    /**
     * Set payment.
     *
     * @param index the index
     * @param pay   the pay
     */
    public void setPayment(int index, PayMethod pay){
        payBook.set(index,pay);
    }

    /**
     * Set default address.
     *
     * @param index the index
     */
    public void setDefaultAddress(int index){
        Collections.swap(addressBook,0,index);
    }

    /**
     * Set default payment.
     *
     * @param index the index
     */
    public void setDefaultPayment(int index){
        Collections.swap(payBook,0,index);
    }

    @Override
    public String toString() {
        String result=super.toString()+","+emailAddress+"\n";
        for(String i:viewAllAddress()){
            result += i;
            result += ",";
        }
        result += "\n";
        for(String i:viewAllPayment()){
            result += i;
            result += ",";
        }
        return result;
    }
}
