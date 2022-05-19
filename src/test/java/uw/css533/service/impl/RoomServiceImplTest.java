package uw.css533.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uw.css533.entity.Room;

import java.util.List;

/**
 * @author yifei yang
 */
@SpringBootTest
public class RoomServiceImplTest {

    @Autowired
    private RoomServiceImpl roomService;

    @Test
    public void testGetAllRooms() {
        System.out.println("get All rooms....");
        List<Room> rooms = roomService.getAllRooms();
        rooms.forEach(System.out::println);
        Assertions.assertEquals(3, rooms.size());
    }

    @Test
    public void testAddRoom() {
        Room room = new Room();
        room.setRid(1003);
        room.setRname("HUSKY-D");
        room.setRdescription("Music");
        room.setRcapacity(100);
        Assertions.assertTrue(roomService.addRoom(room));
    }

    @Test
    public void testUpdateRoom() {
        Room room = new Room();
        room.setRid(1003);
        room.setRname("HUSKY-D");
        room.setRdescription("Music");
        room.setRcapacity(120); // change 100 to 120
        Assertions.assertTrue(roomService.updateRoom(room));
    }
}
