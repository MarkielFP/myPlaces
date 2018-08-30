package pl.mgluchowski.myplaces.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mgluchowski.myplaces.domain.User;
import pl.mgluchowski.myplaces.domain.repository.UserRepository;
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
        model.addAttribute("user", new User());
        return "registerform";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                System.out.println("There were errors on registration");
                bindingResult.getAllErrors().forEach(error -> {
                            System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
                        }
                );
                return "registerform";
            } else {
                userService.createUser(user);
                return "redirect:/login";
            }
    }

}