package net.raofin.bearburger.service;

import net.raofin.bearburger.model.Comment;

import java.util.List;

public interface CommentService
{
    List<Comment> fetchAllComment();

    List<Comment> fetchCommentByFoodID(int foodID);

    List<Comment> fetchCommentByParentID(int foodID, int parentID);

    String loadComments(int foodID);

    void addComment(Comment comment);
}
