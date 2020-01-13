package data;

public class Customer {
    private String customerID;
    private String customerName;
    private String customerAdd;
    private String customerPhno;

    public Customer(String customerID, String customerName, String customerAdd, String customerPhno) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAdd = customerAdd;
        this.customerPhno = customerPhno;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAdd() {
        return customerAdd;
    }

    public void setCustomerAdd(String customerAdd) {
        this.customerAdd = customerAdd;
    }

    public String getCustomerPhno() {
        return customerPhno;
    }

    public void setCustomerPhno(String customerPhno) {
        this.customerPhno = customerPhno;
    }
}
