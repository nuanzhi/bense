package com.lsege.service;


import com.lsege.entity.Menu;
import com.lsege.entity.Role;
import com.lsege.entity.User;
import com.lsege.mapper.LoginMapper;
import com.lsege.mapper.sys.MenuMapper;
import com.lsege.mapper.sys.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/24
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User toLogin(String account) {
        return loginMapper.login(account);
    }

    @Override
    public List<Role> getUserRoles(Long uId) {
        return roleMapper.getUserRoles(uId);
    }

    @Override
    public List<Menu> getRoleHasMenu(Long rId) {
        return menuMapper.getRoleHasMenu(rId);
    }
}
