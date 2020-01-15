
/*
 * Created by IntelliJ IDEA.
 * User: Kanishk
 * Date: 11/01/20
 * Time: 11:44 PM
 */
package data;

import java.util.Scanner;

public class Transaction {
    Scanner scanner = new Scanner(System.in);
    private String customerID;
    //    private int deposited;
    private int remAmt;

    public Transaction(String customerID, int remAmt) {
        this.customerID = customerID;
//        this.deposited = deposited;
        this.remAmt = remAmt;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    /*public int getDeposited() {
        return deposited;
    }*/

   /* public void setDeposited(int deposited) {
        this.deposited = deposited;
    }*/

    public int getRemAmt() {
        return remAmt;
    }

    public void setRemAmt(int remAmt) {
        this.remAmt = remAmt;
    }

    public int getNewAmountFromCustomer() {
        return scanner.nextInt();
    }

}
