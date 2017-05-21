package com.lsege.service.sys;

import com.lsege.entity.sys.Menu;
import com.lsege.entity.sys.Role;
import com.lsege.entity.vo.RMRelate;
import com.lsege.mapper.sys.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xuzhongyao on 2017/5/13.
 */
@Service
public class RoleServiceImpl implements RoleService{


    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> getRoleList() {
        return roleMapper.getRoleList();
    }

    @Override
    public Long addRole(Role role) {
        return roleMapper.addRole(role);
    }

    @Override
    public Long removeRole(Long rId) {
        return roleMapper.removeRole(rId);
    }

    @Override
    public Long editRole(Role role) {
        return roleMapper.editRole(role);
    }

    @Override
    public Long getUserByRoleId(Long rId) {
        return roleMapper.getUserByRoleId(rId);
    }

    @Override
    public List<Menu> associatedMenu(Long rId) {
        return roleMapper.associatedMenu(rId);
    }

    @Override
    @Transactional
    public void associatedMenuUpdate(Long rId,List<RMRelate> data){
        roleMapper.associatedMenuDel(rId);
        if (data.size()!=0) {
            roleMapper.associatedMenuSave(data);
        }
    }

    @Override
    public List<Menu> getMenuByRId(Long rId) {
        return roleMapper.getMenuByRId(rId);
    }


}
