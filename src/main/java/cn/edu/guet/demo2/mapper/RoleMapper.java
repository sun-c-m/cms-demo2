package cn.edu.guet.demo2.mapper;

import cn.edu.guet.demo2.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getRoleInfoPage();
}
