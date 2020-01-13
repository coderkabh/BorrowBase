/*
 * Created by IntelliJ IDEA.
 * User: Kanishk
 * Date: 12/01/20
 * Time: 01:21 AM
 */
package DatabaseMethods;

import data.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerDataMethods {
    Scanner scanner = new Scanner(System.in);
    private boolean isQueryPerformed = false;

    public void addNewCustomer(Connection connection, Customer customer) throws SQLException {
        String queryStatement = "INSERT INTO CUSTOMER (c_id,c_name,c_add,c_phno) VALUES (?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
        preparedStatement.setString(1, customer.getCustomerID());
        preparedStatement.setString(2, customer.getCustomerName());
        preparedStatement.setString(3, customer.getCustomerAdd());
        preparedStatement.setString(4, customer.getCustomerPhno());

        isQueryPerformed = preparedStatement.executeUpdate() >= 1;

    }


    public boolean isNewEnterInCustomerCreated() {
        return isQueryPerformed;
    }

    public String getCustomerIDFromUser() {
        System.out.println("Enter the ID of the Customer: ");
        return scanner.nextLine();
    }

    public String getCustomerNameFromUser() {
        System.out.println("Enter the name of Customer");
        return scanner.nextLine();
    }

    public String getCustomerAddFromUser() {
        System.out.println("Enter the address of Customer");
        return scanner.nextLine();
    }

    public String getCustomerPhnoFromUser() {
        System.out.println("Enter the phone number of Customer");
        return scanner.nextLine();
    }

    private ResultSet getAllOfCustomer(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Customer;");
        return preparedStatement.executeQuery();
    }

}
