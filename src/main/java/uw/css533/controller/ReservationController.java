package uw.css533.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uw.css533.entity.Reservation;
import uw.css533.entity.RespBean;
import uw.css533.service.IReservationService;
import uw.css533.utils.Status;

import javax.servlet.http.HttpSession;

/**
 * @author yifei yang
 */
@RestController
@Slf4j
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @GetMapping("/reservations")
    public RespBean findAllAvailableReservations(HttpSession session) {
        log.info("User {} request all available reservations", session.getAttribute("uname"));
        return RespBean.ok("Successfully get all reservations", reservationService.getAllReservationsByStatus(Status.AVAILABLE));
    }

    @PutMapping("/reservation/{id}")
    public RespBean bookReservation(@PathVariable Integer id, HttpSession session) {
        Integer uid = (Integer) session.getAttribute("uid");
        boolean b = reservationService.bookReservation(id, uid);
        if (b) {
            log.info("User {} book the reservation with id-{}", session.getAttribute("uname"), id);
            return RespBean.ok("Successfully reserve");
        }
        return RespBean.error("Fail to reserve");
    }

    @PostMapping("/reservation")
    public RespBean addNewReservation(Reservation reservation, HttpSession session) {
        boolean b = reservationService.addReservation(reservation);
        if (b) {
            log.info("Admin {} successfully post new reservation", session.getAttribute("uname"));
            return RespBean.ok("succeed adding new reservation");
        }
        return RespBean.error("fail to add new reservation");
    }
}
