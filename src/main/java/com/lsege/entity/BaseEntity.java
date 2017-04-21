package com.lsege.entity;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/21
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
public class BaseEntity {

    private Long timestamp;
    private String token;
    private String sign;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
