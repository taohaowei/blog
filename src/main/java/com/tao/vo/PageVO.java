package com.tao.vo;

/**
 * Created by Taohaowei on 2017/7/28.
 * 控制页码VO
 */
public class PageVO {
    /**
     * 当前页
     */
    private int nowPage=1;
    /**
     * 总数量
     */
    private int listSize;
    /**
     * 总页码
     */
    private int pageCount;
    /**
     * 每页显示数目
     */
    private int pageSize;
    /**
     * 项目循环开始索引
     */
    private int begin;
    /**
     * 项目循环结束索引
     */
    private int end;

    /**
     * 页码开始索引
     */
    private int beginPage;
    /**
     * 页码结束索引
     */
    private int endPage;

    public PageVO() {
    }

    public PageVO(int nowPage, int listSize, int pageSize) {
        this.nowPage = nowPage;
        this.listSize = listSize;
        setPageSize(pageSize);
    }

    /**
     * 重新根据每页显示项目数量和项目总数量计算  页面总数
     */
    private void reCaculate(){
        setPageCount(getListSize()/getPageSize());
        if(getListSize()%getPageSize()!=0)
            setPageCount(getPageCount()+1);
    }


    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        if(nowPage>getPageCount()&&getPageCount()!=0)
        {
            this.nowPage = getPageCount();
        }else if(nowPage<0)
        {
            this.nowPage = 0;
        }else{
            this.nowPage = nowPage;
        }
    }

    //总页码
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    //项目总长度
    public int getListSize() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }

    /**
     * 第一页0-9 ,第二页10-19
     * @return
     */
    public int getBegin() {
        begin = (getNowPage()-1)*getPageSize();
        return begin;
    }

    public int getEnd() {
        end = getBegin()+getPageSize();
        if (end>listSize)
            end = listSize;
        return end;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        reCaculate();
    }

    public int getBeginPage() {
        if(getNowPage()-4>0)
            return getNowPage()-4;
        else
            return 1;
    }

    public int getEndPage() {
        if (getBeginPage()+9>getPageCount())
            return getPageCount();
        else
            return getBeginPage()+9;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "nowPage=" + nowPage +
                ", listSize=" + listSize +
                ", pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                ", begin=" + getBegin() +
                ", end=" + getEnd() +
                '}';
    }
}
