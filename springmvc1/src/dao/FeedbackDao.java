package dao;
import java.util.*;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import dao.BookDao.AvailableTimeInfo;
import entity.*;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

@Component("fdDao")
public class FeedbackDao {

    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
    
	  public void addAvailableTime(Feedback fb) {
	  String sql = "insert into feedback (feedbackno,comment) values (?,?)";
	  jdbcTemplate.update(sql, new Integer(fb.getFeedbackno()), fb.getComment());
	  }
	  
	  public List<Feedback> queryFeedback(){
    	List<Feedback> fblist=new ArrayList<Feedback>();
    	String sql="select * from feedback order by fdtime";
    	fblist = jdbcTemplate.query(sql, new FeedbackInfo());
    	
    	return fblist;
	    }
	    
	    public class FeedbackInfo implements RowMapper, Serializable {
		public Feedback mapRow(ResultSet rs, int rowNum) throws SQLException{
			Feedback fb = new Feedback();
			fb.setFeedbackno(rs.getInt("feedbackno"));
			fb.setComment(rs.getString("comment"));
			fb.setFdtime(rs.getString("fdtime"));
						
			return fb;
		}
	}
}
