package com.lsege.util;

import com.lsege.entity.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/5/2
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
public class MenuUtil {


    public static List<Menu> beautifyMenu(List<Menu> menus) {
        List<Menu> hasMenu = new ArrayList<>();
        for (Menu m : menus) {
            if (m.getmPId() == 1) {
                hasMenu.add(m);
            }
        }
        for (Menu mm : hasMenu) {
            for (Menu m : menus) {
                if(Objects.equals(mm.getmId(), m.getmPId())){
                    mm.getSubMenu().add(m);
                }
            }
        }
        return hasMenu;
    }

    public static List<Long> getHasMenu(List<Menu> menus){
        List<Long> objects = new ArrayList<>();
        for (int i = 0; i < menus.size(); i++) {
            if(menus.get(i).getIsHas()==1){
                objects.add(menus.get(i).getmId());
            }
        }
        return objects;
    }

}
