package cn.edu.guet.demo2.Controller;

import cn.edu.guet.demo2.entity.User;
import cn.edu.guet.demo2.service.UserService;
import cn.edu.guet.demo2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/getUserInfoPage")
    public Result<List<User>> getRoleInfoPage() {
        return Result.success(userService.getUserInfoPage());
    }

}
