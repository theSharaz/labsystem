package dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.*;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;																																																																																																																																																																																																																																																																																																																																					
import entity.*;

@Component("stuDao")

public class StudentDao {
	
    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
    public void addStudent(Student p) {
        String sql = "insert into students values (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, new Integer(p.getStuNum()), p.getName(), p.getPassword(), new Integer(p.getClassno()), p.getAddress(), p.getEmail(), p.getPhone());
    }
    public void deleteStudentById(String pid) {
        String sql = "delete from  students where stunum=?";
        jdbcTemplate.update(sql, pid);
    }
    
    public List<Student> allStudents(){
    	List<Student> slist=new ArrayList<Student>();
    	String sql="select * from students";
    	slist = jdbcTemplate.query(sql, new StudentInfo());

    	return slist;
    }
    
	public boolean validate(Student s) {
		boolean flag = false;
		Student sm = queryStudentByID(s.getStuNum());
		try {
		if(sm!=null) {

				if((s.getStuNum()== sm.getStuNum())&&s.getPassword().equals(sm.getPassword())) {
				flag = true;
				}
		}
		}catch (Exception e) {

			e.printStackTrace();
		}
		return flag;
	}
	
	public int changePassword(Student s) {
		int r = 0;
		
		if(validate(s)) {
			String sql = "update students set password ='"+s.getNewpassword()+"'  where stunum = '"+s.getStuNum()+"'";
			r = jdbcTemplate.update(sql);

		}	
		return r;
	}
	
	public Student queryStudentByID(int StuNum){
	List<Student> slist =  new ArrayList<Student>();
	String sql = "select * from students where stunum ='" + StuNum + "'";
	slist = jdbcTemplate.query(sql, new StudentInfo());
	Student stu = null;
	for(Student s:slist) {
		stu =s;
	}
	return stu;
	
	
}
	
    public List<Student> allStudentsByClass(int classno){
    	List<Student> slist=new ArrayList<Student>();
    	String sql="select * from students where classno ='" + classno + "'";
    	slist = jdbcTemplate.query(sql, new StudentInfo());

    	return slist;
    }
	
	// below should go in file DAO
    public int addFile(int id, String name, InputStream inputStream, int stunum, int classno) {
    	int r = 0;
        String sql = "insert into files values (?,?,?,?,?)";
        r = jdbcTemplate.update(sql, id, name, inputStream,stunum, classno);
        return r;
    }
    
//    public List getFile(int id) {
//    	int r = 0;
//        String sql = "select * from files WHERE stunum = '"+id+"'";
//        List nlist = jdbcTemplate.query(sql, new FileInfo());
//        return nlist;
//    }
	
	

}
