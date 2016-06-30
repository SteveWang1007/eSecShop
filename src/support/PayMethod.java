package support;

import usr.User;

import java.io.Serializable;

/**
 * Class {@code PayMethod} handles the payment information.
 *
 * @author  Tianqi Cheng
 * @see     productData.ProductCatalog
 */
public class PayMethod implements Serializable{
    private String bankNumber;
    private String fristName;
    private String lastName;
    private int validMonth;
    private int validYear;
    private String cVV;
    private Address billAddress;
    private User owner;

    /**
     * Instantiates a new Pay method.
     *
     * @param bankNumber  the bank number
     * @param fristName   the frist name
     * @param lastName    the last name
     * @param validMonth  the valid month
     * @param validYear   the valid year
     * @param cVV         the c vv
     * @param billAddress the bill address
     * @param owner       the owner
     */
    public PayMethod(String bankNumber, String fristName, String lastName, int validMonth, int validYear, String cVV, Address billAddress, User owner) {
        this.bankNumber = bankNumber;
        this.fristName = fristName;
        this.lastName = lastName;
        this.validMonth = validMonth;
        this.validYear = validYear;
        this.cVV = cVV;
        this.billAddress = billAddress;
        this.owner = owner;
    }

    /**
     * Gets bank number.
     *
     * @return the bank number
     */
    public String getBankNumber() {
        return bankNumber;
    }

    /**
     * Sets bank number.
     *
     * @param bankNumber the bank number
     */
    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    /**
     * Gets frist name.
     *
     * @return the frist name
     */
    public String getFristName() {
        return fristName;
    }

    /**
     * Sets frist name.
     *
     * @param fristName the frist name
     */
    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets valid month.
     *
     * @return the valid month
     */
    public int getValidMonth() {
        return validMonth;
    }

    /**
     * Sets valid month.
     *
     * @param validMonth the valid month
     */
    public void setValidMonth(int validMonth) {
        this.validMonth = validMonth;
    }

    /**
     * Gets valid year.
     *
     * @return the valid year
     */
    public int getValidYear() {
        return validYear;
    }

    /**
     * Sets valid year.
     *
     * @param validYear the valid year
     */
    public void setValidYear(int validYear) {
        this.validYear = validYear;
    }

    /**
     * Gets vv.
     *
     * @return the vv
     */
    public String getcVV() {
        return cVV;
    }

    /**
     * Sets vv.
     *
     * @param cVV the c vv
     */
    public void setcVV(String cVV) {
        this.cVV = cVV;
    }

    /**
     * Gets bill address.
     *
     * @return the bill address
     */
    public Address getBillAddress() {
        return billAddress;
    }

    /**
     * Sets bill address.
     *
     * @param billAddress the bill address
     */
    public void setBillAddress(Address billAddress) {
        this.billAddress = billAddress;
    }

    /**
     * Gets owner.
     *
     * @return the owner
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Sets owner.
     *
     * @param owner the owner
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PayMethod)) return false;

        PayMethod payMethod = (PayMethod) o;

        if (validMonth != payMethod.validMonth) return false;
        if (validYear != payMethod.validYear) return false;
        if (!bankNumber.equals(payMethod.bankNumber)) return false;
        if (!fristName.equals(payMethod.fristName)) return false;
        if (!lastName.equals(payMethod.lastName)) return false;
        if (!cVV.equals(payMethod.cVV)) return false;
        if (!billAddress.equals(payMethod.billAddress)) return false;
        return owner.equals(payMethod.owner);

    }

    @Override
    public String toString() {
        return bankNumber + ','
                + fristName + ","
                + lastName + ","
                + validMonth + ","
                + validYear + ","
                + cVV + ","
                + billAddress + ","
                + owner;
    }
}
