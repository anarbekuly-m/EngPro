package kz.engbro.controller;

import kz.engbro.service.PairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
    private final PairService pairService;

    @Autowired
    public DictionaryController(PairService pairService) {
        this.pairService = pairService;
    }

    @GetMapping()
    public String dictionary(Model model) {
        model.addAttribute("words", pairService.findAll());
        return "dictionary";
    }
}