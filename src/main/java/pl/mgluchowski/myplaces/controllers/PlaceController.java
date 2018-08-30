package pl.mgluchowski.myplaces.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mgluchowski.myplaces.domain.User;
import pl.mgluchowski.myplaces.services.UserService;

@Controller
@Scope("singleton")
public class PlaceController {

    @Autowired
    UserService placeService;

    @RequestMapping("/myplaces")
    public String myplaces(Model model) {
        return "myplaces";
    }

//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @RequestMapping(value = {"/myplaces"}  ,method = RequestMethod.GET)
//    public String myplaces(Model model) {
//        return "myplaces";
//    }

}