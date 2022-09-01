package net.raofin.dao;

import net.raofin.model.Comment;

import java.util.List;

public interface CommentDao
{
    List<Comment> fetchAllComment();

    List<Comment> fetchCommentByFoodID(int foodID);

    List<Comment> fetchCommentByParentID(int foodID, int parentID);

    void addComment(Comment comment);
}
