package model;

/**
 * Created by TaoHaoWei on 2018/5/20.
 * 本人新建博客：www.mynight.top
 * 欢迎交友和指正 ^_^
 * 存储博客正文
 */
public class BlogContext {

    /**
     * 博客Id
     */
    private Integer id;

    /**
     * 博客正文
     */
    private String context;


    public BlogContext() {

    }

    public BlogContext(Integer id, String context) {
        this.id = id;
        this.context = context;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
