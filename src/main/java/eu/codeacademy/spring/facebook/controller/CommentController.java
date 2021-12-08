package eu.codeacademy.spring.facebook.controller;

import eu.codeacademy.spring.facebook.request.CommentRequest;
import eu.codeacademy.spring.facebook.security.UserPrincipal;
import eu.codeacademy.spring.facebook.service.CommentEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Secured({"ROLE_ADMIN", "ROLE_USER"})
@Controller
@Slf4j
@RequestMapping("comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentEntityService commentEntityService;

    @PostMapping("/create")
    public String createComment(@ModelAttribute("commentAtt") CommentRequest commentRequest, BindingResult result,
                                @AuthenticationPrincipal UserPrincipal principal) {
        if (result.hasErrors()) {
            return "error";
        }
        commentRequest.setUserId(principal.getUserId());
        commentEntityService.createNewComment(commentRequest);
        return "redirect:/index";

    }

    @PutMapping("/edit")
    public String editComment(@ModelAttribute("commentAtt") CommentRequest commentRequest, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        }
        commentEntityService.editComment(commentRequest);
        return "redirect:/index";
    }

    @DeleteMapping("/delete/{commentId}")
    public String deleteComment(@PathVariable Long commentId) {
        commentEntityService.deleteComment(commentId);
        return "redirect:/index";
    }
}
