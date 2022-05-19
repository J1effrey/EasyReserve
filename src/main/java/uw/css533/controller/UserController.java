package uw.css533.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uw.css533.entity.RespBean;
import uw.css533.entity.User;
import uw.css533.service.IReservationService;
import uw.css533.service.IUserService;

import javax.servlet.http.HttpSession;

/**
 * @author yifei yang
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private IUserService userService;


    @PutMapping
    public RespBean updateInfo(User user, HttpSession session) {
        RespBean respBean = this.getUserByUid(session);
        User oldUser = (User) respBean.getObj();
        boolean b = userService.modify(user);
        if (b) {
            log.info("user {} changed password from {} to {}", session.getAttribute("uname"), oldUser.getPassword(), user.getPassword());
            return RespBean.ok("update successful");
        }
        return RespBean.error("update fails");
    }

    @GetMapping
    public RespBean getUserByUid(HttpSession session) {
        Integer id = (Integer) session.getAttribute("uid");
        User userByUid = userService.getUserByUid(id);
        if (userByUid == null) {
            return RespBean.error("no matched user found");
        }
        return RespBean.ok("found User", userByUid);
    }

    @PutMapping("/reservation/{id}")
    public RespBean cancelReservation(@PathVariable Integer id, HttpSession session) {
        // Session:TODO
        boolean b = reservationService.cancelReservation(id);
        if (b) {
            log.info("user-{} canceled reservation with id-{}", session.getAttribute("uname"), id);
            return RespBean.ok("succeed canceling my reservation");
        }
        return RespBean.error("fail to cancel my reservation");

    }

    @GetMapping("/reservations")
    public RespBean getMyReservations(HttpSession session) {
        // Session:TODO
        Integer id = (Integer) session.getAttribute("uid");
        System.out.println(id);
        return RespBean.ok("get all my reservations", reservationService.getAllReservationsByUserId(id));
    }
}
