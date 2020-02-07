/*1
 * Created by IntelliJ IDEA.
 * User: Kanishk
 * Date: 13/01/20
 * Time: 11:33 PM
 */
package MainClassPackage;

import DatabaseMethods.AdminPrivilegeMethods;
import DatabaseMethods.CustomerDataMethods;
import DatabaseMethods.TransactionDataMethods;
import DatabaseUsers.NaiveUsers;
import connection.DatabaseConnection;
import data.Customer;
import data.Transaction;

import java.sql.SQLException;
import java.util.Scanner;

public class BorrowBaseMain {
    public static void main(String[] args) {
        System.out.println("Welcome to BorrowBase \n");
        int choice = 0;
        int subChoice = 0;
        Scanner scanner = new Scanner(System.in);

        DatabaseConnection databaseConnection = new DatabaseConnection();
        CustomerDataMethods customerDataMethods = new CustomerDataMethods();
        TransactionDataMethods transactionDataMethods = new TransactionDataMethods();
        AdminPrivilegeMethods adminPrivilegeMethods = new AdminPrivilegeMethods();

        try {
            databaseConnection.establishConnection();
        } catch (SQLException e) {
            System.out.println("Connection not Established ");
        }


        do {

            System.out.println("Enter your choice :");
            System.out.println("1. Add new entry of Customer ");
            System.out.println("2. Modify account of Customer ");
            System.out.println("3. Check current status of all Accounts ");
            System.out.println("4. See all users data");
            System.out.println("5. Developer Settings ");
            System.out.println("6. Exit");
            choice = scanner.nextInt();

            if (choice == 1) {
                try {

                    String customerID = customerDataMethods.getCustomerIDFromUser();
                    String customerName = customerDataMethods.getCustomerNameFromUser();
                    String customerAdd = customerDataMethods.getCustomerAddFromUser();
                    String customerPhno = customerDataMethods.getCustomerPhnoFromUser();
/*
                    These 4 lines takes input from user by calling those getter methods
                    System.out.println(customerID);
                    System.out.println(customerName);
                    System.out.println(customerAdd);
                    System.out.println(customerPhno);
*/

                    Customer customer = new Customer(customerID, customerName, customerAdd, customerPhno);
                    //Constructor to initialize the Customer class

                    customerDataMethods.addNewCustomer(DatabaseConnection.getConnection(), customer);
                    //Main functionality of the task


                    if (customerDataMethods.isNewEnterInCustomerCreated()) {
                        System.out.println("Entry in Customer table created successfully");
                    } else {
                        System.out.println("Entry not created");
                    }

                    int remAmt = transactionDataMethods.getRemAmtFromUser();
                    //Takes the remaining balance for the account
                    Transaction transaction = new Transaction(customerID, remAmt);

                    transactionDataMethods.addNewTransactionData(DatabaseConnection.getConnection(), transaction);
                } catch (SQLException e) {
                    System.out.println("SQL Exception occurred" + e.getMessage());
                } catch (Exception e) {
                    System.out.println("OOPS! Something went wrong");
                }
            } else if (choice == 2) {
                try {

                    String customerID2 = transactionDataMethods.getCustomerIDFromUser();
                    int newRemAmt = transactionDataMethods.getRemAmtFromUser();
                    Transaction transaction = new Transaction(customerID2, newRemAmt);
                    //Takes values from user
                    transactionDataMethods.alterTransactionDataByDeposition(DatabaseConnection.getConnection(), transaction);
                    //Changes the data in Database

                } catch (SQLException e) {
                    System.out.println("SQL Exception occurred" + e.getMessage());
                } catch (Exception e) {
                    System.out.println("OOPS! Something went wrong");
                }
            } else if (choice == 3) {
                try {
                    transactionDataMethods.getAllTransactionData(DatabaseConnection.getConnection());
                } catch (SQLException e) {
                    System.out.println("SQL Exception occurred");
                } catch (Exception e) {
                    System.out.println("OOPS! Something went wrong");
                }
            } else if (choice == 4) {
                try {
                    customerDataMethods.getAllOfCustomer(DatabaseConnection.getConnection());
                } catch (SQLException e) {
                    System.out.println("SQL Exception occurred");
                } catch (Exception e) {
                    System.out.println("OOPS! Something went wrong");
                }

            } else if (choice == 5) {
                System.out.println("\n\nWhat would you like to do :");
                System.out.println("1. Check Connection status");
                System.out.println("2. Re-establish Connection");
                System.out.println("3. Flush the database ");
                System.out.println("4. Add new Database user");
                System.out.println("5. Change Administrator");
                subChoice = scanner.nextInt();
                if (subChoice == 1) {
                    databaseConnection.printConnectionStatus();
                } else if (subChoice == 2) {
                    try {
                        System.out.println(databaseConnection.establishConnection());
                    } catch (SQLException e) {
                        System.out.println("SQL Exception occurred");
                    } catch (Exception e) {
                        System.out.println("OOPS! Something went wrong");
                    }

                } else if (subChoice == 3) {
                    try {

                        System.out.println("Remember once done it's not possible to revert back and undo changes.\n" +
                                "It is advised to think twice before taking this step. We do not recommend you to flush" +
                                "unless you want to have a fresh start or stop using this software. ");
                        System.out.println("Would you like to Flush all data ?" +
                                "\nType \"y\" or \"Y\" to continue or press any alphabet or numeric key for cancel.");
                        scanner.nextLine();
                        String string = scanner.nextLine();
                        System.out.println(string);
                        if (string.equalsIgnoreCase("y")) {
                            boolean isDeleted = adminPrivilegeMethods.deleteAllCustomerData(DatabaseConnection.getConnection());
                            boolean isDeleted2 = adminPrivilegeMethods.deleteAllTransactionData(DatabaseConnection.getConnection());
                            if (isDeleted && isDeleted) System.out.println("Database flushed successfully");
                            else System.out.println("Couldn't flush");
                        } else System.out.println("Flush operation cancelled by user");
                    } catch (SQLException e) {
                        System.out.println("OOPS! Something went wrong" + e.getMessage());
                    }

                } else if (subChoice == 4) {

                    System.out.println("Enter the username");
                    String username = scanner.nextLine();
                    System.out.println("Enter the password");
                    String password = scanner.nextLine();
                    NaiveUsers naiveUsers = new NaiveUsers(username, password);

                } else if (subChoice == 5) {

                } else {
                    System.out.println("Sorry wrong choice entered");
                }


            } else if (choice == 6) {
                System.out.println("Good Bye, Have a nice day");
                //scanner.next();
                System.exit(0);
            } else {
                System.out.println("Sorry wrong choice entered");
            }
        } while (choice != 6);

    }
}
