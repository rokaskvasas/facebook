package eu.codeacademy.spring.facebook.controller;


import eu.codeacademy.spring.facebook.request.CommentRequest;
import eu.codeacademy.spring.facebook.request.PostRequest;
import eu.codeacademy.spring.facebook.security.UserPrincipal;
import eu.codeacademy.spring.facebook.service.CommentEntityService;
import eu.codeacademy.spring.facebook.service.PostEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/index")
@RequiredArgsConstructor
public class IndexController {

    private final PostEntityService postEntityService;

    private final CommentEntityService commentEntityService;



    @GetMapping
    public String index(Model model) {
        model.addAttribute("postsDB", postEntityService.getAllPostEntities());
        model.addAttribute("postAtt", new PostRequest());
        model.addAttribute("commentAtt",new CommentRequest());
        return "index";
    }

}
