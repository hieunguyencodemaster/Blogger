package com.TrungTinhFullStack.blog_backend_http.Service.Imp;

import com.TrungTinhFullStack.blog_backend_http.Entity.Comment;
import com.TrungTinhFullStack.blog_backend_http.Entity.Post;
import com.TrungTinhFullStack.blog_backend_http.Entity.User;
import com.TrungTinhFullStack.blog_backend_http.Repository.CommentRepository;
import com.TrungTinhFullStack.blog_backend_http.Repository.PostRepository;
import com.TrungTinhFullStack.blog_backend_http.Repository.UserRepository;
import com.TrungTinhFullStack.blog_backend_http.Service.CommentService;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.sql.model.internal.OptionalTableUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Comment createComment(Post post, User postedBy, String content) {
        if (post == null || postedBy == null) {
            throw new IllegalArgumentException("Required User ID and Post ID ");
        }

        Comment comment = new Comment();
        comment.setPost(post);
        comment.setContent(content);
        comment.setPostedBy(postedBy);
        comment.setCreatedAt(new Date());

        return commentRepository.save(comment);
    }
    public List<Comment> getCommentByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }
    @Override
    public List<Comment> getCommentByUserId(Long userId) {
        return commentRepository.findByPostedBy_Id(userId);
    }

    @Override
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    @Override
    public Comment updateComment(Long commentId, Comment comment) {

        Comment comment1 = commentRepository.findById(commentId).orElse(null);
        comment1.setContent(comment.getContent());
        comment1.setCreatedAt(new Date());
        return commentRepository.save(comment1);
    }

    @Override
    public Comment deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        commentRepository.delete(comment);
        return comment;
    }

    @Override
    public List<Comment> getCommentAll() {
        return commentRepository.findAll();
    }
}
