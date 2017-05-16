package com.lsege.service.sys;

import com.lsege.entity.Menu;
import com.lsege.entity.Role;
import com.lsege.entity.User;

import java.util.List;

/**
 * Created by xuzhongyao on 2017/5/13.
 */
public interface RoleService {

    List<Role> getRoleList();

    Long addRole(Role role);

    Long removeRole(Long rId);

    Long editRole(Role role);

    Long getUserByRoleId(Long rId);

    List<Menu> associatedMenu(Long rId);
}
