package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;  
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import entity.*;
import entity.Class;
import dao.*;

@Controller  
@RequestMapping("/stu")
public class StuController {
	
	@Autowired
	StudentDao stuDao;
	@Autowired
	BookedExpDao bexpDao;
	@Autowired
	FilesDao flDao;
	@Autowired
	StuClassDao stuclDao;
	@Autowired
	ClassDao clDao;
	@Autowired
	StateDao stateDao;
	@Autowired
	ExpRoomDao exproomDao;
	@Autowired
	BookDao bookDao;
	@Autowired
	FeedbackDao fdDao;
	
    static List<Student> slist =new ArrayList<Student>();
    static List<BookedExp> belist =new ArrayList<BookedExp>();
    static List<Files> flist =new ArrayList<Files>();
    static List<StuClass> cllist =new ArrayList<StuClass>();
    static List<Class> sclist =new ArrayList<Class>();
    static List<Class> clalist =new ArrayList<Class>();
    static List<ExpRoom> rlist =new ArrayList<ExpRoom>();
    static List<AvailableTime> avlist =new ArrayList<AvailableTime>();
    static List<Application> aplist =new ArrayList<Application>();
    static List<ApprovedTime> atlist =new ArrayList<ApprovedTime>();
    static List<Feedback> fdlist =new ArrayList<Feedback>();
    Student stud = new Student();
    static int classate = 0;
    
	HttpServletResponse res;


//	 http://localhost:8085/springmvc/stu/login
	@RequestMapping(value="/login",method = RequestMethod.GET)
    public String queryCustomer(ModelMap model) {
        return "stuLogin";  
    } 
	
    @RequestMapping(value="/logg",method = RequestMethod.POST)
    public String loginAdmin(Student st, HttpServletRequest req) { 
    	if(stuDao.validate(st)) {
    		req.getSession().setAttribute("uid", st.getStuNum());
    		
    		return "redirect:welcome";
    	}else {
    		return "redirect:login";
    	} 
    }
     

