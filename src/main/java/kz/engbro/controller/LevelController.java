package kz.engbro.controller;

import kz.engbro.entity.model.User;
import kz.engbro.service.AuthService;
import kz.engbro.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/level")
public class LevelController {

    private final QuestionService questionService;
    private final AuthService authService;

    @Autowired
    public LevelController(QuestionService questionService, AuthService authService) {
        this.questionService = questionService;
        this.authService = authService;
    }

    @GetMapping
    public String level(Model model) {
        model.addAttribute("questions", questionService.questionList());
        return "level";
    }

}
