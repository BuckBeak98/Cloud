package bean;

public class login {

    private String username;
    private int password;
    private String fullname;

    public login(String username, int password, String fullname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }

    public login(String username, int password) {
        this.username = username;
        this.password = password;
    }

    public login() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }



}
