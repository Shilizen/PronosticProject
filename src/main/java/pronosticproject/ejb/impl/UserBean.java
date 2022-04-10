package pronosticproject.ejb.impl;

import listener.ApplicationListener;
import pronosticproject.dto.UserDto;
import pronosticproject.ejb.User;
import pronosticproject.entities.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserBean implements User {

    @Override
    public List<UserDto> getUsers() {
        EntityManagerFactory emf = ApplicationListener.getEmf();
        System.out.println("Démarrage de l'emf");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("findAllUsers",
                UserEntity.class);
        List<UserEntity> users = query.getResultList();

        List<UserDto> listeUser = new ArrayList<>();
        System.out.println(listeUser.toString());
        users.forEach(u -> {
            UserDto userDto = new UserDto();
            userDto.setLogin(u.getLogin());
            userDto.setFirstname(u.getFirstName());
            userDto.setLastname(u.getLastName());
            userDto.setPassword(u.getPassword());
            listeUser.add(userDto);
        });
        System.out.println(listeUser.toString());
        return listeUser;
    }

    @Override
    public void saveUser(String login, String firstname, String lastname, String password) {
        UserDto userDto = new UserDto();
        userDto.setLogin(login);
        userDto.setLastname(lastname);
        userDto.setFirstname(firstname);
        userDto.setPassword(password);

        UserEntity user = new UserEntity();
        user.setLogin(userDto.getLogin());
        user.setFirstName(userDto.getFirstname());
        user.setLastName(userDto.getLastname());
        user.setPassword(userDto.getPassword());

        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();
        System.out.println("lancement de l'entity");
        em.getTransaction().begin();
        System.out.println("début de la transaction");
        em.persist(user);
        System.out.println("insérer la transaction");
        em.getTransaction().commit();
        System.out.println("transaction validée");
        em.close();
    }
}
