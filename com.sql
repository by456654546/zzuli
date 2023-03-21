create table admin_role
(
    id        int auto_increment
        primary key,
    admin_id  int          not null,
    role_id   int          not null,
    is_delete varchar(255) null
);

create table admin_user
(
    id          int auto_increment
        primary key,
    user_name   varchar(255) not null comment '用户名',
    password    varchar(255) null comment '密码',
    roles_id    varchar(255) null comment '对应的权限',
    nick_name   varchar(255) null comment '实际名字',
    college     varchar(255) null comment '老师对应学院',
    create_time datetime     null,
    update_time datetime     null,
    is_delete   varchar(255) null
);

create table info_audit
(
    id          int auto_increment
        primary key,
    award_id    int          not null comment '奖项id',
    is_check    tinyint(255) null comment '0 未审核 1 审核',
    create_time datetime     null,
    update_time datetime     null,
    is_delete   varchar(255) null
);

create table info_award
(
    id               int auto_increment
        primary key,
    college          varchar(255) null comment '学院',
    competition_name varchar(255) null comment '竞赛名称',
    hold_unit        varchar(255) null comment '举办单位',
    form             tinyint(1)   null comment '0 否 团体 1  是个人',
    category         varchar(255) null comment '奖项类别',
    is_other         tinyint(255) null comment '是否为文艺 体育类 0 否 1 是',
    award_grade      varchar(255) null comment '获奖等级',
    student_ids      varchar(255) null comment '获奖学生Id',
    guide_teacher    varchar(255) null comment '指导老师',
    create_time      datetime     null comment '获奖时间',
    rec_grade        varchar(255) null comment '认定级别',
    score            int(255)     null comment '分值',
    is_delete        varchar(255) null,
    update_time      datetime     null
);

create table role
(
    id        int auto_increment comment '主键'
        primary key,
    role_name varchar(255) not null comment '对应权限'
);

create table student_user
(
    id          int auto_increment
        primary key,
    user_name   varchar(255) not null comment '学号',
    password    varchar(255) not null comment '密码',
    college     varchar(255) not null comment '所属学院',
    grade       varchar(255) not null comment '年级',
    major       varchar(255) not null comment '专业',
    nick_name   varchar(255) not null comment '学生实际名',
    create_time datetime     null,
    update_time datetime     null,
    is_delete   tinyint(255) null
);
