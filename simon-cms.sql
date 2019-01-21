-- 创建数据库
create database simon_cms character set utf8;
-- 创建用户表
create table user(
  id int not null auto_increment,
  username varchar(32) not null default '' comment '用户名',
  password varchar(64) not null default '' comment '密码',
  is_delete tinyint(1) not null default 0 comment '是否删除 0未删除，1删除',
  create_time datetime not null default '0001-01-01 00:00:00' comment '创建时间',
  update_time datetime not null default '0001-01-01 00:00:00' comment '更新时间',
  primary key(id)
)character set utf8 comment '用户表';
