package dao;

import java.util.*;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import entity.*;
import java.io.IOException;
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
	        r = jdbcTemplate.update(sql, f.getId(), f.getName(),f.getFilename() ,f.getStuNum(), f.getClassno(), f.getState());
	        return r;
	    }
	    
	    public int stuAddFile(Files f) throws IOException {
	    	int r = 0;
	        System.out.println("file name is "+f.getName()+" \tFrom filesDAO stuaddfile");


	        String sql = "UPDATE files SET filename = '"+f.getFilename()+"', state = '"+f.getState()+
	        		"' WHERE stunum = '"+f.getStuNum()+"' AND id = '"+f.getId()+"' ";
	        r = jdbcTemplate.update(sql);
	        System.out.println(f.getName()+" file has been added to the DB");

	        return r;
	    }
	    
	    public List<Files> getFileByStu(int id) {
	        String sql = "select * from files WHERE stunum = '"+id+"'";
	        List nlist = jdbcTemplate.query(sql, new FilesInfo());
	        return nlist;
	    }
	    
	    public Files getFileByID(String id) {
	    	List<Files> nlist =  new ArrayList<Files>();
	        String sql = "select * from files WHERE id = '"+id+"'";
	        nlist = jdbcTemplate.query(sql, new FilesInfo());
	        Files f = null;
			for(Files s:nlist) {
				f =s;
			}
	        return f;
	    }
	    
	    public List<Files> getFileByStuClassID(String stunum, String classno) {
	    	List<Files> flist =  new ArrayList<Files>();
	        String sql = "select * from files WHERE classno = '"+classno+"' AND stuNum = '"+stunum+"'";

	        return flist;
	    }
	    public List<Files> getFileByStuClassID(int stunum, int classno) {
	    	List<Files> flist =  new ArrayList<Files>();
	        String sql = "select * from files WHERE classno = '"+classno+"' AND stuNum = '"+stunum+"'";

	        return flist;
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
			f.setFilename(rs.getString("filename"));
			f.setClassno(rs.getInt("classno"));
			f.setState(rs.getInt("state"));

			return f;
		}
	}

}
