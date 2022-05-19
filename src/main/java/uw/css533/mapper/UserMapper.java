package uw.css533.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import uw.css533.entity.User;

import java.util.List;

/**
 * @author yifei yang
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
//    List<User> selectByName(@Param("id") Integer id);
}
