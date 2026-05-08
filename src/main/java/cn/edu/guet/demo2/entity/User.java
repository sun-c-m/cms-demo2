package cn.edu.guet.demo2.entity;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
