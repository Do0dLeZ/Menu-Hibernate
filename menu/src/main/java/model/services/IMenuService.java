package model.services;

import model.entity.Dish;

import java.util.ArrayList;

public interface IMenuService {
    boolean addDish(String name, Double price, Integer weight, Integer discount);
    ArrayList<Dish> getDishBetweenPrices(int firstPrice, int secondPrice);
    ArrayList<Dish> getDishWithDiscount();

    /**
     * Sum of weight of list of dish should be less then 'lessThen' param.
     * @param lessThen - in gram (Example: less them 1 000 grams)
     * @return - array of dishes.
     */
    ArrayList<Dish> getDishLessThen(int lessThen);
}
