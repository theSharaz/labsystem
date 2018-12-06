package dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import entity.Customer;

public class CustomerInfo implements RowMapper, Serializable{
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer c = new Customer();
		c.setId(rs.getString("customerId"));
		c.setName(rs.getString("name"));
		c.setPhone(rs.getString("phone"));
		return c;
	}
}

