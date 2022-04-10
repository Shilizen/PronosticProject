package pronosticproject.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "fr.tzoreol.entities.Users.getUsers", query = "SELECT u FROM User u")
})
public class User {


    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String lastName;

    @NotNull
    private String firstName;

    @NotNull
    private String login;

    @NotNull
    private String password;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
