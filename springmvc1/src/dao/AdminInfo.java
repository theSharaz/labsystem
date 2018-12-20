package dao;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import entity.Admin;

public class AdminInfo implements RowMapper, Serializable{
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin a = new Admin();
		a.setId(rs.getInt("adminID"));
		a.setName(rs.getString("name"));
		a.setPassword(rs.getString("password"));
		return a;
	}
}
