package uw.css533.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uw.css533.entity.Reservation;
import uw.css533.service.IReservationService;
import uw.css533.utils.Status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yifei yang
 */
@SpringBootTest
public class ReservationServiceImplTest {

    @Autowired
    private IReservationService reservationService;

    @Test
    public void testEnum() {
        System.out.println(Status.AVAILABLE);
    }

    @Test
    public void testGetAllPendingReservations() {
        System.out.println("get all pending......");
        List<Reservation> pendingReservations = reservationService.getAllReservationsByStatus(Status.PENDING);
        pendingReservations.forEach(System.out::println);
        Assertions.assertEquals(1, pendingReservations.size());
    }

    @Test
    public void testGetAllAvailableReservations() {
        System.out.println("get all available......");
        List<Reservation> availableReservations = reservationService.getAllReservationsByStatus(Status.AVAILABLE);
        availableReservations.forEach(System.out::println);
        Assertions.assertEquals(6, availableReservations.size());
    }

    @Test
    public void testBookReservations() {
        System.out.println("test book reservations.....");
        int id = 1;
        int uid = 2;
        Assertions.assertTrue(reservationService.bookReservation(id, uid));
    }

    @Test
    public void testApproveReservation() {
        System.out.println("test admin approve reservations...");
        Assertions.assertTrue(reservationService.approveReservation(1));
    }

    @Test
    public void testGetAllReservationsByUserId() {
        System.out.println("test get all reservations By UserId....");
        List<Reservation> allReservationsByUserId = reservationService.getAllReservationsByUserId(2);
        allReservationsByUserId.forEach(System.out::println);
        Assertions.assertEquals(1, allReservationsByUserId.size());
    }

    @Test
    public void testAddReservation() throws ParseException {
        System.out.println("test add reservation....");
        Reservation reservation = new Reservation();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        Date date = dateFormat.parse("2022-05-11");
        Date begintime = timeFormat.parse("15:00:00");
        Date endtime = timeFormat.parse("16:00:00");
        reservation.setDate(date);
        reservation.setBegintime(begintime);
        reservation.setEndtime(endtime);
        reservation.setRoomId(1000);
        reservation.setSid(0);
        Assertions.assertTrue(reservationService.addReservation(reservation));
    }

    @Test
    public void testCancelReservation() {
        Assertions.assertTrue(reservationService.cancelReservation(2));
    }

}
