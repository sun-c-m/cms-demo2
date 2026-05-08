package cn.edu.guet.demo2.Controller;
import cn.edu.guet.demo2.dto.LoginDto;
import cn.edu.guet.demo2.service.LoginService;
import cn.edu.guet.demo2.util.Result;
import cn.edu.guet.demo2.vo.UserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth")
@Slf4j
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    @ResponseBody
    public Result<Object> login(@RequestBody LoginDto loginDto ){
        log.info("用户名:{},密码:{}",loginDto.getUsername(),loginDto.getPassword());
       UserLoginVO loginVO=loginService.login(loginDto);
       if(loginVO!=null){
           return Result.success("success",loginVO);
       }
       return Result.fail(401,"failed");
    }
}
