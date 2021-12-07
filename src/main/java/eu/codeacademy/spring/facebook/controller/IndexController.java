package eu.codeacademy.spring.facebook.controller;


import eu.codeacademy.spring.facebook.request.CommentRequest;
import eu.codeacademy.spring.facebook.request.PostRequest;
import eu.codeacademy.spring.facebook.request.UserRequest;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Controller
@RequestMapping("/index")
@RequiredArgsConstructor
public class IndexController {

    private final PostEntityService postEntityService;



    @GetMapping
    public String index(Model model,
                        @RequestParam(name = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                        @RequestParam(name = "pageSize", required = false, defaultValue = "3") int pageSize) {
        model.addAttribute("postsDB", postEntityService.getAllPostEntitiesPageable(pageNumber, pageSize));
        model.addAttribute("postAtt", new PostRequest());
        model.addAttribute("commentAtt",new CommentRequest());
        model.addAttribute("searchUser", new UserRequest());
        int totalPages = postEntityService.getAllPostEntitiesPageable(pageNumber, pageSize).getTotalPages();
        if(totalPages >0){
            List<Integer> totalPageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("totalPageNumbers", totalPageNumbers);
        }

        return "index";
    }

//    TODO:: PADARYTI CSS FOR PAGES
}
