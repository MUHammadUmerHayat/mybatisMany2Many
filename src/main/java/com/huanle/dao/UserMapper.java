package com.huanle.dao;

import com.huanle.model.User;
//接口里描述对应xml文件里的方法中的参数和返回值的类型
public interface UserMapper {
	public void insertUser(User user);
	public User getUser(int id);
}
