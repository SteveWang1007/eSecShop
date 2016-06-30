package order;

import support.Address;

import java.util.ArrayList;

/**
 * Class {@code DeliverOrder} is the class for the deliver order.
 *
 * @author      Tianqi Cheng
 * @see         order.Order
 *
 */
public class DeliverOrder extends Order {
    private Address address;

    /**
     *
     * Default constructor for crate a deliver order
     *
     * @param ID      the order ID
     * @param address the deliver address
     */
    public DeliverOrder(String ID,Address address) {
        super(ID);
        this.address = address;
        super.status = new ArrayList<String>();
        super.status.add("Wait for confirm,system,"+super.currentDate());
    }

    @Override
    public String toString() {
        return "Deliver" + super.toString() + address.toString();
    }
}
