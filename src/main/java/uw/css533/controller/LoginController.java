package uw.css533.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uw.css533.entity.RespBean;
import uw.css533.entity.User;
import uw.css533.service.IUserService;

import javax.servlet.http.HttpSession;

/**
 * @author yifei yang
 */
@RestController
@Slf4j
public class LoginController {

    @Autowired
    private IUserService userService;

    /*@PostMapping("/login")
    public String userLogin(@RequestParam String username,
                            @RequestParam String password,
                            @RequestParam Integer roleId) {
        Subject subject = SecurityUtils.getSubject();

        */
    /*User user1 = userService.validateUser(user);
        System.out.println(user1);
        if (user1 == null) {
            return "/login";
        }
        if (user.getRoleId() == 0) {
            return "haha";
//            return "redirect:/normal/rooms";
        } else if (user.getRoleId() == 1) {
            return "nb";
//            return "redirect:/admin/rooms";
        }
        return "/login";*/
    /*
        return null;
    }*/

    @PostMapping("/login")
    public RespBean userLogin(User user, HttpSession session) {
        User user1 = userService.validateUser(user);
        if (user1 == null) {
            return RespBean.error("user not registerd!");
        }
        if (!user1.getPassword().equals(user.getPassword())) {
            return RespBean.error("wrong password!");
        }
        if (user.getRoleId() == 0) {
            session.setAttribute("uid", user1.getUid());
            session.setAttribute("uname", user1.getUsername());
            log.info("normal user login username#{} password#{}", user1.getUsername(), user1.getPassword());
            return RespBean.ok("user", user1);
        } else if (user.getRoleId() == 1) {
            session.setAttribute("uid", user1.getUid());
            session.setAttribute("uname", user1.getUsername());
            log.info("admin login username#{} password#{}", user1.getUsername(), user1.getPassword());
            return RespBean.ok("admin", user1);
        }
        return RespBean.error("Something went wrong!");
    }


    @PostMapping("/register")
    public RespBean userRegister(User user) {
        User user1 = userService.validateUser(user);
        if (user1 == null) {
            boolean b = userService.addUser(user);
            if (b) {
                log.info("newly registered user! role->{} username:{} password->{}", user.getRoleId() == 0 ? "normal user" : "admin", user.getUsername(), user.getPassword());
                return RespBean.ok("successfully registered!");
            }
            return RespBean.ok("oops! something went wrong");
        } else {
            return RespBean.error("user has been register!");
        }

    }


    @GetMapping("/logout")
    public RespBean logout(HttpSession session) {
        session.invalidate();
        return RespBean.ok("user log out");
    }


}
