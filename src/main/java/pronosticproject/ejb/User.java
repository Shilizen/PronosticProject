package pronosticproject.ejb;

import pronosticproject.dto.UserDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface User {
    List<UserDto> getUsers();
    void saveUser(String login, String firstname, String lastname, String password);
}
