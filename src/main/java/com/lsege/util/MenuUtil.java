package com.lsege.util;

import com.lsege.entity.Menu;
import org.springframework.util.StringUtils;

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
        /*去除因多角色导致的菜单重复*/
        menus = removeDuplicate(menus);
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

    public static List<Menu> removeDuplicate(List<Menu> list) {

        List<Long> mIds = new ArrayList<>();
        List<Menu> tmpList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(!mIds.contains(list.get(i).getmId())){
                tmpList.add(list.get(i));
                mIds.add(list.get(i).getmId());
            }
        }
        return tmpList;
    }

    public static List<Long> getHasMenu(List<Menu> menus){
        List<Long> objects = new ArrayList<>();

        for (int i = 0; i < menus.size(); i++) {
            if(menus.get(i).getIsHas()==1 && menus.get(i).getSubMenu().size()==0){
                objects.add(menus.get(i).getmId());
            }
            for (int j = 0; j < menus.get(i).getSubMenu().size(); j++) {
                if(menus.get(i).getSubMenu().get(j).getIsHas()==1){
                    objects.add(menus.get(i).getSubMenu().get(j).getmId());
                }
            }
        }
        return objects;
    }

    public static List<String> getInterceptUrl(List<Menu> menus){
        List<String> urls = new ArrayList<>();
        for (Menu m:menus){
            if(!StringUtils.isEmpty(m.getmInterceptUrl())){
                if(!urls.contains(m.getmInterceptUrl())){
                    urls.add(m.getmInterceptUrl());
                }
            }
            for(Menu e:m.getSubMenu()){
                if(!StringUtils.isEmpty(e.getmInterceptUrl())){
                    if(!urls.contains(e.getmInterceptUrl())){
                        urls.add(e.getmInterceptUrl());
                    }
                }
            }
        }
        return urls;
    }

}
