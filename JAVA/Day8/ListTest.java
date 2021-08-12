package day8;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "DataBase");
		list.add("iBATIX");
		
		int size = list.size();
		System.out.println("ÃÑ °´Ã¼ ¼ö : " + size);
		System.out.println();
		
		String skill = list.get(2);
		System.out.println("2: " + skill);
		System.out.println();
		
		for(int i = 0 ; i < list.size() ; i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
		System.out.println();
		
		list.remove(2);
		list.remove(2);
		list.remove("iBATIX");
		
		int i = 0;
		for(String str : list) {
			i += 1;
			System.out.println(i + " : " + str);
		}
		
	}

}
