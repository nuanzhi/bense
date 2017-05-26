package com.lsege.entity.servicep;

import java.sql.Timestamp;

/**
 * Created by xuzhongyao on 2017/5/26.
 */
public class Distributor {
    private Long distributorId;
    private String distributorLoginAccount;
    private String distributorLoginPassword;
    private String companyName;
    private String legalpersonName;
    private String companyFixedPhone;
    private String legalpersonPhone;
    private String contactName;
    private String contactPhone;
    private String businessLicense;
    private String legalpersonIdcardFront;
    private String legalpersonIdcardBack;
    private Long creator;
    private Timestamp createTime;
    private Integer status;

    public Long getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Long distributorId) {
        this.distributorId = distributorId;
    }

    public String getDistributorLoginAccount() {
        return distributorLoginAccount;
    }

    public void setDistributorLoginAccount(String distributorLoginAccount) {
        this.distributorLoginAccount = distributorLoginAccount;
    }

    public String getDistributorLoginPassword() {
        return distributorLoginPassword;
    }

    public void setDistributorLoginPassword(String distributorLoginPassword) {
        this.distributorLoginPassword = distributorLoginPassword;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLegalpersonName() {
        return legalpersonName;
    }

    public void setLegalpersonName(String legalpersonName) {
        this.legalpersonName = legalpersonName;
    }

    public String getCompanyFixedPhone() {
        return companyFixedPhone;
    }

    public void setCompanyFixedPhone(String companyFixedPhone) {
        this.companyFixedPhone = companyFixedPhone;
    }

    public String getLegalpersonPhone() {
        return legalpersonPhone;
    }

    public void setLegalpersonPhone(String legalpersonPhone) {
        this.legalpersonPhone = legalpersonPhone;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getLegalpersonIdcardFront() {
        return legalpersonIdcardFront;
    }

    public void setLegalpersonIdcardFront(String legalpersonIdcardFront) {
        this.legalpersonIdcardFront = legalpersonIdcardFront;
    }

    public String getLegalpersonIdcardBack() {
        return legalpersonIdcardBack;
    }

    public void setLegalpersonIdcardBack(String legalpersonIdcardBack) {
        this.legalpersonIdcardBack = legalpersonIdcardBack;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
