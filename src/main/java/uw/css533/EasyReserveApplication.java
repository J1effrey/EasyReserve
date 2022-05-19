package uw.css533;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan({"uw.css533.dao", "uw.css533.mapper"})
@MapperScan({"uw.css533.dao"})
public class EasyReserveApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyReserveApplication.class, args);
    }

}
