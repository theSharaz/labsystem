package dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import entity.*;

public class StudentInfo implements RowMapper, Serializable{
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
		Student s = new Student();
		s.setStuNum(rs.getInt("stunum"));		
		s.setName(rs.getString("name"));
		s.setPassword(rs.getString("password"));
		s.setClassno(rs.getInt("classno"));
		s.setAddress(rs.getString("address"));
		s.setEmail(rs.getString("email"));
		s.setPhone(rs.getString("phone"));	
		return s;
	}
}
