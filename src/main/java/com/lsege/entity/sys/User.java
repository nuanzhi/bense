package com.lsege.entity.sys;

import com.lsege.entity.sys.Role;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/15
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
public class User implements Serializable {


    private Long uId;
    private String uAccount;
    private String uPassword;
    private String uName;
    private Timestamp createTime;
    private Long uStatus;
    private Long uCreator;
    private List<Role> roles;

    public User() {
    }

    public User(String uAccount, String uPassword, String uName,Long uCreator) {
        this.uAccount = uAccount;
        this.uPassword = uPassword;
        this.uName = uName;
        this.uCreator = uCreator;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getuAccount() {
        return uAccount;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Long getuStatus() {
        return uStatus;
    }

    public void setuStatus(Long uStatus) {
        this.uStatus = uStatus;
    }

    public Long getuCreator() {
        return uCreator;
    }

    public void setuCreator(Long uCreator) {
        this.uCreator = uCreator;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
