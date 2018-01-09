package com.akash.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.akash.bean.Users;

public interface UserDAO {
	public List<Users> getUsers();
	public Users getUser(int id);
	public int createUser(Users u) throws DataAccessException, Exception;
	public int deleteUser(int id);
	public int updateUser(Users u) throws DataAccessException, Exception;
}
