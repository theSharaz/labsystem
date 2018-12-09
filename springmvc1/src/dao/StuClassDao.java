package dao;
import java.util.*;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;																																																																																																																																																																																																																																																																																																																																					
import entity.*;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

@Component("stuclDao")

public class StuClassDao {
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

  public void addClass(StuClass p) {
  String sql = "insert into stuclass values (?,?)";
  jdbcTemplate.update(sql, new Integer(p.getClassno()), new Integer(p.getStunum()));
}
public void deleteClassById(String pid) {
  String sql = "delete from  stuclass where stunum=?";
  jdbcTemplate.update(sql, pid);
}

public List<StuClass> allClass(){
	List<StuClass> plist=new ArrayList<StuClass>();

	String sql="select * from stuclass";
	plist = jdbcTemplate.query(sql, new StuClassInfo());

	return plist;
}

public List<StuClass> allClassByStuID(int stunum){
  	List<StuClass> plist=new ArrayList<StuClass>();

	String sql = "select * from stuclass where stunum ='" + stunum + "'";
	plist = jdbcTemplate.query(sql, new StuClassInfo());

  	return plist;
  }

public List<StuClass> allClassByClassID(int classno){
  	List<StuClass> plist=new ArrayList<StuClass>();

	String sql = "select * from stuclass where classno ='" + classno + "'";
	plist = jdbcTemplate.query(sql, new StuClassInfo());

  	return plist;
  }
	
	public class StuClassInfo implements RowMapper, Serializable{
	public StuClass mapRow(ResultSet rs, int rowNum) throws SQLException{
		StuClass p = new StuClass();
		p.setId(rs.getInt("id"));
		p.setClassno(rs.getInt("classno"));
		p.setStunum(rs.getInt("stunum"));
		return p;
	}
}
}
