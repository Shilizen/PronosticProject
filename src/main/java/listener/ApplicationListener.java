package listener;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {
    private static EntityManagerFactory emf;

    public void contextInitialized(ServletContextEvent sce) {
        this.emf = Persistence.createEntityManagerFactory("default");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        this.emf.close();
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}