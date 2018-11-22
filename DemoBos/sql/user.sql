-- auto-generated definition
create table user
(
  id       varchar(32) default ''    not null
  comment '主键'
    primary key,
  password varchar(32) default '123' null,
  type     varchar(10)               null,
  userame  varchar(32)               null,
  joindate datetime                  null
  comment '加入时间',
  status   varchar(10)               null
  comment '当前状态'
);