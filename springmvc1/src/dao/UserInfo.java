package dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import entity.User;

public class UserInfo implements RowMapper, Serializable{
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User c = new User();
		c.setId(rs.getString("userId"));
		c.setName(rs.getString("name"));
		c.setPhone(rs.getString("phone"));
    	System.out.println("2");
		return c;
	}
}

