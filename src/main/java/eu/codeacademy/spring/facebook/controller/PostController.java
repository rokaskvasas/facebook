package eu.codeacademy.spring.facebook.controller;


import eu.codeacademy.spring.facebook.request.PostRequest;
import eu.codeacademy.spring.facebook.security.UserPrincipal;
import eu.codeacademy.spring.facebook.service.PostEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Secured({"ROLE_ADMIN", "ROLE_USER"})
@Slf4j
@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostEntityService postEntityService;

//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PostMapping("/create")
    public String createPost(@ModelAttribute("postAtt") PostRequest postRequest, BindingResult result,
                             @AuthenticationPrincipal UserPrincipal principal) {
        if (result.hasErrors()) {
            return "error";
        }
        postRequest.setUserId(principal.getUserId());
        postEntityService.createNewPost(postRequest);
        log.info("Post created");
        return "redirect:/index";
    }

    @PutMapping("/edit")
    public String editPost(@ModelAttribute("postAtt") PostRequest postRequest, BindingResult result){
        if(result.hasErrors()){
            return "error";
        }
        postEntityService.editPost(postRequest);
        log.info("Post edited");
        return "redirect:/index";
    }

    @DeleteMapping("/delete/{postId}")
    public String deletePost(@PathVariable Long postId){
        postEntityService.deletePostAndComments(postId);
        log.info("Post deleted");
        return "redirect:/index";
    }


//    @PostMapping("/edit")
//    public String editPost(@ModelAttribute("postAtt") PostRequest postRequest, BindingResult result,
//                           @AuthenticationPrincipal UserPrincipal principal){
//        if(result.hasErrors()){
//            return "error";
//        }
//        postRequest.setUserId(principal.getUserId());
//        postEntityService.editPost(postRequest);
//        log.info("Post edited");
//        return "redirect:/index";
//    }
//
//    @PostMapping("/delete/{postId}")
//    public String deletePost(@PathVariable Long postId){
//        postEntityService.deletePost(postId);
//        log.info("Post deleted");
//        return "redirect:/index";
//    }

}
