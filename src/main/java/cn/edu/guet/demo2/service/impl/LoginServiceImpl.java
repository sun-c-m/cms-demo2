package cn.edu.guet.demo2.service.impl;
import cn.edu.guet.demo2.dto.LoginDto;
import cn.edu.guet.demo2.mapper.LoginMapper;
import cn.edu.guet.demo2.service.LoginService;
import cn.edu.guet.demo2.vo.UserLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override

    public UserLoginVO login(LoginDto loginDto) {
loginMapper.login(loginDto);
        return loginMapper.login(loginDto);
    }
}
