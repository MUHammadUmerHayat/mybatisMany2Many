package com.huanle.many2many;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.huanle.dao.GroupMapper;
import com.huanle.dao.UserGroupMapper;
import com.huanle.dao.UserMapper;
import com.huanle.model.Group;
import com.huanle.model.User;
import com.huanle.model.UserGroup;

public class App{
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("config/Configure.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		 testAddGroup();
//		testAddUser();
//		 testAddUserGroup();
		testGetGroupAndUsers();
		
	}
	
	public static void testGetGroupAndUsers() {
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			这种方式是不是用 SqlSession 实例来直接执行已映射的SQL语句：
//			session.selectOne("com.yihaomen.mybatis.models.UserMapper.selectUserByID", 1)
//			使用合理描述参数和SQL语句返回值的接口（比如 IUserOperation.class
			GroupMapper groupMaper = session.getMapper(GroupMapper.class);
			Group group = groupMaper.getGroup(1);
			System.out.println("Group => " + group.getGroupName());
			List<User> users = group.getUsers();
			for (User user : users) {
				System.out.println("\t:" + user.getId() + "\t"
						+ user.getUsername());
			}
		} finally {
			session.close();
		}
	}

	public static void testAddUserGroup() {
		UserGroup userGroup = new UserGroup();
		userGroup.setGroupId(1);
		userGroup.setUserId(2);
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			这种方式是不是用 SqlSession 实例来直接执行已映射的SQL语句：
//			session.selectOne("com.yihaomen.mybatis.models.UserMapper.selectUserByID", 1)
//			使用合理描述参数和SQL语句返回值的接口（比如 IUserOperation.class
			UserGroupMapper userGroupMaper = session.getMapper(UserGroupMapper.class);
			userGroupMaper.insertUserGroup(userGroup);

			session.commit();
		} finally {
			session.close();
		}

	}

	public static void testAddUser() {
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			User user = new User();
			user.setUsername("User-name-1");
			user.setMobile("13838009988");
//			这种方式是不是用 SqlSession 实例来直接执行已映射的SQL语句：
//			session.selectOne("com.yihaomen.mybatis.models.UserMapper.selectUserByID", 1)
//			使用合理描述参数和SQL语句返回值的接口（比如 IUserOperation.class
			UserMapper userMaper = session.getMapper(UserMapper.class);
			userMaper.insertUser(user);
			session.commit();
			// System.out.println(user.getGroupId());
		} finally {
			session.close();
		}
	}

	public static void testAddGroup() {
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Group group = new Group();
			group.setGroupName("HappyGroup");
//			这种方式是不是用 SqlSession 实例来直接执行已映射的SQL语句：
//			session.selectOne("com.yihaomen.mybatis.models.UserMapper.selectUserByID", 1)
//			使用合理描述参数和SQL语句返回值的接口（比如 IUserOperation.class）
			GroupMapper groupMapper = session.getMapper(GroupMapper.class);
			groupMapper.insertGroup(group);
			session.commit();
			System.out.println(group.getGroupName()+" added");
		} finally {
			session.close();
		}
	}
}