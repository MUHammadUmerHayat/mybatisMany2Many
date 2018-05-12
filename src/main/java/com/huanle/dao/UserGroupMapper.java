package com.huanle.dao;


import com.huanle.model.Group;
import com.huanle.model.User;
import com.huanle.model.UserGroup;

public interface UserGroupMapper {
	public void insertUserGroup(UserGroup userGroup);
	public User getUsersByGroupId(int id);
	public Group getGroupByUserId(int id);
}
