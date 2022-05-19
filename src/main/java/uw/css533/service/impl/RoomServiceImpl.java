package uw.css533.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import uw.css533.dao.RoomDao;
import uw.css533.entity.Room;
import uw.css533.service.IRoomService;

import java.util.List;

/**
 * @author yifei yang
 */
@Service
public class RoomServiceImpl extends ServiceImpl<RoomDao, Room> implements IRoomService {

    @Override
    public boolean addRoom(Room room) {
        return this.save(room);
    }

    @Override
    public boolean updateRoom(Room room) {
        return this.updateById(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return this.list();
    }
}
