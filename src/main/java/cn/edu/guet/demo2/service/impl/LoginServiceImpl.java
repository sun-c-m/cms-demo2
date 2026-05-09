package cn.edu.guet.demo2.service.impl;
import cn.edu.guet.demo2.dto.LoginDto;
import cn.edu.guet.demo2.entity.MenuType;
import cn.edu.guet.demo2.entity.Permission;
import cn.edu.guet.demo2.mapper.LoginMapper;
import cn.edu.guet.demo2.service.LoginService;
import cn.edu.guet.demo2.vo.UserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override

    public UserLoginVO login(LoginDto loginDto) {
        UserLoginVO loginVO = loginMapper.login(loginDto);
        log.info("loginVO的信息：{}",loginVO);
        if (loginVO == null) {
            throw new RuntimeException("用户名或密码错误");
        }
        // 2. 优化：只在这里构建一次菜单树
        if (loginVO.getPermissionList() != null) {
            List<Permission> menuTree = buildMenuTree(loginVO.getPermissionList());
            loginVO.setMenuTree(menuTree);
        }
        return loginVO;
    }
    /**
     * 构建菜单树（过滤按钮，进行排序）
     */
    private List<Permission> buildMenuTree(List<Permission> permissions) {
        // 1. 过滤掉“按钮”类型的权限
        List<Permission> menus = permissions.stream()
                .filter(p -> p.getMenuType() != null && !p.getMenuType().equals(MenuType.BUTTON))
                .collect(Collectors.toList());

        List<Permission> tree = new ArrayList<>();
        for (Permission menu : menus) {
            // 2. 找到顶级节点
            if (menu.getParentId() == 0) {
                tree.add(findChildren(menu, menus));
            }
        }
        // 3. 顶级节点排序
        tree.sort(Comparator.comparing(Permission::getSort, Comparator.nullsLast(Integer::compareTo)));
        return tree;
    }
    /**
     * 递归寻找子节点
     */
    private Permission findChildren(Permission parent, List<Permission> allMenus) {
        parent.setChildren(new ArrayList<>());
        for (Permission it : allMenus) {
            if (parent.getId().equals(it.getParentId())) {
                parent.getChildren().add(findChildren(it, allMenus));
            }
        }
        // 子节点排序
        parent.getChildren().sort(Comparator.comparing(Permission::getSort, Comparator.nullsLast(Integer::compareTo)));
        return parent;
    }
}
