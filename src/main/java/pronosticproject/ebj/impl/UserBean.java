package pronosticproject.ebj.impl;

import pronosticproject.dto.UserDto;
import pronosticproject.ebj.UserInterface;
import pronosticproject.entities.UserEntity;
import pronosticproject.listener.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserBean implements UserInterface {

    @Override
    public List<UserDto> getUsers() {
        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("findAllUsers",
                UserEntity.class);
        List<UserEntity> users = query.getResultList();

        List<UserDto> listUser = new ArrayList<>();
        System.out.println(listUser.toString());
        users.forEach(u -> {
            UserDto userDto = new UserDto();
            userDto.setLogin(u.getLogin());
            userDto.setLastname(u.getLastname());
            userDto.setFirstname(u.getFirstname());
            userDto.setPassword(u.getPassword());
            listUser.add(userDto);
        });
        return listUser;
    }

    @Override
    public void register(String login, String lastname, String firstname, String password) {
        UserDto userDto = new UserDto();
        userDto.setLogin(login);
        userDto.setLastname(lastname);
        userDto.setFirstname(firstname);
        userDto.setPassword(password);

        UserEntity user = new UserEntity();
        user.setLogin(userDto.getLogin());
        user.setLastname(userDto.getLastname());
        user.setFirstname(userDto.getFirstname());
        user.setPassword(userDto.getPassword());

        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }
}
