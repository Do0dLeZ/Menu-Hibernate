package model.entity;

import javax.persistence.*;

@Entity
@Table(name = "menu")
@NamedQuery(name = "Menu.getAll", query = "SELECT m FROM Dish m")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "dish_name", length = 50, nullable = false)
    private String dishName;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private Double price;

    @Column(name = "weight", nullable = false, length = 5)
    private Integer weight;

    @Column(name = "discount", length = 3)
    private Integer discount;

    public Dish() {
    }

    public Dish(String dishName, Double price, Integer weight, Integer discount) {
        this.dishName = dishName;
        this.price = price;
        this.weight = weight;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Dish: " +
                "dish name '" + dishName + '\'' +
                ", price:" + price +
                ", weight: " + weight +
                (dishName != null ? ", discount: " + discount : "") + ".";
    }
}
