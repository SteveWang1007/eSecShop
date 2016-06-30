package productData;

import java.io.Serializable;

/**
 * Class {@code Product} is the class handle product information.
 *
 * @author  Tianqi Cheng
 * @see     java.io.Serializable;
 **/

public class Product implements Serializable{
    private String productID;
    private String name;
    private double price;
    private int stock;
    private String statement;
    private String type;

    /**
     * Constructor.
     *
     * @param productID the product id
     * @param name      the name
     * @param price     the price
     * @param stock     the stock
     * @param statement the statement
     * @param pt        the pt
     */
    public Product(String productID, String name, double price, int stock, String statement, String pt) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.statement = statement;
        this.type = pt;
    }

    /**
     * Gets product id.
     *
     * @return the product id
     */
    public String getProductID() {
        return productID;
    }

    /**
     * Sets product id.
     *
     * @param productID the product id
     */
    public void setProductID(String productID) {
        this.productID = productID;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Check stock.
     *
     * @return true for more that one product in stock.
     */
    public boolean isAvaliable(){
        return stock > 0;
    }

    /**
     * Gets statement.
     *
     * @return the statement
     */
    public String getStatement() {
        return statement;
    }

    /**
     * Sets statement.
     *
     * @param statement the statement
     */
    public void setStatement(String statement) {
        this.statement = statement;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Product:" + productID
                + "," + name
                + "," + price
                + "," + stock
                + "," + statement;
    }

    public String getName() {
        return name;
    }

    public Product clone() {
        return new Product(this.productID,this.name,this.price, this.stock, this.statement, this.type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return productID != null ? productID.equals(product.productID) : product.productID == null;

    }
}
