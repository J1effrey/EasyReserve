package uw.css533.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import uw.css533.dao.ReservationDao;
import uw.css533.entity.Reservation;
import uw.css533.service.IReservationService;
import uw.css533.utils.Status;

import java.util.List;

/**
 * @author yifei yang
 */
@Service
public class ReservationServiceImpl extends ServiceImpl<ReservationDao, Reservation> implements IReservationService {


    @Override
    public boolean addTimeSlots(Reservation reservation) {
        return false;
    }

    @Override
    public boolean updateReservation(Reservation reservation) {
        return false;
    }

    @Override
    public boolean bookReservation(Integer id, Integer uid) {
        UpdateWrapper<Reservation> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        updateWrapper.set("sid", 1);
        updateWrapper.set("uid", uid);
        return this.update(updateWrapper);
    }

    @Override
    public boolean approveReservation(Integer id) {
        UpdateWrapper<Reservation> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        updateWrapper.set("sid", 2);
        return this.update(updateWrapper);
    }

    @Override
    public List<Reservation> getAllReservationsByStatus(int statusId) {
        QueryWrapper<Reservation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sid", statusId);
        List<Reservation> list = this.list(queryWrapper);
        return list;
    }

    @Override
    public List<Reservation> getAllReservationsByUserId(Integer uid) {
        QueryWrapper<Reservation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", uid);
        queryWrapper.eq("sid", Status.RESERVED).or().eq("sid", Status.PENDING);
        queryWrapper.orderByAsc("date");
        queryWrapper.orderByAsc("begintime");
        List<Reservation> list = this.list(queryWrapper);
        return list;
    }

    @Override
    public boolean addReservation(Reservation reservation) {
        return this.save(reservation);
    }

    @Override
    public boolean cancelReservation(Integer id) {
        UpdateWrapper<Reservation> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        updateWrapper.set("uid", null);
        updateWrapper.set("sid", 0);
        return this.update(updateWrapper);
    }

}
