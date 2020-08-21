package com.huadi.toolUtil;

/**
 * @author 刘杰
 * @description 分页实体类
 * @date 2020/8/12 10:41
 * start:起始序号
 * size：一页可放的条数
 */
public class QueryVo {
    private int start;
    private int size=3;
    public QueryVo() {
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
