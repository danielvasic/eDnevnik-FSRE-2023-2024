package ba.sum.fsre.ednevnik.controllers;

import ba.sum.fsre.ednevnik.models.User;
import ba.sum.fsre.ednevnik.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/users/add")
    public String add (Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "users/add";
    }

    @PostMapping("/users/add")
    public String newUser (User user, BindingResult result, Model model){
        userRepo.save(user);
        return "redirect:/users/add";
    }
}
