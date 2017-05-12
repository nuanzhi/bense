package com.lsege.service.sys;

import com.lsege.entity.Menu;
import com.lsege.mapper.sys.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/5/3
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenuList() {
        return menuMapper.getMenuList();
    }

    @Override
    public List<Menu> getTopMenuList() {
        return menuMapper.getTopMenuList();
    }

    @Override
    public List<Menu> getMenuChildById(Long mId) {
        return menuMapper.getMenuChildById(mId);
    }

    @Override
    public Long addMenu(Menu menu) {
        return menuMapper.addMenu(menu);
    }
}