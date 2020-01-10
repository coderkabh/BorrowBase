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
}
