package com.own.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;


import com.own.model.User;

public class UserDaoImpl implements UserDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
	    this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void addUser(User user) {
	  
		String sql = "INSERT INTO users(name, username, password,dob,address) VALUES(:name, :username, :password, :dob, :address)";
		  
		  jdbcTemplate.update(sql, getSqlParameterByModel(user));
		
	}
	
	private SqlParameterSource getSqlParameterByModel(User user){
		  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		  if(user != null){
		   parameterSource.addValue("name", user.getName());
		   parameterSource.addValue("username", user.getUsername());
		   parameterSource.addValue("password", user.getPassword());
		   parameterSource.addValue("dob", user.getDob());
		   parameterSource.addValue("address", user.getAddress());
		  }
		  return parameterSource;
		 }
	
	 private static final class UserMapper implements RowMapper{

		  public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		   User user = new User();
		   user.setName(rs.getString("name"));
		   user.setName(rs.getString("username"));
		   user.setPassword(rs.getString("password"));
		   user.setDob(rs.getString("dob"));
		   user.setAddress(rs.getString("address"));
		   
		   return user;
		  }
		  
		 }

	public User checkUser(String username, String password) {
		String sql = "select * from users where username= :username, password= :password";
	    List<User> users = jdbcTemplate.query(sql, new UserMapper());
	    return users.size() > 0 ? users.get(0) : null;
	    }
		
	}
	
	


