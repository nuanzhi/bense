package com.lsege.service.sys;

import com.lsege.entity.Menu;
import com.lsege.entity.Role;

import java.util.List;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/5/3
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
public interface MenuService {

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
