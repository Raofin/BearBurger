package net.raofin.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
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
    @Size(min = 4, max = 100)
    @Column(name = "title")
    private String title;

    @NotNull
    @Size(min = 4, max = 500)
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "price")
    private int price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "foodID")
    private List<Comment> comments;
}
