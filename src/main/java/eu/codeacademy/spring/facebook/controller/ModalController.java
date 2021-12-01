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
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/modal")
@RequiredArgsConstructor
public class ModalController {

    private final UserEntityService userEntityService;

    private final PostEntityService postEntityService;

    private final CommentEntityService commentEntityService;


    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String index(Model model){
        model.addAttribute("postsDB", postEntityService.getAllPostEntities());
        model.addAttribute("postAtt", new PostRequest());
        model.addAttribute("commentAtt",new CommentRequest());
        return "index";
    }

    //region PostMapping

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String registerUser(@ModelAttribute("user") UserRequest userRequest, BindingResult result) {
        if(result.hasErrors()){
            return "error";
        }
        userEntityService.registerUser(userRequest);
        return "redirect:/login";
    }
    @PostMapping("/createpost")
    @ResponseStatus(HttpStatus.CREATED)
    public String createPost(@ModelAttribute("postAtt") PostRequest postRequest, BindingResult result,
                             @AuthenticationPrincipal UserPrincipal principal){
        if(result.hasErrors()){
            return "error";
        }
        postRequest.setUserId(principal.getUserId());
        postEntityService.createNewPost(postRequest);
        return "redirect:/modal";
    }

    @PostMapping("/createcomment")
    @ResponseStatus(HttpStatus.CREATED)
    public String createComment(@ModelAttribute("commentAtt")CommentRequest commentRequest,BindingResult result,
                                @AuthenticationPrincipal UserPrincipal principal){
        if(result.hasErrors()){
            return "error";
        }
        commentRequest.setUserId(principal.getUserId());
        commentEntityService.createNewComment(commentRequest);
        return "forward:index";
    }

    //endregion


    //region PutMapping

    @PutMapping("/editpost")
    @ResponseStatus(HttpStatus.OK)
    public String editPost(@ModelAttribute("postAtt") PostRequest postRequest, BindingResult result,
                           @AuthenticationPrincipal UserPrincipal principal){
        if(result.hasErrors()){
            return "error";
        }
        postRequest.setUserId(principal.getUserId());
        postEntityService.editPost(postRequest);
        return "forward:index";
    }

    @PutMapping("/editcomment")
    @ResponseStatus(HttpStatus.OK)
    public String editComment(@ModelAttribute("commentAtt") CommentRequest commentRequest, BindingResult result,
                              @AuthenticationPrincipal UserPrincipal principal){
        if(result.hasErrors()){
            return "error";
        }
//        commentRequest.setPostId(); TODO:: dunno how..yet
//        commentRequest.setUserId(principal.getUserId()); TODO:: long value as object ??
        commentEntityService.editComment(commentRequest);
//        TODO:: how to forward correct ?? redirect:forward:index ?
        return "forward:index";
    }

    //endregion

    @DeleteMapping("/deletecomment/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteComment(@PathVariable Long commentId){
        commentEntityService.deleteCommentEntity(commentId);
        return "forward:index";
    }
}
