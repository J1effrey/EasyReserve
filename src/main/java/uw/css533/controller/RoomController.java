package uw.css533.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uw.css533.entity.RespBean;
import uw.css533.entity.Room;
import uw.css533.service.IRoomService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author yifei yang
 */
@RestController
@Slf4j
public class RoomController {

    @Autowired
    private IRoomService roomService;

    @GetMapping("/rooms")
    public RespBean getAllRooms(HttpSession session) {
        List<Room> allRooms = roomService.getAllRooms();
        log.info("user {} request all rooms", session.getAttribute("uname"));
        return RespBean.ok("get all rooms", allRooms);
    }

    @GetMapping("room/{roomId}/reservations")
    public RespBean getAvailableReservationsByRoomId(@PathVariable Integer roomId) {
        return null;
    }

    @PostMapping("/room")
    public RespBean postNewRoom(Room room) {
        boolean b = roomService.addRoom(room);
        if (b) {
            return RespBean.ok("succeed posting new room");
        }
        return RespBean.error("fail to post new room");
    }

    @PutMapping("/room")
    public RespBean updateRoomInfo(Room room) {
        boolean b = roomService.updateRoom(room);
        if (b) {
            return RespBean.ok("succeed updating the room");
        }
        return RespBean.error("fail to update the room");
    }
}
