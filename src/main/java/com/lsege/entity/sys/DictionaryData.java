package com.lsege.entity.sys;

/**
 * Created by zhanglei on 2017/5/22.
 */
public class DictionaryData {
    private Long id;
    private Long dictValue;
    private String dictDataName;
    private String dictDataValue;
    private Long  isFixed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDictValue() {
        return dictValue;
    }

    public void setDictValue(Long dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictDataName() {
        return dictDataName;
    }

    public void setDictDataName(String dictDataName) {
        this.dictDataName = dictDataName;
    }

    public String getDictDataValue() {
        return dictDataValue;
    }

    public void setDictDataValue(String dictDataValue) {
        this.dictDataValue = dictDataValue;
    }

    public Long getIsFixed() {
        return isFixed;
    }

    public void setIsFixed(Long isFixed) {
        this.isFixed = isFixed;
    }


}