package eu.codeacademy.spring.facebook.controller;


import eu.codeacademy.spring.facebook.request.CommentRequest;
import eu.codeacademy.spring.facebook.request.PostRequest;
import eu.codeacademy.spring.facebook.request.UserRequest;
import eu.codeacademy.spring.facebook.security.UserPrincipal;
import eu.codeacademy.spring.facebook.service.CommentEntityService;
import eu.codeacademy.spring.facebook.service.PostEntityService;
import eu.codeacademy.spring.facebook.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Secured({"ROLE_ADMIN","ROLE_USER"})
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class HomeController {

    private final UserEntityService userEntityService;


    @GetMapping()
    public String index(@RequestParam(name = "username")String username, Model model) {

        model.addAttribute("usernameDB", userEntityService.getUserEntity(username));
        model.addAttribute("postAtt", new PostRequest());
        model.addAttribute("commentAtt",new CommentRequest());
        model.addAttribute("searchUser", new UserRequest());
        return "home";
    }


}
