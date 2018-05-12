package com.huanle.dao;

import com.huanle.model.Group;
//接口里描述对应xml文件里的方法中的参数和返回值的类型
public interface GroupMapper {
	public void insertGroup(Group group);
	public Group getGroup(int id);
}
