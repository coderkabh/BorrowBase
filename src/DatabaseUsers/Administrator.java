/*
 * Created by IntelliJ IDEA.
 * User: kanishk
 * Date: 08/02/20
 * Time: 12:26 AM
 */
package DatabaseUsers;

public class Administrator {
    private String username;
    private String password;

    public Administrator(String username, String password) {
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