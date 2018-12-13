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
	@Autowired
	StateDao stateDao;
	@Autowired
	StuClassDao stuclDao;
	@Autowired
	ProfClassDao profclDao;
	@Autowired
	BookedExpDao bexpDao;
	@Autowired
	FilesDao flDao;
	
    static List<Professor> plist =new ArrayList<Professor>();
    static List<Student> slist =new ArrayList<Student>();
    static List<Class> clist =new ArrayList<Class>();
    static List<StuClass> sclist =new ArrayList<StuClass>();
    static List<ProfClass> pclist =new ArrayList<ProfClass>();
    static List<BookedExp> belist =new ArrayList<BookedExp>();
    static List<Files> flist =new ArrayList<Files>();

    static int state;
	

	HttpServletResponse res;
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
    public String loginPage(ModelMap model) {
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
	  public String addStu(Student stu) { 
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
    	state = stateDao.getState();
    	req.getSession().setAttribute("state", state);

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
	  
	  @RequestMapping(value="/changestate/{cstate}",method = RequestMethod.GET)
	    public ResponseEntity changeState(@PathVariable(value = "cstate") int cstate, HttpServletRequest req) {
	    
		stateDao.changeStatus(cstate);
		state = stateDao.getState();
	    req.getSession().setAttribute("state", state);

	    return new ResponseEntity(HttpStatus.NO_CONTENT);
	    }	  
	  
	  @RequestMapping(value="/selectclass/{classno}",method = RequestMethod.GET)
	    public ResponseEntity classInfo(@PathVariable(value = "classno") int classno, HttpServletRequest req) {
			Class clas =  new Class();
			clas = clDao.getClassByID(classno);
			req.getSession().setAttribute("clas", clas);
		  	slist = stuclDao.allClassByStuClassID(classno);
			req.getSession().setAttribute("slist", slist);
			
		    List<Student> stulist =new ArrayList<Student>();
		    stulist = stuDao.allStudents();
		    
		    for(int i=stulist.size()-1;i>=0;i--) {

			    for(int j=0;j<slist.size();j++) {
			    	 if(stulist.get(i).getStuNum()==slist.get(j).getStuNum()) {
			 			System.out.println(stulist.get(i).getStuNum() +" = "+ slist.get(j).getStuNum());
			 			

			    	 }
			    }
		    }
			System.out.println("# of students: "+stulist.size());
			req.getSession().setAttribute("stulist", stulist);

			
			ProfClass pc = profclDao.classByClassID(classno);
			Professor prof = new Professor();
			prof = profDao.queryProfessorByID(pc.getProfnum());
			req.getSession().setAttribute("prof", prof);
			belist = bexpDao.allBookedExpByClass(classno);
			req.getSession().setAttribute("belist", belist);
			flist = flDao.getFileByClass(classno);
			req.getSession().setAttribute("flist", flist);

	    return new ResponseEntity(HttpStatus.NO_CONTENT);
	    }
	  
	  
	  @RequestMapping(value="/addStuClass",method = RequestMethod.POST)
	  public ResponseEntity addStutoClass(@PathVariable(value = "stuNum") int stuNum,@PathVariable(value = "classno") int classno) { 
		  
		  StuClass st = new StuClass(0, classno, stuNum);
		  stuclDao.addClass(st);
		  
		return new ResponseEntity(HttpStatus.NO_CONTENT);
  }  

}


