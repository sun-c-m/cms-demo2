package cn.edu.guet.demo2.entity;

import lombok.Data;

@Data
public class Role {
    private Integer id;//Integer是包装类型，可以用null
    private String name;
}
