package pronosticproject.dto;

import pronosticproject.ebj.UserInterface;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("user")
@SessionScoped
public class UserDto implements Serializable {
    @EJB
    private UserInterface userBean;

    private String login;
    private String lastname;
    private String firstname;
    private String password;
    private boolean connected;

    public UserDto(){

    }

    public UserDto(String login, String lastname, String firstname, String password){
        this.login = login;
        this.lastname = lastname;
        this.firstname = firstname;
        this.password = password;
    }

    public UserInterface getUserBean() {
        return userBean;
    }

    public void setUserBean(UserInterface userBean) {
        this.userBean = userBean;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public List<BetDto> userBets() {
        return null;
    }

    public boolean hasBets(){
        return userBets().size() != 0;
    }

    public List<UserDto> getUsers(){
       return this.userBean.getUsers();
    }

    public String doRegister(){
        this.userBean.register(this.login, this.lastname, this.firstname, this.password);
        return "index.jsf";
    }
}
