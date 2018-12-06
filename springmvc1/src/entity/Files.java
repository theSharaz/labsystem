package entity;

import java.io.File;
import java.io.FileInputStream ;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.Blob;

public class Files {
	private int id, stuNum, classno, state;
	private String name;
	private File file;
	private MultipartFile mfile;

	private FileInputStream inputStream;
	private FileOutputStream outputStream;
	private Blob blob;

	public Files(int id, String name, MultipartFile mfile, int stuNum, int classno, int state) {
		super();
		this.id = id;
		this.name = name;
		this.mfile = mfile;
		this.stuNum = stuNum;
		this.classno = classno;
		this.state = state;
	}
	
	public Files(int id, String name, File file, int stuNum, int classno, int state) {
		super();
		this.id = id;
		this.name = name;
		this.file = file;
		this.stuNum = stuNum;
		this.classno = classno;
		this.state = state;
	}



	public MultipartFile getMfile() {
		return mfile;
	}




	public void setMfile(MultipartFile mfile) {
		this.mfile = mfile;
	}




	public Files() {
		super();
	}

	
	public Blob getBlob() {
		return blob;
	}


	public void setBlob(Blob blob) {
		this.blob = blob;
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public FileInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(FileInputStream inputStream) {
		this.inputStream = inputStream;
	}




	public FileOutputStream getOutputStream() {
		return outputStream;
	}




	public void setOutputStream(FileOutputStream outputStream) {
		this.outputStream = outputStream;
	}
	
	


	
	
	
	
	
	
	

}
