package dao;
import java.util.*;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;																																																																																																																																																																																																																																																																																																																																					
import entity.Class;

@Component("clDao")
	public class ClassDao {
		
	    @Resource(name="jdbcTemplate")
	    private JdbcTemplate jdbcTemplate;
	    
	    
	  public List<Class> allClass(){
		List<Class> cllist=new ArrayList<Class>();
		String sql="select * from class order by classno";
		cllist = jdbcTemplate.query(sql, new ClassInfo());
	
		return cllist;
	}
	  
    public void addClass(Class c) {
    String sql = "insert into class values (?,?)";
    jdbcTemplate.update(sql, new Integer(c.getClassno()), c.getName());
    }	
    
    public Class getClassByID(int classno) {
    	Class c = new Class();
    	
		List<Class> cllist=new ArrayList<Class>();
		String sql="select * from class where classno = '"+classno+"' order by classno";
		cllist = jdbcTemplate.query(sql, new ClassInfo());
		
		for(Class cl: cllist) {
			c = cl;
		}
    	return c;
    }
    
	
}	
