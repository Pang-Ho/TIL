package vo;

public class BoardVO {
	int seq;
	String title, contents, writer, time;
	int pw, view;
	//���� Ŭ���� - default ���� = ��Ű�� ���� = no modifier
	

	
	public void setSeq(int seq) {
		this.seq = seq;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}
	
	public void setView(int view) {
		this.view = view;
	}
	public String getTitle() {
		return title;
	}
	public String getContents() {
		return contents;
	}
	public int getView() {
		return view;
	}
	public int getPw() {
		return pw;
	}
	public int getSeq() {
		return seq;
	}
	public String getTime() {
		return time;
	}
	public String getWriter() {
		return writer;
	}
	
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", contents=" + contents + ", writer=" + writer + ", time="
				+ time + ", pw=" + pw + ", view=" + view + "]";
	}
	
}
