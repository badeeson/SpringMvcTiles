package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("person", new Person());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Person person, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("firstname", person.getFirstname());
        redirectAttributes.addAttribute("lastname", person.getLastname());
        return "redirect:/submission";
    }

    @GetMapping("/submission")
    public String submissionPage(@ModelAttribute Person person, Model model) {
        model.addAttribute("person", person);
        return "submission";
    }
}
