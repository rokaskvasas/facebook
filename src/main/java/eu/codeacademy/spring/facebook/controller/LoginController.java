package eu.codeacademy.spring.facebook.controller;


import eu.codeacademy.spring.facebook.request.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {


    @GetMapping
    public String login(Model model){
        model.addAttribute("user", new UserRequest());
        return "login";
    }

}
