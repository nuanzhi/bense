package com.lsege.entity.vo;

import java.io.Serializable;

/**
 * Created by xuzhongyao on 2017/5/21.
 */
public class URRelate implements Serializable {
    private Long uId;
    private Long rId;

    public URRelate() {
    }

    public URRelate(Long uId, Long rId) {
        this.uId = uId;
        this.rId = rId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }
}
