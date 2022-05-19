package uw.css533.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import uw.css533.entity.User;

import java.util.List;

/**
 * @author yifei yang
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
