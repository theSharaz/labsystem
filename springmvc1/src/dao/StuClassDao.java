package dao;
import java.util.*;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;																																																																																																																																																																																																																																																																																																																																					
import entity.*;
import entity.Class;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

@Component("stuclDao")
public class StuClassDao {
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	StudentDao stuDao;
	
	@Autowired
	ClassDao clDao;

  public void addClass(StuClass p) {
  String sql = "insert into stuclass values (?,?,?)";
  jdbcTemplate.update(sql, new Integer(p.getId()), new Integer(p.getStunum()), new Integer(p.getClassno()));
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


public List<Class> allStuClassByID(int stunum){
  	List<StuClass> plist=new ArrayList<StuClass>();
  	List<Class> slist=new ArrayList<Class>();

	String sql = "select * from stuclass where stunum ='" + stunum + "'";
	plist = jdbcTemplate.query(sql, new StuClassInfo());

	for(StuClass s:plist) {
		slist.add(clDao.getClassByID(s.getClassno()));
	}

  	return slist;
  }	

public List<Student> allClassByStuClassID(int classno){
  	List<StuClass> plist=new ArrayList<StuClass>();
  	List<Student> slist=new ArrayList<Student>();

	String sql = "select * from stuclass where classno ='" + classno + "'";
	plist = jdbcTemplate.query(sql, new StuClassInfo());

	for(StuClass s:plist) {
		slist.add(stuDao.queryStudentByID(s.getStunum()));
	}

  	return slist;
  }

public List<StuClass> allClassByClassID(int classno){
  	List<StuClass> plist=new ArrayList<StuClass>();

	String sql = "select * from stuclass where classno ='" + classno + "'";
	plist = jdbcTemplate.query(sql, new StuClassInfo());

  	return plist;
  }

public List<Student> studentsNotInClassByClassID(int classno){
  	List<StuClass> plist=new ArrayList<StuClass>();
  	List<Student> zlist=new ArrayList<Student>();

	String sql = "select * from stuclass where classno ='" + classno + "'";
	plist = jdbcTemplate.query(sql, new StuClassInfo());
  	List<Student> slist=new ArrayList<Student>();
  	slist = stuDao.allStudents();
	
    for(int i=0;i<slist.size();i++) {

	    for(int j=0;j<plist.size();j++) {
	    	int u = plist.get(j).getStunum();
	    	int e = slist.get(i).getStuNum();
	    	 if(e==u) {
	    		 slist.remove(i);
	    	 }
	    }
    }

  	return slist;
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
