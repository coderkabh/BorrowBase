package data;

public class Transaction {
    private String c_id;
    private int deposited;
    private int rem_amt;

    public Transaction(String c_id, int deposited, int rem_amt) {
        this.c_id = c_id;
        this.deposited = deposited;
        this.rem_amt = rem_amt;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public int getDeposited() {
        return deposited;
    }

    public void setDeposited(int deposited) {
        this.deposited = deposited;
    }

    public int getRem_amt() {
        return rem_amt;
    }

    public void setRem_amt(int rem_amt) {
        this.rem_amt = rem_amt;
    }
}
