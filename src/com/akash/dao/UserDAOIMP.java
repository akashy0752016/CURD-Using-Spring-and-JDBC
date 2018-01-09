package com.akash.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.akash.bean.Users;

public class UserDAOIMP implements UserDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("Select * from users order by id desc", new RowMapper<Users>() {
			@Override
			public Users mapRow(java.sql.ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				Users u = new Users();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				try {
					u.setPassword(rs.getString(4));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return u;
			}
		});
	}

	@Override
	public int createUser(Users u) throws DataAccessException, Exception {
		// TODO Auto-generated method stub
		int i = jdbcTemplate.update("insert into users values(?,?,?,?)", u.getId(), u.getName(), u.getEmail(), u.getPassword());
		return i;
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("delete from users where id = ?", id);
	}

	@Override
	public Users getUser(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from users where id = ?", new Object[] {id}, new BeanPropertyRowMapper<Users>(Users.class));
	}

	@Override
	public int updateUser(Users u) throws DataAccessException, Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("update users set name = ?, email = ?, password = ? where id = ?", u.getName(), u.getEmail(), u.getPassword(), u.getId());
	}
}
