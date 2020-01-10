package data;

public class Customer {
    private String c_id;
    private String c_name;
    private String c_add;
    private String c_phno;

    public Customer(String c_id, String c_name, String c_add, String c_phno) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_add = c_add;
        this.c_phno = c_phno;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_add() {
        return c_add;
    }

    public void setC_add(String c_add) {
        this.c_add = c_add;
    }

    public String getC_phno() {
        return c_phno;
    }

    public void setC_phno(String c_phno) {
        this.c_phno = c_phno;
    }
}
