package cn.edu.guet.demo2.mapper;

import cn.edu.guet.demo2.entity.Role;
import cn.edu.guet.demo2.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    public List<User>  getUserInfoPage();
}
