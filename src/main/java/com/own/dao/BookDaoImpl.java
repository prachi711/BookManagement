package com.own.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.RowMapper;



import com.own.model.Book;


public class BookDaoImpl implements BookDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
	    this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void save(Book book) {
		
		String sql = "INSERT INTO users(bookcode,bookname, booktype, price,description) VALUES(:bookcode, :bookname, :booktype, :price, :description)";
		  
		  jdbcTemplate.update(sql, getSqlParameterByModel(book));
		
		
	}

	public List<Book> getBook() {
		String sql = "SELECT bookcode, bookname, booktype, description, price FROM book";
		  
		  List list = jdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());
		  
		  return list;
	}
	
	private static final class UserMapper implements RowMapper{

		  public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		   Book book = new Book();
		   book.setBookcode(rs.getString("bookcode"));
		   book.setBookname(rs.getString("bookname"));
		   book.setBooktype(rs.getString("booktype"));
		   book.setDescription(rs.getString("description"));
		   book.setPrice(rs.getInt("price"));
		   
		   return book ;
		  }
		  
		 }

	public void delete(String bookcode) {
		String sql="delete from book where bookcode= :bookcode";    
		jdbcTemplate.update(sql, getSqlParameterByModel(new Book(bookcode)));
	}

	public Book getBookByBookcode(String bookcode) {
		
		String sql = "SELECT * FROM book WHERE bookcode = :bookcode";

		  return jdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Book(bookcode)), new UserMapper());
		 }

	

	public List<Book> getBookByBooktype(String booktype) {
		String sql = "SELECT * FROM book WHERE booktype = :booktype";

		  return jdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Book(booktype)), new UserMapper());
		 }

	

	public int update(Book book) {
		String sql = "UPDATE users SET bookname = :bookname, price = :price, description = :description WHERE bookcode = :bookcode";
		  
		 return jdbcTemplate.update(sql, getSqlParameterByModel(book));
	}
	
	private SqlParameterSource getSqlParameterByModel(Book book){
		  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		  if(book != null){
		   parameterSource.addValue("bookcode", book.getBookcode());
		   parameterSource.addValue("bookname", book.getBookname());
		   parameterSource.addValue("booktype", book.getBooktype());
		   parameterSource.addValue("price", book.getPrice());
		   parameterSource.addValue("description", book.getDescription());
		  }
		  return parameterSource;
		 }

}
