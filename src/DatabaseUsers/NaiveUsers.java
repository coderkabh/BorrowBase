/*
 * Created by IntelliJ IDEA.
 * User: kanishk
 * Date: 08/02/20
 * Time: 12:32 AM
 */
package DatabaseUsers;

public class NaiveUsers {
    private String username;
    private String password;

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
}
