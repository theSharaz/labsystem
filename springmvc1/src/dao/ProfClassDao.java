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

@Component("profclDao")

public class ProfClassDao {
	
  @Resource(name="jdbcTemplate")
  private JdbcTemplate jdbcTemplate;
  public void addClass(ProfClass p) {
      String sql = "insert into profclass values (?,?)";
      jdbcTemplate.update(sql, new Integer(p.getClassno()), new Integer(p.getProfnum()));
  }
  public void deleteClassById(String pid) {
      String sql = "delete from  profclass where profnum=?";
      jdbcTemplate.update(sql, pid);
  }
  
  public List<ProfClass> allClass(){
  	List<ProfClass> plist=new ArrayList<ProfClass>();

  	String sql="select * from profclass";
  	plist = jdbcTemplate.query(sql, new ProfClassInfo());

  	return plist;
  }
  
  public List<ProfClass> allClassByProID(int profnum){
	  	List<ProfClass> plist=new ArrayList<ProfClass>();

		String sql = "select * from profclass where profnum ='" + profnum + "'";
		plist = jdbcTemplate.query(sql, new ProfClassInfo());

	  	return plist;
	  }
	
	public class ProfClassInfo implements RowMapper, Serializable{
	public ProfClass mapRow(ResultSet rs, int rowNum) throws SQLException{
		ProfClass p = new ProfClass();
		p.setId(rs.getInt("id"));
		p.setClassno(rs.getInt("classno"));
		p.setProfnum(rs.getInt("profnum"));
		return p;
	}
}

}

