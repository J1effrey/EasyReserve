package uw.css533.service;

import com.baomidou.mybatisplus.extension.service.IService;
import uw.css533.entity.Reservation;

import java.util.List;

/**
 * @author yifei yang
 */
public interface IReservationService extends IService<Reservation> {

    boolean addTimeSlots(Reservation reservation);

    boolean updateReservation(Reservation reservation);

    boolean bookReservation(Integer id, Integer uid);

    boolean approveReservation(Integer id);

    List<Reservation> getAllReservationsByStatus(int statusId);

    List<Reservation> getAllReservationsByUserId(Integer uid);

    boolean addReservation(Reservation reservation);

    boolean cancelReservation(Integer id);

}
