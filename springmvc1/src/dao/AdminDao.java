package dao;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;																																																																																																																																																																																																																																																																																																																																					
import entity.Admin;

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
    
	public boolean validate(Admin ad) {
		boolean flag = false;
		Admin adm = null;
    	List<Admin> alist = new ArrayList<Admin>();
		String sql = "SELECT name,password FROM admins where name  = '"+ad.getName()+"'";
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
}
