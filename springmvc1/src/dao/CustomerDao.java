package dao;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;																																																																																																																																																																																																																																																																																																																																					
import entity.Customer;

@Component("cusDao")
public class CustomerDao {

    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    public List<Customer> allCustomers(){
    	List<Customer> clist=new ArrayList<Customer>();
    	String sql="select * from customers";
    	clist = jdbcTemplate.query(sql, new CustomerInfo());
    	return clist;
    }
    public void addCustomer(Customer c) {
        String sql = "insert into customers values (?,?,?)";
        jdbcTemplate.update(sql, c.getId(),c.getName(),c.getPhone());
    }
    public void deleteCustomerById(String cid) {
        String sql = "delete from  customers where customerId=?";
        jdbcTemplate.update(sql, cid);
    }
}