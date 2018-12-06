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

@Component("bexpDao")
public class BookedExpDao {

    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    FilesDao flDao;
    @Autowired
    StudentDao stuDao;
    
    
	List<Student> slist=new ArrayList<Student>();

    
  public void addBookedExp(BookedExp b, String name) throws IOException {
  String sql = "insert into bookedexp values (?,?,?,?,?,?,?)";
 int r= 0, z=0;
 int classid = b.getClassno();
 r = jdbcTemplate.update(sql, new Integer(b.getId()),new Integer(b.getClassno()), b.getWeek(),b.getDay(),b.getStart(),b.getFinish(),b.getRoom());
  
  if(r>0) {

		slist = stuDao.allStudentsByClass(classid);

		for(Student s:slist) {
			Files f = new Files();
			f.setId(0);
			f.setName(name);
	    	f.setInputStream(null);
	    	f.setStuNum(s.getStuNum());
	    	f.setClassno(b.getClassno());
	    	f.setState(0);
	    	
	    	z=flDao.addFile(f);
			if(z>0) {
				System.out.println(s.getStuNum()+"'s "+name+" experiment addded");
			}
		}
		 

	  
	  
  }
  
}
    


public List<BookedExp> allBookedExp(){
	List<BookedExp> blist=new ArrayList<BookedExp>();

	String sql="select * from bookedexp";
	blist = jdbcTemplate.query(sql, new BookedExpInfo());

	return blist;
}
    
  public List<BookedExp> allBookedExpByClass(int classno){
  	List<BookedExp> blist=new ArrayList<BookedExp>();

	String sql = "select * from bookedexp where classno ='" + classno + "' order by week";
	blist = jdbcTemplate.query(sql, new BookedExpInfo());

  	return blist;
  }
    
	public class BookedExpInfo implements RowMapper, Serializable{
	public BookedExp mapRow(ResultSet rs, int rowNum) throws SQLException{
		BookedExp b = new BookedExp();
		b.setId(rs.getInt("id"));
		b.setClassno(rs.getInt("classno"));
		b.setWeek(rs.getString("week"));
		b.setDay(rs.getString("day"));
		b.setStart(rs.getString("start"));
		b.setFinish(rs.getString("finish"));
		b.setRoom(rs.getString("room"));
		return b;
	}
}
    
}
