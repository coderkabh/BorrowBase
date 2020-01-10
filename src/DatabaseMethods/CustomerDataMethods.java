package DatabaseMethods;

import data.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerDataMethods {
    Scanner scanner = new Scanner(System.in);
    private boolean isQueryPerformed = false;

    public void createNewEntryInCustomer(Connection connection, Customer customer) throws SQLException {
        String queryStatement = "INSERT INTO CUSTOMER (c_id,c_name,c_add,c_phno) VALUES (?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
        preparedStatement.setString(1, customer.getC_id());
        preparedStatement.setString(2, customer.getC_name());
        preparedStatement.setString(3, customer.getC_add());
        preparedStatement.setString(4, customer.getC_phno());

        isQueryPerformed = preparedStatement.executeUpdate() >= 1;

    }

    public boolean isNewEnterInCustomerCreated() {
        if (isQueryPerformed) {
            return true;
        } else {
            return false;
        }
    }
}
