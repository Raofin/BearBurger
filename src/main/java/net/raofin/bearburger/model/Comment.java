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
@Table(name = "Comments")
public class Comment
{
    @Id
    @Column(name = "Comment_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentID;

    @Column(name = "Parent_ID")
    private int parentID;

    @Column(name = "Food_ID")
    private int foodID;

    @Column(name = "Posted_By")
    private String postedBy;

    @Column(name="Comment", columnDefinition="TEXT")
    private String comment;

    @CreationTimestamp
    @Column(name = "Post_Date")
    private Date PostDate;
}
