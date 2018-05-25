package model;

/**
 * Created by Taohaowei on 2017/7/26.
 * 博客文章分类，mysql、java、计算机网络、等等
 */
public class BlogType {
    /**
     * 博客文章分类id，自增
     */
    private int                     id;
    /**
     * 博客文章分类名称
     */
    private String                  typeName;

    public BlogType() {
    }

    public BlogType(String typeName) {
        this.typeName = typeName;
    }

    public BlogType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "BlogType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
