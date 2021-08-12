package day9;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileClassTest {

	public static void main(String[] args) throws IOException{
		//명령행 매개변수 입력 :  a.txt , . -->  File객체로 생성
		File f = new File(args[0]); //현재프로젝트폴더
		if(f.exists()) {
			//파일인지
			if(f.isFile()) {
				System.out.println("읽기(입력)가능여부=" + f.canRead());
				System.out.println("쓰기(출력)가능여부=" + f.canWrite());	
				System.out.println("파일경로=" + f.getCanonicalPath());
				System.out.println("파일크기(byte단위)=" +  f.length());
				
				Date d = new Date(f.lastModified());//  1/1000초 --> 년 월 ...
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초");
				
				System.out.println("최종수정시각(...)=" + sdf.format(d));
			}
			else{//디렉토리
				String details[] = f.list();
				for(String one : details) {
					System.out.println(one);
					
				}
			}
			
		}
		else {
			System.out.println(args[0] + " 는 존재하지 않습니다.");
		}

	}

}
