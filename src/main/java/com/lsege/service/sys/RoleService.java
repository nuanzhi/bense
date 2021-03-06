package com.lsege.service.sys;

import com.lsege.entity.sys.Menu;
import com.lsege.entity.sys.Role;
import com.lsege.entity.vo.RMRelate;

import java.util.List;

/**
 * Created by xuzhongyao on 2017/5/13.
 */
public interface RoleService {

    List<Role> getRoleList();

    Long getRoleTotal();

    Long addRole(Role role);

    Long removeRole(Long rId);

    Long editRole(Role role);

    Long getUserByRoleId(Long rId);

    List<Menu> associatedMenu(Long rId);

    void associatedMenuUpdate(Long rId, List<RMRelate> data);

    List<Menu> getMenuByRId(Long rId);
}
