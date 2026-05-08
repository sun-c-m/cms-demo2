package cn.edu.guet.demo2.vo;

import cn.edu.guet.demo2.entity.Permission;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserLoginVO {
    private Integer id;
    private String username;
    private String token;
    private LocalDateTime tokenExpireAt;
    // 原始权限列表（包含按钮，用于权限校验）
    private List<Permission> permissionList;
    // 树形菜单列表（仅包含目录和菜单，用于前端侧边栏展示）
    private List<Permission> menuTree;
}
