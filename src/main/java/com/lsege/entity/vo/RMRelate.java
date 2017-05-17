package com.lsege.entity.vo;

import java.io.Serializable;

/**
 * Created by xuzhongyao on 2017/5/17.
 */
public class RMRelate implements Serializable{
    private Long rId;
    private Long mId;

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }
}
