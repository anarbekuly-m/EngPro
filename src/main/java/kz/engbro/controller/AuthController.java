package kz.engbro.controller;

import kz.engbro.entity.model.User;
import kz.engbro.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "signUp";
    }
    @GetMapping("/logout")
    public String logout() {
        AuthService.USER = null;
        return "redirect:logout";
    }

    @GetMapping("/signIn")
    public String signIn() {
        return "signIn";
    }

    @PostMapping("/signIn")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model){
        User user = authService.check(username, password);
        System.out.println(user.getId());
        if(user == null){
            return "signIn";
        }
        System.out.println(user.getId() + " and " + user.getUsername());
        authService.USER = authService.findById(username);
        model.addAttribute("user", authService.findById(username));
        return "navList";
    }

    @PostMapping("/signUp")
    public String saveUser(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        authService.save(username, password);
        return signIn();
    }

    private UserDetails loggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails) authentication.getPrincipal();
    }
}
