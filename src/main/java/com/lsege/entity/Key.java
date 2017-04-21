package com.lsege.entity;

import java.io.Serializable;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/18
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
public class Key implements Serializable{

    public Key(String publicKey, String privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    private String publicKey;
    private String privateKey;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}
