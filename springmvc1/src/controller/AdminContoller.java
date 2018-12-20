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
	@Autowired
	ExpRoomDao exproomDao;
	@Autowired
	BookDao bookDao;
	@Autowired
	FeedbackDao fdDao;
	
    static List<Professor> plist =new ArrayList<Professor>();
    static List<Student> slist =new ArrayList<Student>();
    static List<Student> sslist =new ArrayList<Student>();
    static List<Class> clist =new ArrayList<Class>();
    static List<StuClass> sclist =new ArrayList<StuClass>();
    static List<ProfClass> pclist =new ArrayList<ProfClass>();
    static List<BookedExp> belist =new ArrayList<BookedExp>();
    static List<Files> flist =new ArrayList<Files>();
    static List<ExpRoom> rlist =new ArrayList<ExpRoom>();
    static List<AvailableTime> avlist =new ArrayList<AvailableTime>();
    static List<Application> aplist =new ArrayList<Application>();
    static List<ApprovedTime> atlist =new ArrayList<ApprovedTime>();
    static List<Feedback> fdlist =new ArrayList<Feedback>();
    static Admin admin = new Admin();
    static int state;
	

	HttpServletResponse res;
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
    public String loginPage(ModelMap model) {
        return "adminLogin";  
    } 
	
//	  http://localhost:8085/springmvc/admin/welcome
	  @RequestMapping(value="/logg",method = RequestMethod.POST)
	  public String loginAdmin(Admin ad,HttpServletRequest req) { 
	  	if(adDao.validate(ad)) {
	  		admin = adDao.queryAdminsByName(ad.getName());
	  	  	req.getSession().setAttribute("admin", admin);

	  		return "redirect:welcome";
	  	}else {

	  		return "redirect:login";
	  	} 
	  }  

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
  	rlist = exproomDao.queryAllExpRoom();
  	req.getSession().setAttribute("rlist", rlist);
  	avlist = bookDao.queryAllAvailableTime();
  	req.getSession().setAttribute("avlist", avlist);
  	atlist = bookDao.queryAllApprovedTime();
  	req.getSession().setAttribute("atlist", atlist);
  	aplist =  bookDao.queryAllApplication();
  	req.getSession().setAttribute("aplist", aplist);
  	fdlist =  fdDao.queryFeedback();
  	req.getSession().setAttribute("fdlist", fdlist);

      return "welcome";  
  } 
  
  @RequestMapping(value="/changePass",method = RequestMethod.POST)
  public String changePassw(Admin ad) { 
	  adDao.changePassword(ad);
	return "redirect:welcome";
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

//	  @RequestMapping(value="/addStu",method = RequestMethod.POST)
//	  public String addStu(Student stu) { 
//		  stuDao.addStudent(stu);
//		return "redirect:welcome";
//  }  
  
  @RequestMapping(value="/addStu",method = RequestMethod.POST)
  public ResponseEntity addStu(Student stu,HttpServletRequest req) { 
	  stuDao.addStudent(stu);
  	slist = stuDao.allStudents();
  	req.getSession().setAttribute("slist", slist);
	    return new ResponseEntity(HttpStatus.NO_CONTENT);
}  
	  
	  @RequestMapping(value="/addRoom",method = RequestMethod.POST)
	  public String addRoom(ExpRoom room) { 
		  exproomDao.addExpRoom(room);
		return "redirect:welcome";
  } 
	  
	  @RequestMapping(value="/addAvTime",method = RequestMethod.POST)
	  public ResponseEntity addAvTime(AvailableTime av,HttpServletRequest req) { 
		  bookDao.addAvailableTime(av);
			avlist = bookDao.queryAvailableTimeByROOM(av.getRoom());
			req.getSession().setAttribute("avlist", avlist);
	 return new ResponseEntity(HttpStatus.NO_CONTENT);
  } 
	
	  @RequestMapping(value="/approveApplication/{id}",method = RequestMethod.GET)
	  public ResponseEntity approveAppliction(@PathVariable(value = "id") String id, HttpServletRequest req) { 
		  Application ap = bookDao.queryApplicationByID(id);
		  ApprovedTime apt = new ApprovedTime(0,ap.getClassno(),ap.getStunum(),ap.getWeek(),ap.getDay(),ap.getStart(),ap.getFinish(),ap.getRoom(),ap.getAvailableid());
		  int r =0 ;
		  System.out.println("ap "+ap.getWeek());

		  System.out.println("apt "+apt.getWeek());
		 r = bookDao.addApprovedTime(apt);
		 
		 
		 if (r!=0) {
			 bookDao.rejectApplication(id);
		 }
		 
		  atlist = bookDao.queryAllApprovedTime();
		  req.getSession().setAttribute("atlist", atlist);
		  aplist =  bookDao.queryAllApplication();
		  req.getSession().setAttribute("aplist", aplist);
		
		 return new ResponseEntity(HttpStatus.NO_CONTENT);
  } 
	  
	  @RequestMapping(value="/rejectAppliction/{id}",method = RequestMethod.GET)
	  public ResponseEntity rejectAppliction(@PathVariable String id, HttpServletRequest req) { 

			 bookDao.rejectApplication(id);
			  atlist = bookDao.queryAllApprovedTime();
			  req.getSession().setAttribute("atlist", atlist);
			  aplist =  bookDao.queryAllApplication();
			  req.getSession().setAttribute("aplist", aplist);
		 return new ResponseEntity(HttpStatus.NO_CONTENT);
  } 
	  
	  @RequestMapping(value="/removeApproved/{id}",method = RequestMethod.GET)
	  public ResponseEntity removeApproved(@PathVariable(value = "id") int id , HttpServletRequest req) { 

			 bookDao.removeApprovedTime(id);
		 return new ResponseEntity(HttpStatus.NO_CONTENT);
  } 
	  
 
    
    @RequestMapping(value="/deleteprof/{id}",method = RequestMethod.GET)  
    public String deleteProf(@PathVariable String id) { 
    	profDao.deleteProfessorById(id);
    	return "redirect:../welcome"; 
    } 
    
//    @RequestMapping(value="/deletestu/{id}",method = RequestMethod.GET)  
//    public String deleteStu(@PathVariable String id) { 
//    	stuDao.deleteStudentById(id);
//    	return "redirect:../welcome"; 
//    }
    
    @RequestMapping(value="/deletestu/{id}",method = RequestMethod.GET)  
    public ResponseEntity deleteStu(@PathVariable String id, HttpServletRequest req) { 
    	stuDao.deleteStudentById(id);
    	slist = stuDao.allStudents();
    	req.getSession().setAttribute("slist", slist);
  	    return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    
    
    
    @RequestMapping(value="/deleteroom/{id}",method = RequestMethod.GET)  
    public String deleteRoom(@PathVariable String id) { 
    	exproomDao.deleteExpRoom(id);
    	return "redirect:../welcome"; 
    }
    
    @RequestMapping(value="/deleteAvTime/{id}",method = RequestMethod.GET)  
    public ResponseEntity deleteAvTime(@PathVariable String id, HttpServletRequest req) { 
    	bookDao.deleteAvailableTime(id);
		String roomid = (String) req.getSession().getAttribute("roomid");

		avlist = bookDao.queryAvailableTimeByROOM(roomid);
		req.getSession().setAttribute("avlist", avlist);
  	    return new ResponseEntity(HttpStatus.NO_CONTENT);
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
		    List<Student> stlist =new ArrayList<Student>();

		    stlist = stuclDao.allClassByStuClassID(classno);
			req.getSession().setAttribute("stlist", stlist);
			
			sslist = stuclDao.studentsNotInClassByClassID(classno);
			req.getSession().setAttribute("sslist", sslist);
			
			
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
	  
	  @RequestMapping(value="/selectroom/{room}",method = RequestMethod.GET)
	    public ResponseEntity roomInfo(@PathVariable(value = "room") String room, HttpServletRequest req) {


		avlist = bookDao.queryAvailableTimeByROOM(room);
		req.getSession().setAttribute("avlist", avlist);
		req.getSession().setAttribute("roomid", room);


	    return new ResponseEntity(HttpStatus.NO_CONTENT);
	    }
	  
	  
	  @RequestMapping(value="/resetFilter",method = RequestMethod.GET)
	    public ResponseEntity resetFilter(HttpServletRequest req) {

		  atlist = bookDao.queryAllApprovedTime();
		  req.getSession().setAttribute("atlist", atlist);
		  aplist =  bookDao.queryAllApplication();
		  req.getSession().setAttribute("aplist", aplist);

	    return new ResponseEntity(HttpStatus.NO_CONTENT);
	    }
	  
	  @RequestMapping(value="/filterBook",method = RequestMethod.GET)
	    public ResponseEntity filterBook(String classno, String week, 
	    		String room, HttpServletRequest req) {
		  
		  
		  if(classno!=null &&  week!=null) {
			  aplist = bookDao.queryApplicationByWEEKandClassno(week, classno);
			  atlist =  bookDao.queryApprovedTimeByWEEKandClassno(week, classno);
		  }else if(week!=null) {
			  aplist = bookDao.queryApplicationByWeek(week);
			  atlist =  bookDao.queryApprovedTimeByWeek(week);
		  }else if(classno!=null) {
			  aplist = bookDao.queryApplicationByClass(classno);
			  atlist =  bookDao.queryApprovedTimeByClass(classno);
		  }
		  
		  
		  req.getSession().setAttribute("atlist", atlist);
		  req.getSession().setAttribute("aplist", aplist);

	    return new ResponseEntity(HttpStatus.NO_CONTENT);
	    }
	  
	  
	  @RequestMapping(value="/addStuClass",method = RequestMethod.POST)
	  public ResponseEntity addStutoClass(StuClass st) { 

		  stuclDao.addClass(st);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
  }  

}


