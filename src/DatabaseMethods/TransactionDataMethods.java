/*
 * Created by IntelliJ IDEA.
 * User: Kanishk
 * Date: 13/01/20
 * Time: 10:35 PM
 */
package DatabaseMethods;

import data.Transaction;

import java.sql.*;
import java.util.Scanner;

public class TransactionDataMethods {

    public boolean isQueryPerformed2 = false;
    Scanner scanner = new Scanner(System.in);

    public boolean addNewTransactionData(Connection connection, Transaction transaction) {
        boolean isQueryPerformed = false;
        try {
            String stringQuery = "INSERT INTO TRANSACTION (c_id, rem_amt) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(stringQuery);
            preparedStatement.setString(1, transaction.getCustomerID());
//        preparedStatement.setInt(2,transaction.getDeposited());
            preparedStatement.setInt(2, transaction.getRemAmt());
            int rowsAffected = preparedStatement.executeUpdate();
            isQueryPerformed = rowsAffected >= 1;
        } catch (SQLException e) {
            System.out.println("SQL Exception occurred");
        }
        return isQueryPerformed;

    }


    public void alterTransactionDataByDeposition(Connection connection, Transaction transaction) throws SQLException {
        String stringQuery = "UPDATE TRANSACTION set TRANSACTION.rem_amt = ? WHERE  c_id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(stringQuery);

        //int newRemBal = transaction.getRemAmt() - transaction.getNewAmountFromCustomer();
        preparedStatement.setInt(1, transaction.getRemAmt());
        preparedStatement.setString(2, transaction.getCustomerID());

        isQueryPerformed2 = preparedStatement.executeUpdate() >= 1;

    }

    public int getMoreBorrowAmountFromCustomer() {
        System.out.println("Enter the debit amount of customer");
        return scanner.nextInt();
    }


    public boolean isAlterTransactionPerformed() {
        return isQueryPerformed2;
    }

    public String getCustomerIDFromUser() {
        System.out.println("Enter the ID of the Customer: ");
        return scanner.nextLine();
    }

    public int getRemAmtFromUser() {
        System.out.println("Enter the Remaining amount of the Customer: ");
        return scanner.nextInt();
    }

    public void getAllTransactionData(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM TRANSACTION");
        System.out.println("Customer_ID" + "  " + "Borrow");
        while (resultSet.next()) {
            String cID = resultSet.getString(1);
            int remAmt = resultSet.getInt(2);
            System.out.println(cID + "            " + remAmt);
        }
    }


}
