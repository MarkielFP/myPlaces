package pl.mgluchowski.myplaces.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mgluchowski.myplaces.domain.User;
import pl.mgluchowski.myplaces.services.UserService;

import javax.validation.Valid;

@Controller
@Scope("singleton")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("newuser", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveUser(@Valid User newuser, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                System.out.println("There were errors");
                bindingResult.getAllErrors().forEach(error -> {
                            System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
                        }
                );
                return "register";
            } else {
                userService.createUser(newuser);
                return "redirect:/login";
            }
    }

}