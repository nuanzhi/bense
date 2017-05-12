package com.lsege.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/24
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
public class Menu {
    private Long mId;
    private String mName;
    private String mUrl;
    private Long mPId;
    private String mTag;//标记顶级菜单和二级菜单
    private List<Menu> subMenu = new ArrayList<>();

    public Menu() {
    }

    public Menu(String mName, String mUrl, Long mPId, String mTag) {
        this.mName = mName;
        this.mUrl = mUrl;
        this.mPId = mPId;
        this.mTag = mTag;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public Long getmPId() {
        return mPId;
    }

    public void setmPId(Long mPId) {
        this.mPId = mPId;
    }

    public String getmTag() {
        return mTag;
    }

    public void setmTag(String mTag) {
        this.mTag = mTag;
    }

    public List<Menu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<Menu> subMenu) {
        this.subMenu = subMenu;
    }
}
