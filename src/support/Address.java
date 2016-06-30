package support;

import java.io.Serializable;

/**
 * Class {@code Accessories} handles the address information
 *
 * @author  Tianqi Cheng
 */

public class Address implements Serializable {
    private String name;
    private String addLine1;
    private String addLine2;
    private String city;
    private String state;
    private int zipCode;
    private String deliverInstruction;

    /**
     * Constructor
     *
     * @param name               the name
     * @param addLine1           the add line 1
     * @param addLine2           the add line 2
     * @param city               the city
     * @param state              the state
     * @param zipCode            the zip code
     * @param deliverInstruction the deliver instruction
     */
    public Address(String name, String addLine1, String addLine2, String city, String state, int zipCode, String deliverInstruction) {
        this.name = name;
        this.addLine1 = addLine1;
        this.addLine2 = addLine2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.deliverInstruction = deliverInstruction;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets add line 1.
     *
     * @return the add line 1
     */
    public String getAddLine1() {
        return addLine1;
    }

    /**
     * Sets add line 1.
     *
     * @param addLine1 the add line 1
     */
    public void setAddLine1(String addLine1) {
        this.addLine1 = addLine1;
    }

    /**
     * Gets add line 2.
     *
     * @return the add line 2
     */
    public String getAddLine2() {
        return addLine2;
    }

    /**
     * Sets add line 2.
     *
     * @param addLine2 the add line 2
     */
    public void setAddLine2(String addLine2) {
        this.addLine2 = addLine2;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets zip code.
     *
     * @return the zip code
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     * Sets zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets deliver instruction.
     *
     * @return the deliver instruction
     */
    public String getDeliverInstruction() {
        return deliverInstruction;
    }

    /**
     * Sets deliver instruction.
     *
     * @param deliverInstruction the deliver instruction
     */
    public void setDeliverInstruction(String deliverInstruction) {
        this.deliverInstruction = deliverInstruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        if (zipCode != address.zipCode) return false;
        if (!name.equals(address.name)) return false;
        if (!addLine1.equals(address.addLine1)) return false;
        if (!addLine2.equals(address.addLine2)) return false;
        if (!city.equals(address.city)) return false;
        if (!state.equals(address.state)) return false;
        return deliverInstruction != null ? deliverInstruction.equals(address.deliverInstruction) : address.deliverInstruction == null;
    }

    @Override
    public String toString() {
        return name + ","
                + addLine1 + ","
                + addLine2 + ","
                + city + ","
                + state + ","
                + zipCode + ","
                + deliverInstruction + '\n';
    }
}
