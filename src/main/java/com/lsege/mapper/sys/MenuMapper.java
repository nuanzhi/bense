package com.lsege.mapper.sys;

import com.lsege.entity.Menu;
import com.lsege.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/24
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
@Mapper
@Repository(value = "menuMapper")
public interface MenuMapper {

    /**
     * 获取该角色的菜单
     * @param roleId
     * @return
     */
    List<Menu> getRoleHasMenu(Long roleId);


    List<Menu> getMenuList();

    List<Menu> getTopMenuList();

    List<Menu> getTopMenuListNotRoot();

    List<Menu> getMenuChildById(Long mId);

    List<Menu> getMenuChildByIdNotSelf(Long mId);

    Long addMenu(Menu menu);

    Long removeMenu(Long mId);

    Long editMenu(Menu menu);

    List<Role> getRoleByMid(Long mId);
}
