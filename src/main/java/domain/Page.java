package domain;


import java.io.Serializable;

/**
 * Created by Administrator on 2016-10-8.
 */
public class Page implements Serializable {
    //当前页码
    private int pageNo = 1;
    //启始行号
    private int startNo;
    //每页长度
    private int length  = 20;
    //总页数
    private int total;
    //总记录数
    private int count;
    public Page() {
    }

    public Page(int pageNo, int count) {
        this.count = count;
        this.total =(count/this.length) + (count%this.length >0 ? 1:0);
        this.pageNo = pageNo;
    }

    public Page(int pageNo, int length, int count) {
        this.length = length;
        this.count = count;
        this.total =(count/this.length) + (count%this.length >0 ? 1:0);
        this.pageNo = pageNo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStartNo() {
        return startNo;
    }

    public void setStartNo(int startNo) {
        this.startNo = startNo;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
        this.startNo = pageNo == 1 ? 0 : (pageNo-1)*this.length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTotal() {
        return this.total ;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
