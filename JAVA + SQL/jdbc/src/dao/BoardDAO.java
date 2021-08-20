package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.BoardVO;


public class BoardDAO {

	public int insertBoard(BoardVO vo) {
		Connection con = null;
		int row = 0;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("���� ����");
		
		String sql = "insert into board values(board_num_seq.nextval,'" + vo.getTitle() + "', '" + vo.getContents() + "', '" + vo.getWriter()
		 										+ "', sysdate, " + vo.getPw() +  ", 0)";  
		Statement st = con.createStatement();
		row = st.executeUpdate(sql);
		System.out.println(row + " ���� �� ���ԵǾ����ϴ�.");
		
		con.close();
		System.out.println("���� ��������");
		
		}
		catch (ClassNotFoundException e) {
			System.out.println("����̹� Ŭ���� ��ġ Ȯ���ϼ���");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con.isClosed() == false) {
					con.close();
					System.out.println("finally ���� ���� ����");
				}
			}
			catch ( SQLException e) {	
				e.printStackTrace();
			}
		}
		return row;
	}

	public BoardVO getBoard(int seq) {
		Connection con = null;
		BoardVO vo = new BoardVO();
		int num= 0, views =0;
		String title = null, content = null, writer = null, time = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("���� ����");
		
		String sql = "select num, title, content, writer, time, views from emp where num = " + seq; //��ü ���ڵ��� ��ü �÷� ��ȸ
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql); 

		while(rs.next()) {
			num = rs.getInt("num");
			title = rs.getString("title");
			content = rs.getString("content");
			writer = rs.getString("writer");
			time = rs.getString("time");
			views = rs.getInt("views");
			System.out.println(num + "\t" + title + "\t" + content + "\t" + writer + "\t" + time + "\t" + views);
		}

		con.close();
		System.out.println("���� ��������");
		
		}
		catch (ClassNotFoundException e) {
			System.out.println("����̹� Ŭ���� ��ġ Ȯ���ϼ���");
		}
		catch (SQLException e) { //���̺�� �ٸ�, ���� �߸� �Ἥ ���� �߸���, 
			e.printStackTrace();
		}
		finally {
			try {
				if(con.isClosed() == false) {
					con.close();
					System.out.println("finally ���� ���� ����");
				}
			}
			catch ( SQLException e_) {	
			}
		}
		vo.setSeq(num);
		vo.setTitle(title);
		vo.setContents(content);
		vo.setWriter(writer);
		vo.setTime(time);
		vo.setView(views);
		return vo;
	}
}
