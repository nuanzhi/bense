package com.lsege.mapper.sys;

import com.lsege.entity.sys.Menu;
import com.lsege.entity.sys.Role;
import com.lsege.entity.vo.RMRelate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/24
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
@Mapper
@Repository(value = "roleMapper")
public interface RoleMapper {

    /**
     * 获取该用户的角色
     * @param uId
     * @return
     */
    List<Role> getUserRoles(Long uId);

    List<Role> getRoleList();

    Long getRoleTotal();

    Long addRole(Role role);

    Long removeRole(Long rId);

    Long editRole(Role role);

    Long getUserByRoleId(Long rId);

    List<Menu> associatedMenu(Long rId);

    Long associatedMenuDel(Long rId);

    Long associatedMenuSave(List<RMRelate> data);

    List<Menu> getMenuByRId(Long rId);
}
