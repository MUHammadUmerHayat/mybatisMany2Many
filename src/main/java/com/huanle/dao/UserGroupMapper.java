package com.huanle.dao;

import com.huanle.model.Group;
import com.huanle.model.User;
import com.huanle.model.UserGroup;
//接口里描述对应xml文件里的方法中的参数和返回值的类型
public interface UserGroupMapper {
	public void insertUserGroup(UserGroup userGroup);
	public User getUsersByGroupId(int id);
	public Group getGroupByUserId(int id);
}
