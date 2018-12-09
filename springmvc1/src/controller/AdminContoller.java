package controller;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;  
import org.springframework.web.bind.annotation.*;

import entity.*;import entity.Class;
import dao.*;

@Controller  
@RequestMapping("/admin") 
public class AdminContoller {
	@Autowired
	AdminDao adDao;
	@Autowired
	ProfessorDao profDao;
	@Autowired
	StudentDao stuDao;
	@Autowired
	ClassDao clDao;
	
    static List<Professor> plist =new ArrayList<Professor>();
    static List<Student> slist =new ArrayList<Student>();
    static List<Class> clist =new ArrayList<Class>();
	

	HttpServletResponse res;
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
    public String queryCustomer(ModelMap model) {
        return "adminLogin";  
    } 
	
  @RequestMapping(value="/addProf",method = RequestMethod.POST)
  public String addProf(Professor prof) { 
	  profDao.addProfessor(prof);
	return "redirect:welcome";
  }
  

  @RequestMapping(value="/addClass",method = RequestMethod.POST)
  public String addClass(Class cl) { 
	  clDao.addClass(cl);
	return "redirect:welcome";
  }

	  @RequestMapping(value="/addStu",method = RequestMethod.POST)
	  public String addProf(Student stu) { 
		  stuDao.addStudent(stu);
		return "redirect:welcome";
  }  
	
	  
//	  http://localhost:8085/springmvc/admin/welcome
    @RequestMapping(value="/logg",method = RequestMethod.POST)
    public String loginAdmin(Admin ad) { 
    	if(adDao.validate(ad)) {

    		return "redirect:welcome";
    	}else {

    		return "redirect:login";
    	} 
    }  
    
	;
    
    @RequestMapping(value="/welcome",method = RequestMethod.GET)
    public String Welcomepage(HttpServletRequest req) {
    	plist = profDao.allProfessors();
    	req.getSession().setAttribute("plist", plist);
    	slist = stuDao.allStudents();
    	req.getSession().setAttribute("slist", slist);
    	clist = clDao.allClass();
    	req.getSession().setAttribute("clist", clist);
        return "welcome";  
    }  
    
    @RequestMapping(value="/deleteprof/{id}",method = RequestMethod.GET)  
    public String deleteProf(@PathVariable String id) { 
    	profDao.deleteProfessorById(id);
    	return "redirect:../welcome"; 
    } 
    
    @RequestMapping(value="/deletestu/{id}",method = RequestMethod.GET)  
    public String deleteStu(@PathVariable String id) { 
    	stuDao.deleteStudentById(id);
    	return "redirect:../welcome"; 
    }
    
	  @RequestMapping(value="/lelele",method = RequestMethod.GET)
	  public ResponseEntity lelele(HttpServletRequest req) { 
		  String pulp = "THE DAMN FUNCTION IS WORKING T";
	  		req.getSession().setAttribute("pulp", pulp);
	  	    return new ResponseEntity(HttpStatus.NO_CONTENT);

} 
    
    
}


