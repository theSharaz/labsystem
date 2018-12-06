package controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;  
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import entity.*;
import entity.Class;
import dao.*;

@Controller  
@RequestMapping("/prof")
public class ProfController {
	
	@Autowired
	ProfessorDao profDao;
	@Autowired
	ClassDao clDao;
	@Autowired
	ProfClassDao profclDao;
	@Autowired
	BookedExpDao bexpDao;
	@Autowired
	FilesDao flDao;
    @Autowired
    StudentDao stuDao;
	
    static List<Professor> plist =new ArrayList<Professor>();
    static List<Student> stulist =new ArrayList<Student>();
    static List<Class> cllist =new ArrayList<Class>();
    static List<ProfClass> pcllist =new ArrayList<ProfClass>();
    static List<BookedExp> belist =new ArrayList<BookedExp>();
    static List<Files> flist =new ArrayList<Files>();
    HttpServletRequest req;

	HttpServletResponse res;
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
    public String queryCustomer(ModelMap model) {
        return "profLogin";  
    }
	
    @RequestMapping(value="/logg",method = RequestMethod.POST)
    public String loginAdmin(Professor pr, HttpServletRequest req) { 
    	if(profDao.validate(pr)) {
    		int id = pr.getProfnum();
    		req.getSession().setAttribute("pid", pr.getProfnum());
    		initDataLogin(id);
    		return "redirect:welcome";
    	}else {
        	System.out.println("shit aint working");

    		return "redirect:login";
    	} 
    }
	  @RequestMapping(value="/welcome",method = RequestMethod.GET)
	  public String Welcomepage(HttpServletRequest req) {
  		int id = (Integer) req.getSession().getAttribute("pid");


  		//initDataLogin(id);
  		
  		Professor profe = profDao.queryProfessorByID(id);
  		req.getSession().setAttribute("profe", profe);
  		cllist = clDao.allClass();    		
  		req.getSession().setAttribute("cllist", cllist);

//  		List elist = profDao.getFile(id);
//  		req.getSession().setAttribute("elist", elist);
  		pcllist = profclDao.allClassByProID(id);    		
  		req.getSession().setAttribute("pcllist", pcllist);
  		
  		int classno = 0;
  		for(ProfClass p: pcllist) {
  			classno = p.getClassno();
  		}
  		
  		stulist = stuDao.allStudentsByClass(classno);

		  
	      return "welcomeProf";  
	  }
	  
	  @RequestMapping(value="/changePass",method = RequestMethod.POST)
	  public String changePassw(Professor prof) { 
		  profDao.changePassword(prof);
		return "redirect:welcome";
  }

	  @RequestMapping(value="/selectclass/{cid}",method = RequestMethod.GET)
	    public String getProfClass(@PathVariable(value = "cid") int cid, HttpServletRequest req) {
  		belist = bexpDao.allBookedExpByClass(cid);
  		req.getSession().setAttribute("belist", belist);

	    	return "redirect:../view"; 


	    }
	  
	  @RequestMapping(value="/view",method = RequestMethod.GET)
	  public String Viewpage(HttpServletRequest req) {
  		int id = (Integer) req.getSession().getAttribute("pid");



	      return "ViewExpView";  
	  }
	  
	  
	    @RequestMapping(value="/deleteprof",method = RequestMethod.GET)  
	    public String deleteProf(@PathVariable String pid) { 
	    	return "redirect:../welcome"; 
	    } 
	    
	    @RequestMapping(value="/gets",method = RequestMethod.GET)
	    public String dodo() {
	    	return "redirect:welcome"; 

	    }
	    

	    @RequestMapping(value="/bookexp",method = RequestMethod.POST)
	    public String BookExp(BookedExp b,@RequestParam(value="name") String name) throws IOException {
	    	bexpDao.addBookedExp(b, name);
	    	return "redirect:view"; 

	    }
	    
	    public void initDataLogin(int id) {



	    }

    

}
