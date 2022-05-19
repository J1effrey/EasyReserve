package uw.css533.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uw.css533.dao.UserDao;
import uw.css533.entity.User;
import uw.css533.service.IUserService;

import java.util.List;

/**
 * @author yifei yang
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

    @Override
    public boolean addUser(User user) {
        return this.save(user);
    }

    @Override
    public boolean modify(User user) {
        return this.updateById(user);
    }

    @Override
    public User getUserByUid(Integer id) {
        return this.getById(id);
    }

    @Override
    public boolean delete(Integer id) {
        return true;
    }

    @Override
    public User validateUser(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        queryWrapper.eq("role_id", user.getRoleId());
        User user1 = this.getOne(queryWrapper);
        return user1;
    }

}
