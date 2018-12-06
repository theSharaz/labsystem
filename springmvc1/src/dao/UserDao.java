package dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
																																																																																																																																																																																																																																																																																																																																										
import entity.User;

@Component("userDao")
public class UserDao {

    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    public List<User> allUsers(){
    	System.out.println("1");
    	List<User> ulist=new ArrayList<User>();
    	String sql="select * from users";
    	ulist = jdbcTemplate.query(sql, new UserInfo());
    	System.out.println(ulist.size());
    	System.out.println("3");
    	return ulist;
    }
    public void addUser(User c) {
        String sql = "insert into users values (?,?,?)";
        jdbcTemplate.update(sql, c.getId(),c.getName(),c.getPhone());
    }
    public void deleteUserById(String cid) {
        String sql = "delete from  users where userId=?";
        jdbcTemplate.update(sql, cid);
    }
}