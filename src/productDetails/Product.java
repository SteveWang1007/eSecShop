package productDetails;

/**
 * Created by srnegi on 6/27/2016.
 */
public abstract class Product {

    private int pid;
    private String productName;
    private String description;
    private Double cost;


    /**
     * Gets pid.
     *
     * @return the pid
     */
    public int getPid() {
        return pid;
    }

    /**
     * Sets pid.
     *
     * @param pid the pid
     */
    public void setPid(int pid) {
        this.pid = pid;
    }

    /**
     * Gets product name.
     *
     * @return the product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets product name.
     *
     * @param productName the product name
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public Double getCost() {
        return cost;
    }

    /**
     * Sets cost.
     *
     * @param cost the cost
     */
    public void setCost(Double cost) {
        this.cost = cost;
    }

    /**
     * Product details.
     */
    public abstract void productDetails();

}
