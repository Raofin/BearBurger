package net.raofin.controller.Api;

import net.raofin.model.Comment;
import net.raofin.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentApi
{
    private final CommentService commentService;

    public CommentApi(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/fetch-all-comments")
    List<Comment> fetchAllComments() {
        return commentService.fetchAllComment();
    }

    @GetMapping("/fetch-comments-foodId")
    List<Comment> fetchCommentByFoodID(@RequestParam("foodID") int foodID) {
        return commentService.fetchCommentByFoodID(foodID);
    }

    @GetMapping("/fetch-comments-parentId")
    List<Comment> fetchCommentsByParentID(@RequestParam("foodID") int foodID, @RequestParam("parentID") int parentID) {
        return commentService.fetchCommentByParentID(foodID, parentID);
    }

    @GetMapping("/fetch-comments")
    String fetchCommentHTML(@RequestParam("foodID") int foodID) {
        return commentService.loadComments(foodID);
    }
}
