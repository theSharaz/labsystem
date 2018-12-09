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
  		req.getSession().setAttribute("uid", 20150001);

		int id = (Integer) req.getSession().getAttribute("uid");
    		
  		Student stud = stuDao.queryStudentByID(id);
  		req.getSession().setAttribute("stud", stud);
	 		belist = bexpDao.allBookedExpByClass(stud.getClassno());
	  		req.getSession().setAttribute("belist", belist);
	 		flist = flDao.getFileByStu(stud.getStuNum());
	  		req.getSession().setAttribute("flist", flist);
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
	  
}


