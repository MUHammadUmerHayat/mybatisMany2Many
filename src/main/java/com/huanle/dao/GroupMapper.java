package com.huanle.dao;

import com.huanle.model.Group;

public interface GroupMapper {
	public void insertGroup(Group group);
	public Group getGroup(int id);
}
