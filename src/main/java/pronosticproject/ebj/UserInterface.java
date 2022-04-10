package pronosticproject.ebj;

import pronosticproject.dto.UserDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserInterface {
    List<UserDto> getUsers();
    void register(String login, String lastname, String firstname, String password);
}
