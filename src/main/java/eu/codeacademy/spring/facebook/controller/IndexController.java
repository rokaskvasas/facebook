package eu.codeacademy.spring.facebook.controller;


import eu.codeacademy.spring.facebook.request.CommentRequest;
import eu.codeacademy.spring.facebook.request.PostRequest;
import eu.codeacademy.spring.facebook.request.UserRequest;
import eu.codeacademy.spring.facebook.security.UserPrincipal;
import eu.codeacademy.spring.facebook.service.PostEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
@RequestMapping("/index")
@RequiredArgsConstructor
public class IndexController {

    private final PostEntityService postEntityService;


    @GetMapping
    public String index(Model model,
                        @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                        @RequestParam(name = "pageSize", required = false, defaultValue = "3") int pageSize,
                        UserPrincipal userPrincipal) {
        model.addAttribute("postsDB", postEntityService.getAllPostEntitiesPageable(pageNumber, pageSize));
        model.addAttribute("postAtt", new PostRequest());
        model.addAttribute("commentAtt", new CommentRequest());
        model.addAttribute("searchUser", new UserRequest());
        model.addAttribute("userPrincipal", userPrincipal);

        return "index";
    }
}
