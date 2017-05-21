package com.lsege.service;

import com.lsege.entity.sys.Menu;
import com.lsege.entity.sys.Role;
import com.lsege.entity.sys.User;

import java.util.List;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/24
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
public interface LoginService {

    User toLogin(String account);

    List<Role> getUserRoles(Long uId);

    List<Menu> getRoleHasMenu(Long rId);

}
