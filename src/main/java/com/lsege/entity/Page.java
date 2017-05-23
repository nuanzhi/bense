package com.lsege.entity;

import com.lsege.entity.sys.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xuzhongyao on 2017/5/23.
 */
public class Page<T> implements Serializable{
    private List<T> list;
    private Long total;
    private Integer pageSize;
    private Integer pageNumber;

    public Page() {
    }

    public Page(List<T> list, Long total, Integer pageSize, Integer pageNumber) {
        this.list = list;
        this.total = total;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
