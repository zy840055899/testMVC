package com.test.entity.page;

/**
 * Created by zhengying on 2017/5/3.
 */
public class Page {
    //起始页码
    private int startPage = 1;
    //单页row
    private int pageSize = 3;
    //总row
    private int totalRows;
    //总page
    private int totalPage;

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalPage() {
        this.totalPage = totalRows % pageSize == 0 ? totalRows / pageSize : totalRows / pageSize + 1;
        return totalPage;
    }

//    public void setTotalPage(int totalPage) {
//        this.totalPage = totalPage;
//    }

    @Override
    public String toString() {
        return "Page{" +
                "startPage=" + startPage +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                ", totalPage=" + totalPage +
                '}';
    }
}
