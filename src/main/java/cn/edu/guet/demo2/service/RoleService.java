package cn.edu.guet.demo2.service;

import cn.edu.guet.demo2.entity.Role;
import cn.edu.guet.demo2.util.PageRequest;
import cn.edu.guet.demo2.util.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public interface RoleService {
    IPage<Role> getRoleInfoPage(PageRequest pageRequest);

    Result deleteRole(Integer id);
}
