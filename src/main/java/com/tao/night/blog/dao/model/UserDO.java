package com.tao.night.blog.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created by Administrator on 2017/7/25.
 */
@Data
@TableName("t_user_00")
public class UserDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String realName;

    private String sex;

    private String email;

    private String tel;

    private String qq;

    private String wechat;

}
