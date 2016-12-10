package com.kim.sshstudy.pageModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 伟阳 on 2016/1/31.
 */
public class DataGrid implements Serializable {
    private Long total = 0L;
    private List<User> rows = new ArrayList<User>();

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<User> getRows() {
        return rows;
    }

    public void setRows(List<User> rows) {
        this.rows = rows;
    }
}
