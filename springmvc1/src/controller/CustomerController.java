package controller;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;  
import org.springframework.web.bind.annotation.*;

import entity.*;
import dao.*;
  
@Controller  
@RequestMapping("/customer")  
public class CustomerController {  
	@Autowired
	CustomerDao cusDao;
	@Autowired
	UserDao usrDao;
	@Autowired
	AdminDao adDao;
	@Autowired
	ProfessorDao profDao;
	
	static List<Customer> clist=new ArrayList<Customer>();
	static List<User> ulist=new ArrayList<User>();
	static List<Admin> alist=new ArrayList<Admin>();
	static List<Professor> plist=new ArrayList<Professor>();

	//http://localhost:8085/springmvc/customer/querycus
	@RequestMapping(value="/querycus",method = RequestMethod.GET) 
    public String queryCustomer(ModelMap model) {
		clist=cusDao.allCustomers();
		model.addAttribute("clist",clist);
//		ulist=usrDao.allUsers();
//		model.addAttribute("ulist",ulist);
//		alist=adDao.allAdmins();
//		model.addAttribute("alist",alist);
//		plist=profDao.allProfessors();
//		model.addAttribute("plist",plist);
    	System.out.println("Size of the list is: "+clist.size());

        return "querycus";  
    }  
	
	//http://localhost:8085/springmvc/customer/add
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public String addCustomer(Customer cus) { 
    	cusDao.addCustomer(cus);
    	return "redirect:querycus"; 
    }  
  //http://localhost:8085/springmvc/customer/delete/1002
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
    public String deleteCustomer(@PathVariable String id) { 
    	cusDao.deleteCustomerById(id);
    	return "redirect:../querycus"; 
    }  
    
    
} 
