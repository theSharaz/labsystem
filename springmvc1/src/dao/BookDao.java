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

@Component("bookDao")

public class BookDao {
	
    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
	    //--------------------------------------------------------------------------------------------------------------------------------------
	    //Available time functions
	  public void addAvailableTime(AvailableTime at) {
		  String sql = "insert into availabletime values (?,?,?,?,?,?,?)";
		  jdbcTemplate.update(sql, new Integer(at.getAvailableid()), at.getWeek(), at.getDay(), at.getStart(), at.getFinish(),  at.getRoom(), new Integer(at.getState()));
	  }
	  
	  public void deleteAvailableTime(String pid) {
		  String sql = "delete from availabletime where availableid=?";
		  jdbcTemplate.update(sql, pid);
	  }
	  
		public int toogleAvailableTimeStatus(int state,int availableid) {
			int r = 0;

			String sql = "update availabletime set state = ? where availableid = ?";
			r = jdbcTemplate.update(sql,state,availableid);
	
		return r;
	}
	  
	    public List<AvailableTime> queryAllAvailableTime(){
	    	List<AvailableTime> avlist=new ArrayList<AvailableTime>();
	    	String sql="select * from availabletime";
	    	avlist = jdbcTemplate.query(sql, new AvailableTimeInfo());
	    	
	    	for(AvailableTime a:avlist) {
	    		if(a.getState()==0) {
	    			avlist.remove(a);
	    		}
	    	}
	    	
	    	return avlist;
	    }
	    
	    public List<AvailableTime> queryAvailableTimeByWEEK(String week){
	    	List<AvailableTime> avlist=new ArrayList<AvailableTime>();
	    	String sql="select * from availabletime where week=?";
	    	avlist = jdbcTemplate.query(sql, new AvailableTimeInfo(), week);
	    	for(AvailableTime a:avlist) {
	    		if(a.getState()==0) {
	    			avlist.remove(a);
	    		}
	    	}
	    	return avlist;
	    }
	    
	    public List<AvailableTime> queryAvailableTimeByROOM(String room){
	    	List<AvailableTime> avlist=new ArrayList<AvailableTime>();
	    	String sql="select * from availabletime where room=?";
	    	avlist = jdbcTemplate.query(sql, new AvailableTimeInfo(), room);
	    	for(AvailableTime a:avlist) {
	    		if(a.getState()==0) {
	    			avlist.remove(a);
	    		}
	    	}
	    	return avlist;
	    }
	    
	    public List<AvailableTime> queryAvailableTimeByWEEKandROOM(String week,String room){
	    	List<AvailableTime> avlist=new ArrayList<AvailableTime>();
	    	String sql="select * from availabletime where week=? and room=?";
	    	avlist = jdbcTemplate.query(sql, new AvailableTimeInfo(), week,room);
	    	for(AvailableTime a:avlist) {
	    		if(a.getState()==0) {
	    			avlist.remove(a);
	    		}
	    	}
	    	return avlist;
	    }
	    
	    public class AvailableTimeInfo implements RowMapper, Serializable {
		public AvailableTime mapRow(ResultSet rs, int rowNum) throws SQLException{
			AvailableTime at = new AvailableTime();
			at.setAvailableid(rs.getInt("availableid"));
			at.setWeek(rs.getString("week"));
			at.setDay(rs.getString("day"));
			at.setStart(rs.getString("start"));
			at.setFinish(rs.getString("finish"));
			at.setRoom(rs.getString("room"));
			at.setState(rs.getInt("state"));
						
			return at;
		}
	}
	    
	    
	  
	    //--------------------------------------------------------------------------------------------------------------------------------------
	    //Application time functions

		  public void addApplication(Application ap) {
			  String sql = "insert into application values (?,?,?,?,?,?,?,?,?,?)";
			  jdbcTemplate.update(sql, new Integer(ap.getAppid()), new Integer(ap.getClassno()),new Integer(ap.getStunum()), 
					  ap.getWeek(), ap.getDay(), ap.getStart(), ap.getFinish(),  ap.getRoom(), new Integer(ap.getState()), new Integer(ap.getAvailableid()));
		  }
		  
		  public void rejectApplication(String pid) {
			  String sql = "delete from application where appid=?";
			  jdbcTemplate.update(sql, pid);
		  }
		  
		    public List<Application> queryAllApplication(){
		    	List<Application> aplist=new ArrayList<Application>();
		    	String sql="select * from application";
		    	aplist = jdbcTemplate.query(sql, new ApplicationInfo());

		    	return aplist;
		    }
		    
		    
		    public List<Application> queryApplicationByClass(String classno){
		    	List<Application> aplist=new ArrayList<Application>();
		    	String sql="select * from application where classno=?";
		    	aplist = jdbcTemplate.query(sql, new ApplicationInfo(), classno);

		    	return aplist;
		    }
		  
		    public List<Application> queryApplicationByWeek(String week){
		    	List<Application> aplist=new ArrayList<Application>();
		    	String sql="select * from application where week=?";
		    	aplist = jdbcTemplate.query(sql, new ApplicationInfo(), week);

		    	return aplist;
		    }		    
		    
