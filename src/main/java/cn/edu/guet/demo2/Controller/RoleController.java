package cn.edu.guet.demo2.Controller;
import cn.edu.guet.demo2.entity.Role;
import cn.edu.guet.demo2.service.RoleService;
import cn.edu.guet.demo2.util.PageRequest;
import cn.edu.guet.demo2.util.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController//标记这是个接口类，返回json数据
@RequestMapping("/api/role")//一级路径
public class RoleController {
@Autowired
    private RoleService roleService;
    @PostMapping("/getRoleInfoPage")//二级路径+请求方式为Post
    public Result<IPage<Role>> getRoleInfoPage(@RequestBody PageRequest pageRequest){
        log.info("前端的分页残数：{}，{}",pageRequest.getCurrentPage(),pageRequest.getPageSize());
        return Result.success(roleService.getRoleInfoPage(pageRequest));
    }

}
