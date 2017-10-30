package model.dao;

import model.entity.Dish;

import java.util.List;

public interface IMenuDAO {
    boolean addDish(Dish dish);
    List getDishesBetweenPrices(int firstPrice, int secondPrice);
    List getDishesWithDiscount();
    List getDishesLessThen(int lessThen);
}
