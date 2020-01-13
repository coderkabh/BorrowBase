/*
 * Created by IntelliJ IDEA.
 * User: Kanishk
 * Date: 13/01/20
 * Time: 10:35 PM
 */
package DatabaseMethods;

import data.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TransactionDataMethods {
    public boolean isQueryPerformed1 = false;
    public boolean isQueryPerformed2 = false;
    Scanner scanner = new Scanner(System.in);

    public void addNewTransactionData(Connection connection, Transaction transaction) throws SQLException {
        String stringQuery = "INSERT INTO Transaction (c_id, rem_amt) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(stringQuery);
        preparedStatement.setString(1, transaction.getCustomerID());
//        preparedStatement.setInt(2,transaction.getDeposited());
        preparedStatement.setInt(2, transaction.getRemAmt());

        isQueryPerformed1 = preparedStatement.executeUpdate() >= 1;

    }

    public boolean isTransactionDataInserted() {
        return isQueryPerformed1;
    }

    public void alterTransactionDataByDeposition(Connection connection, Transaction transaction) throws SQLException {
        String stringQuery = "UPDATE Transaction SET Transaction.rem_amt =(?) WHERE rem_amt = (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(stringQuery);
        preparedStatement.setInt(1, transaction.getNewAmountFromCustomer());
        int newRemBal = transaction.getRemAmt() - transaction.getNewAmountFromCustomer();
        preparedStatement.setInt(2, newRemBal);

        isQueryPerformed2 = preparedStatement.executeUpdate() >= 1;

    }

    public boolean isAddNewTransactionDataInserted() {
        return isQueryPerformed1;
    }

    public boolean isalterTransactionDataByDepositionPerformed() {
        return isQueryPerformed2;
    }

}
