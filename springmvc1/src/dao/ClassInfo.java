package dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import entity.Class;

public class ClassInfo implements RowMapper, Serializable{
	public Class mapRow(ResultSet rs, int rowNum) throws SQLException{
		Class c = new Class();
		c.setName(rs.getString("name"));
		c.setClassno(rs.getInt("classno"));
	
		return c;
	}
}
