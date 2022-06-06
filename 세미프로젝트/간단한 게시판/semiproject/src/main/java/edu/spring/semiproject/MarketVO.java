package edu.spring.semiproject;

public class MarketVO {
	String id, pw, name, mail;

	public MarketVO(String id, String pw, String name, String mail) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.mail = mail;
	}

	public MarketVO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public MarketVO(String pw, String name, String mail) {
		super();
		this.pw = pw;
		this.name = name;
		this.mail = mail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "아이디 : " + id + "\n" + "비밀번호 : " + pw + "\n" + "이름 : " + name + "\n" + "메일 : " + mail;
		
	}
	
}
