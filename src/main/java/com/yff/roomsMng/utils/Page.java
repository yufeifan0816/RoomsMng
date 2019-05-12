package com.yff.roomsMng.utils;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public class Page<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long total;
    private List<T> rows;

    public  Page(List<T> rows){
        PageInfo<T> tPageInfo = new PageInfo<T>(rows);
        this.setRows(tPageInfo.getList());
        this.setTotal(tPageInfo.getTotal());
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
