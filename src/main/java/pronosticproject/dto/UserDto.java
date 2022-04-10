package pronosticproject.dto;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("user")
@SessionScoped
public class UserDto implements Serializable {
    private String login;
    private String name;
    private String firstname;
    private String lastname;
    private String password;
    private boolean connected;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public String doLogin(){
        if(this.login.equals("Gaelle") && this.password.equals("Ch4ng3_1t_N0w")){
            this.connected = true;
        }
        return "index.jsf";
    }

    public List<UserDto> getUser(){
        return null;
    }

    public List<BetDto> userBets() {
        return null;
    }

    public boolean hasBets(){
        return userBets().size() != 0;
    }
}
