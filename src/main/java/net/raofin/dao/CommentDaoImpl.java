package net.raofin.dao;

import net.raofin.model.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDao
{
    private final SessionFactory sessionFactory;

    public CommentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Comment> fetchAllComment() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Comment> commentQuery = session.createQuery("FROM Comment", Comment.class);
        List<Comment> comments = commentQuery.getResultList();
        return comments == null ? new ArrayList<Comment>() : comments;
    }

    @Override
    public List<Comment> fetchCommentByFoodID(int foodID) {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Comment> commentQuery = session.createQuery("FROM Comment WHERE FoodID = :foodID", Comment.class);
        commentQuery.setParameter("foodID", foodID);
        return commentQuery.getResultList();
    }

    @Override
    public List<Comment> fetchCommentByParentID(int foodID, int parentID) {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Comment> commentQuery = session.createQuery("FROM Comment WHERE FoodID = :foodID AND ParentID = :parentID", Comment.class);
        commentQuery.setParameter("foodID", foodID);
        commentQuery.setParameter("parentID", parentID);
        return commentQuery.getResultList();
    }

    @Override
    public void addComment(Comment comment) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(comment);
    }
}
