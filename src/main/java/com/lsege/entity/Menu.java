package com.lsege.entity;

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
}
