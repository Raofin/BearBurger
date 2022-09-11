package net.raofin.bearburger.service;

import net.raofin.bearburger.repository.CommentRepository;
import net.raofin.bearburger.model.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService
{
    private final CommentRepository commentDao;

    public CommentServiceImpl(CommentRepository commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public List<Comment> fetchAllComment() {
        return commentDao.findAll();
    }

    @Override
    public List<Comment> fetchCommentByFoodID(int foodID) {
        return commentDao.findByFoodId(foodID);
    }

    @Override
    public List<Comment> fetchCommentByParentID(int foodID, int parentID) {
        return commentDao.findByParentId(foodID, parentID);
    }

    @Override
    public String loadComments(int foodID) {

        StringBuilder commentsString = new StringBuilder();

        List<Comment> comments = commentDao.findByParentId(foodID, 0);

        for (Comment comment : comments) {
            commentsString.append(commentHTML(comment, 0, 0));
            commentsString.append(loadReplies(foodID, comment.getCommentID(), 0));
        }

        return commentsString.toString()
                .replaceAll("\\r\\n","<br>"); // handle new lines
    }

    private StringBuilder loadReplies(int foodID, int parentID, int marginLeft) {

        StringBuilder replyString = new StringBuilder();

        List<Comment> comments = commentDao.findByParentId(foodID, parentID);

        marginLeft = parentID == 0 ? 0 : marginLeft + 50;

        for (Comment comment : comments) {
            replyString.append(commentHTML(comment, parentID, marginLeft));
            replyString.append(loadReplies(foodID, comment.getCommentID(), marginLeft));
        }

        return replyString;
    }

    @Override
    public void addComment(Comment comment) {
        commentDao.save(comment);
    }

    private String commentHTML(Comment comment, int parentID, int marginLeft) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM dd, yyyy");

        String date = simpleDateFormat.format(comment.getPostDate());

        String style = parentID != 0 ? "style=\"margin-left: " + marginLeft + "px\"" : "";

        return "<div class=\"comments-div\" id=\"comments\" " + style + "\">\n" +
                "                <div id=\"comment-id-" + comment.getCommentID() + "\">\n" +
                "                    <a class=\"reply\" onclick=\"return reply(" + comment.getCommentID() + ")\">Reply</a>\n" +
                "                    <p><span class=\"author-name\" id=\"author-name\">" + comment.getPostedBy() + "</span> <i>on " + date + "</i></p>\n" +
                "                    <p id=\"posted-comment\">" + comment.getComment() + "</p>\n" +
                "                </div>    \n" +
                "            </div>";

    }
}
