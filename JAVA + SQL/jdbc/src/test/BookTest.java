package test;

public class BookTest {

	public static void main(String[] args) {
		System.out.println("************************* ���� ��� ************************");
		BookDTO dto1 = new BookDTO(21424, "Java Basic", "���ϳ�", "Jaen.kr", 15000, "Java �⺻ ����");
		BookDTO dto2 = new BookDTO(33455, "JDBC Pro", "��ö��", "Jaen.kr", 23000, "");
		BookDTO dto3 = new BookDTO(55355, "Servlet/JSP", "���ڹ�", "Jaen.kr", 41000, "Model2 ���");
		BookDTO dto4 = new BookDTO(35332, "Android App", "ȫ�浿", "Jaen.kr", 25000, "Lighweight Framework");
		BookDTO dto5 = new BookDTO(35355, "OOAD�м�,����", "�ҳ���", "Jaen.kr", 30000, "");
		System.out.println(dto1);
		System.out.println(dto2);
		System.out.println(dto3);
		System.out.println(dto4);
		System.out.println(dto5);
		
	}

}
