package net.raofin.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "foods")
public class Food
{
    @Id
    @Column(name = "foodID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodID;

    @NotNull
    @Column(name = "category")
    private String category;

    @NotNull
    @Size(min = 4, max = 15)
    @Column(name = "title")
    private String title;

    @NotNull
    @Size(min = 4, max = 200)
    @Column(name = "description")
    private String description;

    @NotNull
    @Min(0)
    @Max(2000)
    @Column(name = "price")
    private int price;

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodID=" + foodID +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
