package com.TrungTinhFullStack.blog_backend_http.Controller;

import com.TrungTinhFullStack.blog_backend_http.Entity.User;
import com.TrungTinhFullStack.blog_backend_http.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .id(1L) // Đảm bảo rằng ID khớp với ID mong đợi trong phản hồi
                .username("trungtinh")
                .password("trungtinh")
                .build();
    }

    @Test
    void login() throws Exception {

        User loginUser = User.builder()
                .id(1L) // Đảm bảo rằng ID khớp với ID mong đợi trong phản hồi
                .username("trungtinh")
                .password("trungtinh")
                .build();

        Mockito.when(userService.login(loginUser.getUsername(), loginUser.getPassword()))
                .thenReturn(loginUser);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(loginUser)))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"username\":\"trungtinh\", \"user_id\":1}"));
    }

    @Test
    void register() throws Exception {
        Mockito.when(userService.register(Mockito.any(User.class)))
                .thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk());
    }
}
