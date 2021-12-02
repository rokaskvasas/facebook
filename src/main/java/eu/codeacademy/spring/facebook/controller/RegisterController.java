package eu.codeacademy.spring.facebook.controller;


import eu.codeacademy.spring.facebook.request.UserRequest;
import eu.codeacademy.spring.facebook.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Secured("ROLE_ANONYMOUS")
@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final UserEntityService userEntityService;

    @PostMapping
    public String registerUser(@ModelAttribute("user") UserRequest userRequest, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        }
        userEntityService.registerUser(userRequest);
        return "redirect:/login";
    }
}
