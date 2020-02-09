/*
 * Created by IntelliJ IDEA.
 * User: Kanishk
 * Date: 12/01/20
 * Time: 01:21 AM
 */
package DatabaseMethods;

import data.Customer;

import java.sql.*;
import java.util.Scanner;

public class CustomerDataMethods {
    Scanner scanner = new Scanner(System.in);
    private boolean isQueryPerformed = false;


    /*
     * a method that will add a new customer to the database
     * */
    public void addNewCustomer(Connection connection, Customer customer) throws SQLException {


        String queryStatement = "INSERT INTO CUSTOMER (c_id,c_name,c_add,c_phno) VALUES (?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
        preparedStatement.setString(1, customer.getCustomerID().trim());
        preparedStatement.setString(2, customer.getCustomerName().trim());
        preparedStatement.setString(3, customer.getCustomerAdd().trim());
        preparedStatement.setString(4, customer.getCustomerPhno().trim());
        int value = preparedStatement.executeUpdate();
        if (value >= 1) isQueryPerformed = true;
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

    public void getAllOfCustomer(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        System.out.println("ID              NAME                ADDRESS             CONTACT");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CUSTOMER;");

        while (resultSet.next()) {
            String cID = resultSet.getString(1);
            String cName = resultSet.getString(2);
            String cAdd = resultSet.getString(3);
            String cPhno = resultSet.getString(4);
            System.out.println(cID + "           " + cName + "          " + cAdd + "           " + cPhno);
        }
    }

}
