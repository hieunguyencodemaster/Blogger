package com.TrungTinhFullStack.blog_backend_http.Service;

import com.TrungTinhFullStack.blog_backend_http.Entity.Post;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PostService {

    public Post createPost(String name, String content, Long userId, MultipartFile img, List<String> tags) throws IOException;
    List<Post> getAllPosts();
    Post getPostById(Long postId);
    void likePost(Long postId);
    void unLikePost(Long postId);
    List<Post> searchByName(String name);
    Post updatePost(Long postId, String name, String content, Long userId, MultipartFile img,List<String> tags) throws IOException;
    void deletePost(Long postId);
    Post findById(Long postId);
    List<Post> findByPostedById(Long id);
}
