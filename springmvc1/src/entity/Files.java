package entity;

import java.io.File;
import java.io.FileInputStream ;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.Blob;

public class Files {
	private int id, stuNum, classno, state;
	private String name, filename;

	public Files(int id, String name, int stuNum, int classno, int state) {
		super();
		this.id = id;
		this.name = name;
		this.stuNum = stuNum;
		this.classno = classno;
		this.state = state;
	}
	
	

	public Files(int id, String name, String filename, int stuNum, int classno, int state) {
		super();
		this.id = id;
		this.name = name;
		this.filename = filename;
		this.stuNum = stuNum;
		this.classno = classno;
		this.state = state;
	}

	

	public String getFilename() {
		return filename;
	}



	public void setFilename(String filename) {
		this.filename = filename;
	}



	public Files() {
		super();
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStuNum() {
		return stuNum;
	}

	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}

	public int getClassno() {
		return classno;
	}

	public void setClassno(int classno) {
		this.classno = classno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

}
