package com.TrungTinhFullStack.blog_backend_http.Service;

import com.TrungTinhFullStack.blog_backend_http.Entity.User;
import com.TrungTinhFullStack.blog_backend_http.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public interface UserService {

    User login(String username, String password);
    User register(String username, String password, String email, MultipartFile img) throws IOException;
    void createInitialAdmin() throws IOException;
    String hashPassword(String password);
    User findById(Long userId);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, String username, String password, String email, MultipartFile img);
    void deleteUser(Long id);
    void enableUser(Long userId, boolean enable)
}
