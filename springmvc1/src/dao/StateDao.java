package dao;

import javax.annotation.Resource;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("stateDao")
public class StateDao {

    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
	  public void changeStatus(int state) {
	  String sql = "UPDATE selectClassStatus set state = '"+state+"'  where id = 1";
	  jdbcTemplate.update(sql);
	}
	  
	  public int getState() {
		  int r = 0;
	       String sql = "select state from selectClassStatus WHERE id = 1";
	     	List<Integer> slist=new ArrayList<Integer>();
	     	slist = jdbcTemplate.query(sql, new StateInfo());
	     	
	     	for(int s: slist) {
	     		r=s;
	     	}
		  return r;
	  }
	  
		public class StateInfo implements RowMapper, Serializable {
		public Integer mapRow(ResultSet rs, int rowNum) throws SQLException{
			
			int r = rs.getInt("state");

			return r;
		}
	}
  
}
