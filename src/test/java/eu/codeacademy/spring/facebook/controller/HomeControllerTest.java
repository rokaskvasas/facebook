//package eu.codeacademy.spring.facebook.controller;
//
//import eu.codeacademy.spring.facebook.repository.UserEntityRepository;
//import eu.codeacademy.spring.facebook.security.CustomUserDetailsService;
//import eu.codeacademy.spring.facebook.service.UserEntityService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@WebMvcTest(HomeController.class)
//class HomeControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserEntityService userEntityService;
//
//    @MockBean
//    private CustomUserDetailsService customUserDetailsService;
//
//    @Test
//    @WithMockUser
//    void getUserByUsername() throws Exception{
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/home"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.mode)
//    }
//
//}