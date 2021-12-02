package eu.codeacademy.spring.facebook.controller;

import eu.codeacademy.spring.facebook.repository.CommentEntityRepository;
import eu.codeacademy.spring.facebook.repository.PostEntityRepository;
import eu.codeacademy.spring.facebook.repository.UserEntityRepository;
import eu.codeacademy.spring.facebook.request.PostRequest;
import eu.codeacademy.spring.facebook.security.CustomUserDetailsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@WebMvcTest(ModalController.class)
class ModalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomUserDetailsService customUserDetailsService;

//    @MockBean
//    private UserEntityRepository userEntityRepository;

    @MockBean
    private PostEntityRepository postEntityRepository;

    @MockBean
    private CommentEntityRepository commentEntityRepository;

    @Test
    @WithMockUser
    void listPosts() throws Exception{
        Mockito.when(postEntityRepository.findAll());
        mockMvc.perform(MockMvcRequestBuilders.get("/modal"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

//    @Test
//    @WithMockUser
//    void createPost() throws Exception{
//
//        PostRequest post = new PostRequest(1L,1L,"content", LocalDateTime.now(),null);
////
////        mockMvc.perform(MockMvcRequestBuilders.post("/modal/createpost")
////                        .param("postId","1")
////                        .param("postId","1")
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/modal/createpost")
//                .content(String.format("postId=%d&userId=%d&postText=%s&createdAt=%s",post.getPostId(),post.getUserId(),post.getPostText(),post.getCreatedAt())))
//                .andExpect(MockMvcResultMatchers.forwardedUrl("/index"));
//
//
//    }
}