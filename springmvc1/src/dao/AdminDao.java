package dao;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;																																																																																																																																																																																																																																																																																																																																					
import entity.Admin;
import entity.Student;

@Component("adDao")
public class AdminDao {

    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
    public List<Admin> allAdmins(){
    	List<Admin> alist=new ArrayList<Admin>();
    	String sql="select * from admins";
    	alist = jdbcTemplate.query(sql, new AdminInfo());
    	System.out.println(alist.size());
    	return alist;
    }
    
    public Admin queryAdminsByName(String name){
    	List<Admin> alist=new ArrayList<Admin>();
    	Admin ad = new Admin();
    	String sql="select * from admins where name = ?";
    	alist = jdbcTemplate.query(sql, new AdminInfo(), name);

    	for(Admin a:alist) {
    		ad = a;
        	return ad;

    	}
    	return ad;
    }
    
	public boolean validate(Admin ad) {
		boolean flag = false;
		Admin adm = null;
    	List<Admin> alist = new ArrayList<Admin>();
		String sql = "SELECT * FROM admins where name  = '"+ad.getName()+"'";
		alist = jdbcTemplate.query(sql, new AdminInfo());
		for(Admin a: alist) {
			adm = a;
		}
		try {
		if(adm!=null) {

				if(ad.getName().equals(adm.getName())&&ad.getPassword().equals(adm.getPassword()));
				flag = true;
		
		}
		}catch (Exception e) {

			e.printStackTrace();
		}
		

		return flag;
	}
	
	public int changePassword(Admin ad) {
		int r = 0;
		
		if(validate(ad)) {
			String sql = "update students set password ='"+ad.getNewpassword()+"'  where name = '"+ad.getName()+"'";
			r = jdbcTemplate.update(sql);

		}	
		return r;
	}
}
