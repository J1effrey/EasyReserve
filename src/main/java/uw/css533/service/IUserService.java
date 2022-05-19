package uw.css533.service;

import com.baomidou.mybatisplus.extension.service.IService;
import uw.css533.entity.User;

/**
 * @author yifei yang
 */
public interface IUserService extends IService<User> {

    boolean addUser(User user);

    boolean modify(User user);

    User getUserByUid(Integer id);

    boolean delete(Integer id);

    User validateUser(User user);
}
