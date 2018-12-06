package controller;

import java.util.Map;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  

import entity.User;
  
@Controller  
@RequestMapping("/mymvc")  
public class HelloController {  
	// http://localhost:8085/springmvc/mymvc/hello?name=zhou 
    @RequestMapping(value="/hello",method = RequestMethod.GET)  
    public String printWelcome(String name,Map<String,String> model) {  
    	System.out.println("Hello "+name);
        model.put("name", name); 
        return "hello";  
    }  
    
    @RequestMapping(value="/hello1",method = RequestMethod.GET)  
    public String hello1(String name,ModelMap model) {  
    	 model.addAttribute("name", name);  
        return "hello";  
    }
    @RequestMapping(value="/userreg",method = RequestMethod.POST)  
    public String userreg(User user,ModelMap model) {  
    	model.addAttribute("user",user);
    	return "hello";  
    }
    // http://localhost:8085/springmvc/mymvc/delete/100
    @RequestMapping(value="/delete/{uid}",method = RequestMethod.GET)  
    public String deleteuser(@PathVariable int uid,ModelMap model) {  
    	model.addAttribute("uid",new Integer(uid));
    	return "hello";  
    }
} 


