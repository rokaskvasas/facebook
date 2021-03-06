package eu.codeacademy.spring.facebook.controller;


import eu.codeacademy.spring.facebook.request.CommentRequest;
import eu.codeacademy.spring.facebook.request.PostRequest;
import eu.codeacademy.spring.facebook.request.UserRequest;
import eu.codeacademy.spring.facebook.service.PostEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Secured({"ROLE_ADMIN", "ROLE_USER"})
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final PostEntityService postEntityService;


    @GetMapping()
    public String index(@RequestParam(name = "username") String username,
                        @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                        @RequestParam(name = "pageSize", required = false, defaultValue = "4") int pageSize, Model model) {
        model.addAttribute("postsDB", postEntityService.getAllPostEntitiesPageableByUser(pageNumber, pageSize, username));
        model.addAttribute("postAtt", new PostRequest());
        model.addAttribute("commentAtt", new CommentRequest());
        model.addAttribute("searchUser", new UserRequest());
        return "home";
    }

}
