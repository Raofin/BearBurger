package net.raofin.bearburger.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "Foods")
public class Food
{
    @Id
    @Column(name = "Food_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodID;

    @NotNull
    @Column(name = "Category")
    private String category;

    @NotNull
    @Size(min = 5, max = 30)
    @Column(name = "Title")
    private String title;

    @NotNull
    @Size(min = 4, max = 500)
    @Column(name = "Description", columnDefinition="TEXT")
    private String description;

    @NotNull
    @Min(50)
    @Max(10_000)
    @Column(name = "Price")
    private int price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Food_ID")
    private List<Comment> comments;
}
