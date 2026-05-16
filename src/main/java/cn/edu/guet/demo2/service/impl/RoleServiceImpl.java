package cn.edu.guet.demo2.service.impl;

import cn.edu.guet.demo2.entity.Role;
import cn.edu.guet.demo2.mapper.RoleMapper;
import cn.edu.guet.demo2.service.RoleService;
import cn.edu.guet.demo2.util.PageRequest;
import cn.edu.guet.demo2.util.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public IPage<Role> getRoleInfoPage(PageRequest pageRequest) {
        // current：当前页
        // size：每页X条记录
        Page<Role> page = new Page<Role>(pageRequest.getCurrentPage(), pageRequest.getPageSize());

        System.out.println("sssssssssss: " + pageRequest.getParamValue("roleName"));
        // 查询条件
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        if (pageRequest.getParamValue("roleName") != null) {
            queryWrapper.like("name", pageRequest.getParamValue("roleName"));
        }

        return roleMapper.selectPage(page, queryWrapper);
    }

    @Override
    public Result deleteRole(Integer id) {
        log.info("删除角色删除角色删除角色删除角色删除角色删除角色删除角色删除角色删除角色删除角色删除角色删除角色");
        return null;
    }
}
