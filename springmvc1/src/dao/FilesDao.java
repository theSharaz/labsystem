package dao;

import java.util.*;
import javax.annotation.Resource;
import java.io.FileOutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.mysql.jdbc.Blob;
import entity.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


@Component("fileDao")

public class FilesDao {
	
	
	  @Resource(name="jdbcTemplate")
	  private JdbcTemplate jdbcTemplate;

	  
	    public int addFile(Files f) throws IOException {
	    	int r = 0;

	        String sql = "insert into files values (?,?,?,?,?,?)";
	        r = jdbcTemplate.update(sql, f.getId(), f.getName(), f.getInputStream(),f.getStuNum(), f.getClassno(), f.getState());
	        return r;
	    }
	    
	    public int stuAddFile(Files f) throws IOException {
	    	int r = 0;
	        System.out.println("file size is "+f.getFile());

	    	f.setInputStream(new FileInputStream(f.getFile()));
	        System.out.println("file is being converted from  file to input stream FILESDAO addfile");
            
	        String sql = "UPDATE files SET file = '"+f.getInputStream()+"', state = '"+f.getState()+
	        		"' WHERE stunum = '"+f.getStuNum()+"'";
	        r = jdbcTemplate.update(sql);
	        System.out.println(f.getName()+" file has been added to the DB");

	        return r;
	    }
	    
	    public List getFileByStu(int id) {
	    	int r = 0;
	        String sql = "select * from files WHERE stunum = '"+id+"'";
	        List nlist = jdbcTemplate.query(sql, new FilesInfo());
	        return nlist;
	    }
	    
	    

	    public List getFileByClass(int id) {
	    	int r = 0;
	        String sql = "select * from files WHERE classno = '"+id+"'";
	        List nlist = jdbcTemplate.query(sql, new FilesInfo());
	        return nlist;
	    }
	public class FilesInfo implements RowMapper, Serializable {
		public Files mapRow(ResultSet rs, int rowNum) throws SQLException{
			Files f = new Files();
			f.setId(rs.getInt("id"));
			f.setStuNum(rs.getInt("stuNum"));
			f.setName(rs.getString("name"));
			f.setClassno(rs.getInt("classno"));
			f.setState(rs.getInt("state"));
			
			InputStream input = rs.getBinaryStream("file");
			
			if(rs.getBinaryStream("file")!=null) {
				try {
					f.setFile(stream2file(input, f.getName()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				f.setFile(null);
			}
			return f;
		}
	}
	
    public static final String SUFFIX = ".docx";

    public static File stream2file (InputStream in, String name) throws IOException {
        final File tempFile = File.createTempFile(name, SUFFIX);
        tempFile.deleteOnExit();
        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy(in, out);
        }
        return tempFile;
    }
    
    public File MPFtoFile(MultipartFile file) throws IOException
    {    
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile(); 
        FileOutputStream fos = new FileOutputStream(convFile); 
        fos.write(file.getBytes());
        fos.close(); 
        System.out.println("file is being converted from multipart file to file FILESDAO convert");

        return convFile;
    }

	
	
//    public static void readBlob(int candidateId, String filename) {
//        // update sql
//        String selectSQL = "SELECT resume FROM candidates WHERE id=?";
//        ResultSet rs = null;
// 
//        try (Connection conn = MySQLJDBCUtil.getConnection();
//                PreparedStatement pstmt = conn.prepareStatement(selectSQL);) {
//            // set parameter;
//            pstmt.setInt(1, candidateId);
//            rs = pstmt.executeQuery();
// 
//            // write binary stream into file
//            File file = new File(filename);
//            FileOutputStream output = new FileOutputStream(file);
// 
//            System.out.println("Writing to file " + file.getAbsolutePath());
//            while (rs.next()) {
//                InputStream input = rs.getBinaryStream("resume");
//                byte[] buffer = new byte[1024];
//                while (input.read(buffer) > 0) {
//                    output.write(buffer);
//                }
//            }
//        } catch (SQLException | IOException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        
//		try {
//			f.setOutputStream(new FileOutputStream(f.getFile()));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		f.setState(rs.getInt("state"));
//		
//		InputStream input = rs.getBinaryStream("file");
//
//        byte[] buffer = new byte[1024];
//        try {
//			while (input.read(buffer) > 0) {
//			    f.getOutputStream().write(buffer);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
//        System.out.println("file size is "+f.getFile().length());
// 
//    }
//

}
