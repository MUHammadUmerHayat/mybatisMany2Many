# mybatisMany2Many


mybatis3.0 添加了association和collection标签专门用于对多个相关实体类数据进行级联查询，
但仍不支持多个相关实体类数据的级联保存和级联删除操作。因此在进行实体类多对多映射表设计时，
需要专门建立一个关联对象类对相关实体类的关联关系进行描述。
此project将以“User”和“Group"两个实体类之间的多对多关联映射为例进行CRUD操作。


###假设项目中存在用户和用户组，从一个用户读取出它所在的用户组，从一个用户组也知道这个组内的所有用户信息。

从下面三张表应该看出，用户ID为1同时在用户组ID为 1 和 2 中，而用户ID为 2 仅在一个用户组ID为1中。


```
CREATE TABLE `the_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL DEFAULT '',
  `mobile` varchar(16) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `the_user` VALUES ('1', 'yiibai', '13838009988');
INSERT INTO `the_user` VALUES ('2', 'User-name-1', '13838009988');

```

```
CREATE TABLE `the_group` (
  `group_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `group_name` varchar(254) NOT NULL DEFAULT '',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `the_group` VALUES ('1', 'Group-1');
INSERT INTO `the_group` VALUES ('2', 'Group-2');

```

```
CREATE TABLE `user_group` (
  `user_id` int(10) unsigned NOT NULL DEFAULT '0',
  `group_id` int(10) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_group
-- ----------------------------
INSERT INTO `user_group` VALUES ('1', '1');
INSERT INTO `user_group` VALUES ('2', '1');
INSERT INTO `user_group` VALUES ('1', '2');

```
