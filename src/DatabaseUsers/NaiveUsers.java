/*
 * Created by IntelliJ IDEA.
 * User: kanishk
 * Date: 08/02/20
 * Time: 12:32 AM
 */
package DatabaseUsers;

import java.util.Scanner;

public class NaiveUsers {
    private String username;
    private String password;

    Scanner scanner = new Scanner(System.in);

    public NaiveUsers(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void createNewNaiveUser(NaiveUsers naiveUsers) {

    }
}
