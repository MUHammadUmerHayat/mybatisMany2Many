package com.huanle.dao;

import com.huanle.model.User;

public interface UserMapper {
	public void insertUser(User user);
	public User getUser(int id);
}
