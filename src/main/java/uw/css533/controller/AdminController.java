package uw.css533.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uw.css533.entity.Reservation;
import uw.css533.entity.RespBean;
import uw.css533.entity.Room;
import uw.css533.service.IReservationService;
import uw.css533.service.IRoomService;
import uw.css533.utils.Status;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author yifei yang
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private IRoomService roomService;

    /**
     * Find all pending reservations
     * @return reservations
     */
    @GetMapping("/reservations")
    public RespBean findAllPendingReservations() {
        log.info("Admin request all pending reservations");
        return RespBean.ok("get all successful", reservationService.getAllReservationsByStatus(Status.PENDING));
    }

    @PutMapping("/reservation/{id}")
    public RespBean reviewReservation(@PathVariable Integer id, HttpSession session) {
        boolean b = reservationService.approveReservation(id);
        if (b) {
            log.info("[admin]{} approved reservation with id:{}", session.getAttribute("uname"), id);
            return RespBean.ok("review succeed");
        }
        return RespBean.error("review fails");
    }





    @PutMapping("/reservation")
    public RespBean updateReservation(Reservation reservation) {
        boolean b = reservationService.updateReservation(reservation);
        if (b) {
            return RespBean.ok("succeed updating reservation");
        }
        return RespBean.error("fail to update  reservation");
    }


}
