package eu.codeacademy.spring.facebook.controller;


import eu.codeacademy.spring.facebook.request.UserRequest;
import eu.codeacademy.spring.facebook.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Secured("ROLE_ANONYMOUS")
@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
@Slf4j
public class RegisterController {

    private final UserEntityService userEntityService;

    @PostMapping
    public String registerUser(@ModelAttribute("user") @Valid UserRequest userRequest, BindingResult result) {
        if (result.hasErrors()) {
            log.info("Fill register form better boi");
            return "/login";
        }
        userEntityService.registerUser(userRequest);
        return "redirect:/login";
    }

}
