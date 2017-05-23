package com.lsege.entity.sys;

import java.util.List;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/24
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
public class Role {
    private Long rId;
    private String rName;
    private Long isHas;

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public Long getIsHas() {
        return isHas;
    }

    public void setIsHas(Long isHas) {
        this.isHas = isHas;
    }
}
