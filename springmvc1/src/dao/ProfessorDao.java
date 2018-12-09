package dao;

import java.util.*;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;																																																																																																																																																																																																																																																																																																																																					
import entity.*;

@Component("profDao")

public class ProfessorDao {
	
	
	
    public ProfessorDao() {
		super();
	}

	@Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    public void addProfessor(Professor p) {
        String sql = "insert into professor values (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, new Integer(p.getProfnum()), p.getName(), p.getPassword(), p.getAddress(), p.getEmail(), p.getPhone());
    }
    public void deleteProfessorById(String pid) {
        String sql = "delete from  professor where profnum=?";
        jdbcTemplate.update(sql, pid);
    }
    
    public List<Professor> allProfessors(){
    	List<Professor> plist=new ArrayList<Professor>();

    	String sql="select * from professor";
    	plist = jdbcTemplate.query(sql, new ProfessorInfo());

    	return plist;
    }
    
	public boolean validate(Professor p) {
		boolean flag = false;
		Professor pm = queryProfessorByID(p.getProfnum());
		try {
		if(pm!=null) {

				if((p.getProfnum()==pm.getProfnum())&&p.getPassword().equals(pm.getPassword())) {
				flag = true;
				}
		}
		}catch (Exception e) {

			e.printStackTrace();
		}
		return flag;
	}
	
	public int changePassword(Professor p) {
		int r = 0;
		
		if(validate(p)) {
			String sql = "update professor set password ='"+p.getNewpassword()+"'  where profnum = '"+p.getProfnum()+"'";
			r = jdbcTemplate.update(sql);

		}	
		return r;
	}
	
	public Professor queryProfessorByID(int profnum){
	List<Professor> plist =  new ArrayList<Professor>();
	String sql = "select * from professor where profnum ='" + profnum + "'";
	plist = jdbcTemplate.query(sql, new ProfessorInfo());
	Professor pro = null;
	for(Professor p:plist) {
		pro =p;
	}
	return pro;
}
	
}
