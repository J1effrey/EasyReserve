package uw.css533.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yifei yang
 */
@Configuration
@MapperScan("uw.css533.mapper")
public class DaoConfiguration {

}
