package test;

public class BookTest {

	public static void main(String[] args) {
		System.out.println("************************* 도서 목록 ************************");
		BookDTO dto1 = new BookDTO(21424, "Java Basic", "김하나", "Jaen.kr", 15000, "Java 기본 문법");
		BookDTO dto2 = new BookDTO(33455, "JDBC Pro", "김철수", "Jaen.kr", 23000, "");
		BookDTO dto3 = new BookDTO(55355, "Servlet/JSP", "박자바", "Jaen.kr", 41000, "Model2 기반");
		BookDTO dto4 = new BookDTO(35332, "Android App", "홍길동", "Jaen.kr", 25000, "Lighweight Framework");
		BookDTO dto5 = new BookDTO(35355, "OOAD분석,설계", "소나무", "Jaen.kr", 30000, "");
		System.out.println(dto1);
		System.out.println(dto2);
		System.out.println(dto3);
		System.out.println(dto4);
		System.out.println(dto5);
		
	}

}
