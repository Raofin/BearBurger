package net.raofin.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "comments")
public class Comment
{
    @Id
    @Column(name = "commentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentID;

    @Column(name = "parentID")
    private int parentID;

    @Column(name = "foodID")
    private int foodID;

    @Column(name = "postedBy")
    private String postedBy;

    @Column(name = "comment")
    private String comment;

    @Column(name = "PostDate")
    private Date PostDate;
}
