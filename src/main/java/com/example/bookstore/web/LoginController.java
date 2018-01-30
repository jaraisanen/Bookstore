package com.example.bookstore.web;

import com.example.bookstore.domain.Registeration;
import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class LoginController {
    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "register")
    public String addStudent(Model model) {
        model.addAttribute("register", new Registeration());
        return "register";
    }

    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("register") Registeration registeration, BindingResult bindingResult) {
            String pwd = registeration.getPassword();
            BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
            String hashPwd = bc.encode(pwd);

            User registeringUser = new User();
            registeringUser.setPasswordHash(hashPwd);
            registeringUser.setUsername(registeration.getUsername());
            registeringUser.setRole("USER");

            if (repository.findByUsername(registeration.getUsername()) == null) { // Check if user exists
                repository.save(registeringUser);
            } else {
                bindingResult.rejectValue("username", "err.username", "Username already exists");
                return "register";
            }

        return "redirect:/login";

    }

}