    @RequestMapping(value = "/uploadfile" , method = RequestMethod.POST)  
    public String upload(Files f,@RequestParam(value = "file", required = false) MultipartFile file, 
    		  HttpServletRequest request, ModelMap model) {  
  
       
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String originalfileName = file.getOriginalFilename();  
        String SUFFIX =originalfileName.substring(originalfileName.lastIndexOf("."));
//        String newfileName = originalfileName; 
      String newfileName = new Date().getTime()+SUFFIX;  

        
        File uploadedFile = new File(path, newfileName);  
        if(!uploadedFile.exists()){  
        	uploadedFile.mkdirs();  
        }  
  
        try {  
        	file.transferTo(uploadedFile); 
        	f.setFilename(newfileName);
        	flDao.stuAddFile(f);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
		return "redirect:welcome";
    }  
    

    
	  @RequestMapping(value="/welcome",method = RequestMethod.GET)
	  public String Welcomepage(HttpServletRequest req) {

			int id = (Integer) req.getSession().getAttribute("uid");
			String uid = String.valueOf(id);
  		 stud = stuDao.queryStudentByID(id);
  		req.getSession().setAttribute("stud", stud);
  		sclist = stuclDao.allStuClassByID(stud.getStuNum());
  		req.getSession().setAttribute("sclist", sclist);	
 		flist = flDao.getFileByStu(stud.getStuNum());
  		req.getSession().setAttribute("flist", flist);
  	  	rlist = exproomDao.queryAllExpRoom();
  	  	req.getSession().setAttribute("rlist", rlist);
  	  	avlist = bookDao.queryAllAvailableTime();
  	  	req.getSession().setAttribute("avlist", avlist);
  	  	atlist = bookDao.queryApprovedTimeByStu(id);
  	  	req.getSession().setAttribute("atlist", atlist);
  	  	aplist =  bookDao.queryApplicationByStu(uid);
  	  	req.getSession().setAttribute("aplist", aplist);
  		
      return "welcomeStu";  
	  } 
	  
	  @RequestMapping(value="/lelele",method = RequestMethod.GET)
	  public ResponseEntity lelele(HttpServletRequest req) { 
		  String pulp = "THE DAMN FUNCTION IS WORKING T";
	  		req.getSession().setAttribute("pulp", pulp);
	  	    return new ResponseEntity(HttpStatus.NO_CONTENT);

  } 
	  
	  @RequestMapping(value="/changePass",method = RequestMethod.POST)
	  public String changePassw(Student stu) { 
		  stuDao.changePassword(stu);
		return "redirect:welcome";
  } 
	  
	  @RequestMapping(value="/fileupload/{id}",method = RequestMethod.GET)
	  public ResponseEntity FileUpload(HttpServletRequest req,@PathVariable String id) {
		 Files fil =  flDao.getFileByID(id);
	  		System.out.println("SC fileupload: file "+fil.getName()+" has been retrieved from from the DB");

	  		req.getSession().setAttribute("fil", fil);

	  	    return new ResponseEntity(HttpStatus.NO_CONTENT);
	  }

	@RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
	   public void downloadFile1(HttpServletResponse response, HttpServletRequest request, @PathVariable String id) throws IOException {
	      String path = request.getSession().getServletContext().getRealPath("upload");  
	      String Name = id+".pdf";
		  File file = new File(path, Name);
	      response.setContentType("application/pdf");
	      response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
	      BufferedInputStream inStrem = new BufferedInputStream(new FileInputStream(file));
	      BufferedOutputStream outStream = new BufferedOutputStream(response.getOutputStream());
	      
	      byte[] buffer = new byte[1024];
	      int bytesRead = 0;
	      while ((bytesRead = inStrem.read(buffer)) != -1) {
	        outStream.write(buffer, 0, bytesRead);
	      }
	      outStream.flush();
	      inStrem.close();
	   }
	  
	  @RequestMapping(value="/selectclass/{cid}",method = RequestMethod.GET)
	  public ResponseEntity getStuClass(@PathVariable(value = "cid") int cid, HttpServletRequest req) {
	
		  System.out.println(cid);
		  belist = bexpDao.allBookedExpByClass(cid);
		  System.out.println("Booked list "+belist.size());

		  req.getSession().setAttribute("belist", belist);
		  return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
	  
	  
//	    @RequestMapping(value="/bookexp",method = RequestMethod.POST)
//	    public String BookExp(BookedExp b,@RequestParam(value="name") String name) throws IOException {
//	    	bexpDao.addBookedExp(b, name);
//	    	return "redirect:view"; 
//
//	    }
	  
	  @RequestMapping(value="/selectAvTime/{availableid}",method = RequestMethod.GET)
	  public ResponseEntity rejectAppliction(@PathVariable(value = "availableid") String availableid, HttpServletRequest req) { 
		  AvailableTime avtime = bookDao.queryAvailableTimebyID(availableid);
		  req.getSession().setAttribute("avtime", avtime);
		 return new ResponseEntity(HttpStatus.NO_CONTENT);
  } 
	  
	  @RequestMapping(value="/applyTime",method = RequestMethod.POST)
	  public ResponseEntity addAvTime(Application ap,HttpServletRequest req) { 
		  bookDao.addApplication(ap);
			aplist = bookDao.queryApplicationByStu(ap.getStunum());
			req.getSession().setAttribute("aplist", aplist);
			avlist = bookDao.queryAllAvailableTime();
			req.getSession().setAttribute("avlist", avlist);
	 return new ResponseEntity(HttpStatus.NO_CONTENT);
  } 
	  
	  @RequestMapping(value="/removeApp/{appid}",method = RequestMethod.GET)
	  public ResponseEntity removeApplication(@PathVariable(value = "appid") String appid, HttpServletRequest req) { 

			 bookDao.rejectApplication(appid);
			  aplist =  bookDao.queryApplicationByStu(stud.getStuNum());
			  req.getSession().setAttribute("aplist", aplist);
			  avlist =  bookDao.queryAllAvailableTime();
			  req.getSession().setAttribute("avlist", avlist);
		 return new ResponseEntity(HttpStatus.NO_CONTENT);
  } 
	  
	  @RequestMapping(value="/removeApproved/{id}",method = RequestMethod.GET)
	  public ResponseEntity removeApproved(@PathVariable(value = "id") int id , HttpServletRequest req) { 

			 bookDao.removeApprovedTime(id);
			  atlist = bookDao.queryApprovedTimeByStu(stud.getStuNum());
			  req.getSession().setAttribute("atlist", atlist);

		 return new ResponseEntity(HttpStatus.NO_CONTENT);
  } 
	  
	  @RequestMapping(value="/resetFilter",method = RequestMethod.GET)
	    public ResponseEntity resetFilter(HttpServletRequest req) {

		  avlist = bookDao.queryAllAvailableTime();
		  req.getSession().setAttribute("avlist", avlist);


	    return new ResponseEntity(HttpStatus.NO_CONTENT);
	    }
	  
	  @RequestMapping(value="/filterBook",method = RequestMethod.GET)
	    public ResponseEntity filterBook( String week, 
	      		String room, HttpServletRequest req) {
		  	
		  
		  if(room!=null &&  week!=null) {
			  avlist = bookDao.queryAvailableTimeByWEEKandROOM(week, room);
		  }else if(week!=null) {
			  avlist = bookDao.queryAvailableTimeByWEEK(week);
		  }else if(room!=null) {
			  avlist =  bookDao.queryAvailableTimeByROOM(room);
		  }
		  	  
		  req.getSession().setAttribute("avlist", avlist);
	    return new ResponseEntity(HttpStatus.NO_CONTENT);
	    }
		
	  @RequestMapping(value="/addFeedback",method = RequestMethod.GET)
	    public ResponseEntity filterBook(String comment, HttpServletRequest req) {
		  Feedback fb = new Feedback(0,comment,"");
		  fdDao.addAvailableTime(fb);
		  req.getSession().setAttribute("fdlist", fdlist);

	    return new ResponseEntity(HttpStatus.NO_CONTENT);
	    }
		
}


