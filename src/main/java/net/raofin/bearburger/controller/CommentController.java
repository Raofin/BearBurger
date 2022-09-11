package net.raofin.bearburger.controller;

import net.raofin.bearburger.model.Comment;
import net.raofin.bearburger.service.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CommentController
{
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/fetch-all-comments")
    List<Comment> fetchAllComments() {
        return commentService.fetchAllComment();
    }

    @GetMapping("/fetch-comments-food-id")
    List<Comment> fetchCommentByFoodID(@RequestParam("foodID") int foodID) {
        return commentService.fetchCommentByFoodID(foodID);
    }

    @GetMapping("/fetch-comments-parent-id")
    List<Comment> fetchCommentsByParentID(
            @RequestParam("foodID") int foodID,
            @RequestParam("parentID") int parentID) {

        return commentService.fetchCommentByParentID(foodID, parentID);
    }

    @GetMapping("/fetch-comments")
    String fetchCommentsHTML(HttpSession session) {
        int foodID = session.getAttribute("foodID") == null ? 1 : (int) session.getAttribute("foodID");
        return commentService.loadComments(foodID);
    }
}
