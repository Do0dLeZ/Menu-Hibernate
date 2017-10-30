package model.services;

import model.dao.IMenuDAO;
import model.dao.MenuImplHQL;
import model.entity.Dish;

import java.util.ArrayList;
import java.util.List;

public class MenuService implements IMenuService{

    @Override
    public boolean addDish(String name, Double price, Integer weight, Integer discount) {
        Dish dish = new Dish(name, price, weight, discount);
        IMenuDAO menuDAO = new MenuImplHQL();
        return menuDAO.addDish(dish);
    }

    @Override
    public ArrayList<Dish> getDishBetweenPrices(int firstPrice, int secondPrice) {
        IMenuDAO menuDAO = new MenuImplHQL();
        return (ArrayList<Dish>) menuDAO.getDishesBetweenPrices(firstPrice, secondPrice);
    }

    @Override
    public ArrayList<Dish> getDishWithDiscount() {
        IMenuDAO menuDAO = new MenuImplHQL();
        return (ArrayList<Dish>) menuDAO.getDishesWithDiscount();
    }

    @Override
    public ArrayList<Dish> getDishLessThen(int lessThen) {
        ArrayList<Dish> dishesLessThen = new ArrayList<>();
        IMenuDAO menuDAO = new MenuImplHQL();

        List list = menuDAO.getDishesLessThen(lessThen);
        int listSize = list.size();

        while (listSize > 0){
            int randomIndex = (int) (Math.random() * (listSize - 1));

            Dish dish = (Dish) list.get(randomIndex);
            dishesLessThen.add(dish);

            lessThen -= dish.getWeight();
            list = menuDAO.getDishesLessThen(lessThen);
            listSize = list.size();
        }

        return dishesLessThen;
    }
}
