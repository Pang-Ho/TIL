package edu.spring.semiproject;

import java.sql.Date;

public class BoardVO {
	String id, title, content, writer;
	Date writedate;
	int readcnt;
	String filename, filepath;
	
	public BoardVO() {};
	public BoardVO(String id, String title, String content, String writer, Date writedate, int readcnt, String filename,
			String filepath) {
		
		this.id = id;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writedate = writedate;
		this.readcnt = readcnt;
		this.filename = filename;
		this.filepath = filepath;
	}
	public BoardVO(String id) {
		
		this.id = id;
	}
	public BoardVO(String title, String content) {
		
		this.title = title;
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
}
