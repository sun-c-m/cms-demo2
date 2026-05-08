package cn.edu.guet.demo2.service.impl;

import cn.edu.guet.demo2.entity.Role;
import cn.edu.guet.demo2.mapper.RoleMapper;
import cn.edu.guet.demo2.service.RoleService;
import cn.edu.guet.demo2.util.PageRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public IPage<Role> getRoleInfoPage(PageRequest pageRequest) {

        Page<Role> page = new Page<Role>(pageRequest.getCurrentPage(), pageRequest.getPageSize());
        //查询条件
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",pageRequest.getParamValue("roleName"));
        return roleMapper.selectPage(page,queryWrapper);
//        return roleMapper.getRoleInfoPage();
    }
}
