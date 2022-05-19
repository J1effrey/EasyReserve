package uw.css533.service;

import com.baomidou.mybatisplus.extension.service.IService;
import uw.css533.entity.Room;

import java.util.List;

/**
 * @author yifei yang
 */
public interface IRoomService extends IService<Room> {

    boolean addRoom(Room room);

    boolean updateRoom(Room room);

    List<Room> getAllRooms();

}
