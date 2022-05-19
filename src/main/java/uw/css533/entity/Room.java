package uw.css533.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author yifei yang
 */
@Data
public class Room {
    @TableId
    private Integer rid;
    private String rname;
    private String rdescription;
    private Integer rcapacity;
}
