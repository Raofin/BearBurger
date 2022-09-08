package net.raofin.bearburger.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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

    @CreationTimestamp
    @Column(name = "PostDate")
    private Date PostDate;
}
