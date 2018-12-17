package dao;
import java.io.IOException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;																																																																																																																																																																																																																																																																																																																																					
import entity.*;

@Component("exproomDao")
public class ExpRoomDao {
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	  public void addExpRoom(ExpRoom ep) {
		  String sql = "insert into exproom values (?,?,?)";
		  jdbcTemplate.update(sql, new Integer(ep.getId()), ep.getRoom(), new Integer(ep.getState()));
	  }
	  
	  public void deleteExpRoom(String id) {
		  String sql = "delete from exproom where id=?";
		  jdbcTemplate.update(sql, id);
	  }
	  
	  public int toogleExpRoomStatus(int state,int id) {
		  int r = 0;

		  String sql = "update exproom set state = ? where id = ?";
		  r = jdbcTemplate.update(sql,state,id);

		  return r;
	  }
	  
	public List<ExpRoom> queryAllExpRoom(){
		List<ExpRoom> erlist=new ArrayList<ExpRoom>();
		String sql="select * from exproom";
		erlist = jdbcTemplate.query(sql, new ExpRoomInfo());
		  	
	  	for(ExpRoom e:erlist) {
	  		if(e.getState()==0) {
	  			erlist.remove(e);
	  		}
	  	}
		  	
	  	return erlist;
	  }
	
    public ExpRoom queryExpRoomByID(int id){
		List<ExpRoom> arlist=new ArrayList<ExpRoom>();
		ExpRoom er = new ExpRoom();
		String sql="select * from exproom where id=?";
		arlist = jdbcTemplate.query(sql, new ExpRoomInfo(), id);
		
	 	for(ExpRoom e: arlist) {
	 		er=e;
	 	}
		return er;
	    }	
	  
    public class ExpRoomInfo implements RowMapper, Serializable {
		public ExpRoom mapRow(ResultSet rs, int rowNum) throws SQLException{
			ExpRoom er = new ExpRoom();
			er.setId(rs.getInt("id"));
			er.setRoom(rs.getString("room"));
			er.setState(rs.getInt("state"));
						
			return er;
		}
	}

}
