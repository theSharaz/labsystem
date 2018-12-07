package controller;
import java.io.File;
import java.io.IOException;
import java.util.Date;





import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.multipart.MultipartFile;  
@Controller  
@RequestMapping("/file")  
public class FileUploadController {
	@RequestMapping(value = "/upload.do")  
    public String upload(@RequestParam(value="name") String name,@RequestParam(value = "file", required = false) MultipartFile file, 
    		  HttpServletRequest request, ModelMap model) {  
  
       
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String originalfileName = file.getOriginalFilename();  
        String SUFFIX =originalfileName.substring(originalfileName.lastIndexOf("."));
        String newfileName = originalfileName;  
        
        File uploadedFile = new File(path, newfileName);  
        if(!uploadedFile.exists()){  
        	uploadedFile.mkdirs();  
        }  
  
        try {  
            file.transferTo(uploadedFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+newfileName);  
  
        return "result";  
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
	   
	

private static void copyFileUsingApacheCommonsIO(File source, File dest) throws IOException {
    FileUtils.copyFile(source, dest);
}

  
}
