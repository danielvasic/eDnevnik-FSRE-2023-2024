package ba.sum.fsre.ednevnik.controllers;

import ba.sum.fsre.ednevnik.models.User;
import ba.sum.fsre.ednevnik.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/auth/register")
    public String add (Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "users/register";
    }

    @PostMapping("/auth/register")
    public String newUser (@Valid User user, BindingResult result, Model model){
        boolean errors = result.hasErrors();
        if (errors){
            model.addAttribute("user", user);
            return "users/register";
        }
        userRepo.save(user);
        return "redirect:/auth/register";
    }
}
