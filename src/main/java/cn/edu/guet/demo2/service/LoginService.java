package cn.edu.guet.demo2.service;

import cn.edu.guet.demo2.dto.LoginDto;
import cn.edu.guet.demo2.vo.UserLoginVO;
import org.springframework.web.bind.annotation.RequestBody;

public interface LoginService {
    UserLoginVO login(@RequestBody LoginDto loginDto);

}
