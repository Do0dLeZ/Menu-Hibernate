package model.dao;

import model.DBUtil;
import model.entity.Dish;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MenuImplHQL implements IMenuDAO {
    private EntityManager entityManager;
    private Criteria criteria;

    public MenuImplHQL() {
        EntityManagerFactory managerFactory = DBUtil.getManagerFactory();
        this.entityManager = managerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        this.criteria = session.createCriteria(Dish.class);
    }

    @Override
    public boolean addDish(Dish dish) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(dish);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            return false;
        }
        return true;
    }

    @Override
    public List getDishesBetweenPrices(int firstPrice, int secondPrice) {
        return criteria
                .add(Restrictions.ge("price", (double) firstPrice))
                .add(Restrictions.le("price", (double) secondPrice))
                .list();
    }

    @Override
    public List getDishesWithDiscount() {
        return criteria
                .add(Restrictions.isNotNull("discount"))
                .list();
    }

    @Override
    public List getDishesLessThen(int lessThen) {
        return criteria
                .add(Restrictions.le("weight", lessThen))
                .list();
    }
}
