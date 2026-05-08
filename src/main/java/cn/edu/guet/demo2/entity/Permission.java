package cn.edu.guet.demo2.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Permission {
    private Integer id;
    private String name;
    private MenuType menuType;
    private String code;
    private String path;
    private Integer parentId;
    private List<Permission> children;
    private Integer sort;
    private LocalDateTime createTime;
}
