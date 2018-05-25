package model;

/**
 * Created by TaoHaoWei on 2018/5/20.
 * 本人新建博客：www.mynight.top
 * 欢迎交友和指正 ^_^
 * 被禁止掉的ip对象
 */
public class Ban {

    /**
     * 主键自增，id
     */
    private Integer id;

    /**
     * Ip地址
     */
    private String ip;

    /**
     * 是否被禁止，1为禁止，0为非禁止。（默认为1）
     */
    private Integer ban;


    public Ban() {
    }


    public Ban(String ip, Integer ban) {
        this.ip = ip;
        this.ban = ban;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getBan() {
        return ban;
    }

    public void setBan(Integer ban) {
        this.ban = ban;
    }
}
