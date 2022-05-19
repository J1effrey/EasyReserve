package uw.css533.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import uw.css533.dao.UserDao;
import uw.css533.entity.User;
import uw.css533.mapper.UserMapper;
import uw.css533.service.IUserService;

import java.util.List;

/**
 * @author yifei yang
 */
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void addUser() {
        System.out.println("Insert a new user......");
        User user = new User(4, "robert", "palmer", 0);
        System.out.println(userService.addUser(user));
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setUid(3);
        user.setUsername("lucy");
        user.setPassword("xyz");
        System.out.println(userService.modify(user));
    }

    @Test
    public void validateUser() {
        System.out.println("Get user by name......");
        User user = new User();
        user.setUsername("lucy");
//        user.setPassword("xyz"); // passed
        user.setRoleId(0);
        user.setPassword("xyzzzz"); // fail
        User user1 = userService.validateUser(user);
        Assertions.assertEquals(user.getPassword(), user1.getPassword());
    }

//    @Test
//    public void getUserByUid() {
//        int id = 1;
//        List<User> users = userMapper.selectByName(id);
//        System.out.println(users);
//    }
}