		    public List<Application> queryApplicationByStu(String stunum){
		    	List<Application> aplist=new ArrayList<Application>();
		    	String sql="select * from application where stunum=?";
		    	aplist = jdbcTemplate.query(sql, new ApplicationInfo(), stunum);

		    	return aplist;
		    }		    
		    
		  
		    public class ApplicationInfo implements RowMapper, Serializable {
				public Application mapRow(ResultSet rs, int rowNum) throws SQLException{
					Application ap = new Application();
					ap.setAppid(rs.getInt("appid"));
					ap.setClassno(rs.getInt("classno"));
					ap.setStunum(rs.getInt("stunum"));
					ap.setWeek(rs.getString("week"));
					ap.setDay(rs.getString("day"));
					ap.setStart(rs.getString("start"));
					ap.setFinish(rs.getString("finish"));
					ap.setRoom(rs.getString("room"));
					ap.setState(rs.getInt("state"));
					ap.setAvailableid(rs.getInt("availableid"));
		
					return ap;
				}
			}
			
		    
		    //--------------------------------------------------------------------------------------------------------------------------------------
		    //Approved time functions

			  public int addApprovedTime(ApprovedTime apt) {
				  int r = 0;
				  String sql = "insert into approvedtime values (?,?,?,?,?,?,?,?,?)";
				  int cou =countStudentsInClass(apt.getClassno());
				  if(cou<=10) {
					  r = jdbcTemplate.update(sql, new Integer(apt.getApprovedid()), new Integer(apt.getClassno()),new Integer(apt.getStunum()), 
							  apt.getWeek(), apt.getDay(), apt.getStart(), apt.getFinish(),  apt.getRoom(), new Integer(apt.getAvailableid()));
					  if(r!=0&&cou==10) {
						  //removes an available time if approved bookings are full
						  toogleAvailableTimeStatus(0,apt.getAvailableid());
					  }
					  return r;
				  }
				  return r;
			  }
			  
			  public int removeApprovedTime(int approvedid) {
				  int r = 0;  
				  ApprovedTime at = new ApprovedTime();
				  at = queryApprovedTimeByID(approvedid);
				  String sql = "delete from approvedtime where approvedid=?";
				  r = jdbcTemplate.update(sql, approvedid);
				  int cou =countStudentsInClass(approvedid);

				  if(r!=0&&cou<10) {
					  toogleAvailableTimeStatus(1,at.getAvailableid());
				  }
				  return r;

			  }
			  
			    public List<ApprovedTime> queryAllApprovedTime(){
			    	List<ApprovedTime> atlist=new ArrayList<ApprovedTime>();
			    	String sql="select * from approvedtime";
			    	atlist = jdbcTemplate.query(sql, new ApplicationInfo());

			    	return atlist;
			    }
			    
			    public List<ApprovedTime> queryApprovedTimeByStu(int stunum){
			    	List<ApprovedTime> atlist=new ArrayList<ApprovedTime>();
			    	String sql="select * from approvedtime where stunum=?";
			    	atlist = jdbcTemplate.query(sql, new ApplicationInfo(), stunum);

			    	return atlist;
			    }	
			    
			    public List<ApprovedTime> queryApprovedTimeByClass(int classno){
			    	List<ApprovedTime> atlist=new ArrayList<ApprovedTime>();
			    	String sql="select * from approvedtime where classno=?";
			    	atlist = jdbcTemplate.query(sql, new ApplicationInfo(), classno);

			    	return atlist;
			    }	
			  
			    public ApprovedTime queryApprovedTimeByID(int approvedid){
			    	List<ApprovedTime> atlist=new ArrayList<ApprovedTime>();
			    	ApprovedTime at = new ApprovedTime();
			    	String sql="select * from approvedtime where approvedid=?";
			    	atlist = jdbcTemplate.query(sql, new ApplicationInfo(), approvedid);
			    	
			     	for(ApprovedTime a: atlist) {
			     		at=a;
			     	}
			    	return at;
			    }	
			    
	
			  
				  public int countStudentsInClass(int i) {
				  int r = 0;
			       String sql = "SELECT COUNT(stunum) AS count FROM approvedtime WHERE classno = ?";
			     	List<Integer> slist=new ArrayList<Integer>();
			     	slist = jdbcTemplate.query(sql, new CountInfo(), i);
			     	
			     	for(int s: slist) {
			     		r=s;
			     	}
				  return r;
				  }		  
			  

			  
			    public class ApprovedTimeInfo implements RowMapper, Serializable {
					public ApprovedTime mapRow(ResultSet rs, int rowNum) throws SQLException{
						ApprovedTime apt = new ApprovedTime();
						apt.setApprovedid(rs.getInt("approvedid"));
						apt.setClassno(rs.getInt("classno"));
						apt.setStunum(rs.getInt("stunum"));
						apt.setWeek(rs.getString("week"));
						apt.setDay(rs.getString("day"));
						apt.setStart(rs.getString("start"));
						apt.setFinish(rs.getString("finish"));
						apt.setRoom(rs.getString("room"));
						apt.setAvailableid(rs.getInt("availableid"));
			
						return apt;
					}
				}
			    
				public class CountInfo implements RowMapper, Serializable {
					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException{
						
						int r = rs.getInt("count");

						return r;
					}
				}
			  
}
