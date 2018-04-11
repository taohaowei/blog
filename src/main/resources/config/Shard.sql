drop database if exists blog_00;
drop database if exists blog_01;

create database blog_00;
create database blog_01;



CREATE TABLE blog_00.t_user_00 (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `realname` varchar(32) NOT NULL COMMENT '姓名',
  `sex` varchar(2) NOT NULL COMMENT '性别',
  `email` varchar(32) NOT NULL COMMENT '邮箱',
  `tel` varchar(32) NOT NULL COMMENT '电话',
  `qq` varchar(32) NOT NULL COMMENT 'QQ',
  `wechat` varchar(32) NOT NULL COMMENT '微信',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE blog_00.t_user_01 (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `realname` varchar(32) NOT NULL COMMENT '姓名',
  `sex` varchar(2) NOT NULL COMMENT '性别',
  `email` varchar(32) NOT NULL COMMENT '邮箱',
  `tel` varchar(32) NOT NULL COMMENT '电话',
  `qq` varchar(32) NOT NULL COMMENT 'QQ',
  `wechat` varchar(32) NOT NULL COMMENT '微信',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE blog_01.t_user_02 (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `realname` varchar(32) NOT NULL COMMENT '姓名',
  `sex` varchar(2) NOT NULL COMMENT '性别',
  `email` varchar(32) NOT NULL COMMENT '邮箱',
  `tel` varchar(32) NOT NULL COMMENT '电话',
  `qq` varchar(32) NOT NULL COMMENT 'QQ',
  `wechat` varchar(32) NOT NULL COMMENT '微信',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE blog_01.t_user_03 (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `realname` varchar(32) NOT NULL COMMENT '姓名',
  `sex` varchar(2) NOT NULL COMMENT '性别',
  `email` varchar(32) NOT NULL COMMENT '邮箱',
  `tel` varchar(32) NOT NULL COMMENT '电话',
  `qq` varchar(32) NOT NULL COMMENT 'QQ',
  `wechat` varchar(32) NOT NULL COMMENT '微信',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE blog_00.t_blog_00 (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '博客id，主键、索引、自增',
  `title` text COMMENT '博客标题',
  `summary` text COMMENT '博客摘要',
  `createTime` datetime DEFAULT NULL COMMENT '博客创建时间',
  `type` varchar(1) DEFAULT NULL COMMENT '博客类型，1原创、2转载、3翻译',
  `blogType` varchar(255) DEFAULT NULL COMMENT '博客 文章分类',
  `viewCount` int(10) DEFAULT NULL COMMENT '阅读量',
  `commentCount` int(10) DEFAULT NULL COMMENT '评论量',
  `context` longtext COMMENT '文章内容',
  `summaryImg` varchar(255) DEFAULT NULL COMMENT '博客摘要图片',
  `contextImg` varchar(255) DEFAULT NULL COMMENT '博客内容图片',
  PRIMARY KEY (`id`),
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE blog_00.t_blog_01 (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '博客id，主键、索引、自增',
  `title` text COMMENT '博客标题',
  `summary` text COMMENT '博客摘要',
  `createTime` datetime DEFAULT NULL COMMENT '博客创建时间',
  `type` varchar(1) DEFAULT NULL COMMENT '博客类型，1原创、2转载、3翻译',
  `blogType` varchar(255) DEFAULT NULL COMMENT '博客 文章分类',
  `viewCount` int(10) DEFAULT NULL COMMENT '阅读量',
  `commentCount` int(10) DEFAULT NULL COMMENT '评论量',
  `context` longtext COMMENT '文章内容',
  `summaryImg` varchar(255) DEFAULT NULL COMMENT '博客摘要图片',
  `contextImg` varchar(255) DEFAULT NULL COMMENT '博客内容图片',
  PRIMARY KEY (`id`),
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE blog_01.t_blog_02 (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '博客id，主键、索引、自增',
  `title` text COMMENT '博客标题',
  `summary` text COMMENT '博客摘要',
  `createTime` datetime DEFAULT NULL COMMENT '博客创建时间',
  `type` varchar(1) DEFAULT NULL COMMENT '博客类型，1原创、2转载、3翻译',
  `blogType` varchar(255) DEFAULT NULL COMMENT '博客 文章分类',
  `viewCount` int(10) DEFAULT NULL COMMENT '阅读量',
  `commentCount` int(10) DEFAULT NULL COMMENT '评论量',
  `context` longtext COMMENT '文章内容',
  `summaryImg` varchar(255) DEFAULT NULL COMMENT '博客摘要图片',
  `contextImg` varchar(255) DEFAULT NULL COMMENT '博客内容图片',
  PRIMARY KEY (`id`),
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE blog_01.t_blog_03 (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '博客id，主键、索引、自增',
  `title` text COMMENT '博客标题',
  `summary` text COMMENT '博客摘要',
  `createTime` datetime DEFAULT NULL COMMENT '博客创建时间',
  `type` varchar(1) DEFAULT NULL COMMENT '博客类型，1原创、2转载、3翻译',
  `blogType` varchar(255) DEFAULT NULL COMMENT '博客 文章分类',
  `viewCount` int(10) DEFAULT NULL COMMENT '阅读量',
  `commentCount` int(10) DEFAULT NULL COMMENT '评论量',
  `context` longtext COMMENT '文章内容',
  `summaryImg` varchar(255) DEFAULT NULL COMMENT '博客摘要图片',
  `contextImg` varchar(255) DEFAULT NULL COMMENT '博客内容图片',
  PRIMARY KEY (`id`),
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE blog_00.t_blogType_00 (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '博客文章分类id，自增',
  `typeName` varchar(255) DEFAULT NULL COMMENT '博客文章分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE blog_00.t_blogType_01 (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '博客文章分类id，自增',
  `typeName` varchar(255) DEFAULT NULL COMMENT '博客文章分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE blog_01.t_blogType_02 (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '博客文章分类id，自增',
  `typeName` varchar(255) DEFAULT NULL COMMENT '博客文章分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE blog_01.t_blogType_03 (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '博客文章分类id，自增',
  `typeName` varchar(255) DEFAULT NULL COMMENT '博客文章分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;