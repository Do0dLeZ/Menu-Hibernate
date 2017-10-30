package model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static EntityManagerFactory managerFactory;

    public static EntityManagerFactory getManagerFactory() {
        if (managerFactory == null)
            return managerFactory = Persistence.createEntityManagerFactory("Restaurant");
        else
            return managerFactory;
    }
}
