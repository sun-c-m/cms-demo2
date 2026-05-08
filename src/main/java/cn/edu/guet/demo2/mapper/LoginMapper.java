package cn.edu.guet.demo2.mapper;

import cn.edu.guet.demo2.dto.LoginDto;
import cn.edu.guet.demo2.vo.UserLoginVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    UserLoginVO login(LoginDto loginDto);
}
