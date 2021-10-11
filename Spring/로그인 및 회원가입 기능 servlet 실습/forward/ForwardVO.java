package forward;

public class ForwardVO {
	String id;
	String pw;
	String name;
	String mail;
	public ForwardVO(String id, String pw, String name, String mail) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.mail = mail;
	}
	public ForwardVO(String pw, String name, String mail) {
		this.pw = pw;
		this.name = name;
		this.mail = mail;
	}
	public ForwardVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public ForwardVO(String id) {
		this.id = id;
	}
	
	public String toString(){
		return "아이디 : " + id + "비밀번호 : " + pw + "이름 : " + name + "이메일 : " + mail;
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
	
	
}
