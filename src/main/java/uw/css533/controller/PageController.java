package uw.css533.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yifei yang
 */
@Controller
public class PageController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public String adminHome() {
        return "admin/home";
    }

    @RequestMapping(value = "/changePwd", method = RequestMethod.GET)
    public String changePwd() {
        return "user/password";
    }

    @RequestMapping(value = "/myReservations", method = RequestMethod.GET)
    public String showAllMyReservations() {
        return "user/reservation";
    }

}
