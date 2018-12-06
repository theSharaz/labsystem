package controller;

import java.io.File;
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
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;  
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import entity.*;
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
	
    static List<Student> slist =new ArrayList<Student>();
    static List<BookedExp> belist =new ArrayList<BookedExp>();
    static List<Files> flist =new ArrayList<Files>();
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
    		int id = st.getStuNum();

    		

    		
    		return "redirect:welcome";
    	}else {

    		return "redirect:login";
    	} 
    }
     

    
//    @RequestParam(value="id") int id,@RequestParam(value="stuNum") int stuNum,@RequestParam(value="classno") int classno,@RequestParam(value="name") String name,@RequestParam(value = "file", required = false) File file,
//	@RequestParam(value="state") int state,ModelMap model, HttpServletRequest req
   
    @RequestMapping(value="/addfile", method = RequestMethod.POST)
    public String addfile(Files f, HttpServletRequest req) {
    Student stud = (Student) req.getSession().getAttribute("stud");
      int r=0;
      System.out.println("Name of file is "+f.getName()+" from stucontroller add file");
      String path = req.getSession().getServletContext().getRealPath("upload");  
      String originalfileName = f.getMfile().getOriginalFilename();  
      String extName=originalfileName.substring(originalfileName.lastIndexOf("."));
      String newfileName = new Date().getTime()+extName;  
      File targetFile = new File(path, newfileName);  
      f.setFile(targetFile);
      try {
		r = flDao.stuAddFile(f);
	} catch (IOException e) {
		e.printStackTrace();
	}
      if(r>0) {
          System.out.println("Upload ya "+stud.getStuNum()+" yaita");
      }
		return "redirect:welcome";
    }
    
    
//    @RequestMapping(value="/download",method = RequestMethod.GET)
//    public String upload(ModelMap model) throws FileUploadException, IOException, ServletException { 
//
//    	stuDao.getFile(id)
//    	
//		return "redirect:welcome";
//    }
    
	  @RequestMapping(value="/welcome",method = RequestMethod.GET)
	  public String Welcomepage(HttpServletRequest req) {
  		req.getSession().setAttribute("uid", 20150001);

		int id = (Integer) req.getSession().getAttribute("uid");
    		
  		Student stud = stuDao.queryStudentByID(id);
  		req.getSession().setAttribute("stud", stud);
//  		List nlist = stuDao.getFile(id);
//  		req.getSession().setAttribute("nlist", nlist);
		  
	 		belist = bexpDao.allBookedExpByClass(stud.getClassno());
	  		req.getSession().setAttribute("belist", belist);
	  		System.out.println("size of belist "+belist.size()+" from Stucontroller welcome");
	  		
	 		flist = flDao.getFileByStu(stud.getStuNum());
	  		req.getSession().setAttribute("flist", flist);
	  		System.out.println("size of file list "+flist.size()+" from Stucontroller welcome");
	  		
	  		

			
	      return "welcomeStu";  
	  } 
	  
	  @RequestMapping(value="/changePass",method = RequestMethod.POST)
	  public String changePassw(Student stu) { 
		  stuDao.changePassword(stu);
		return "redirect:welcome";
  } 
}
