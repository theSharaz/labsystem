package dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import entity.*;

public class ProfessorInfo implements RowMapper, Serializable{
	public Professor mapRow(ResultSet rs, int rowNum) throws SQLException{
		Professor p = new Professor();
		p.setProfnum(rs.getInt("profnum"));
		p.setName(rs.getString("name"));
		p.setPassword(rs.getString("password"));
		p.setAddress(rs.getString("address"));
		p.setEmail(rs.getString("email"));
		p.setPhone(rs.getString("phone"));	
		return p;
	}
}
