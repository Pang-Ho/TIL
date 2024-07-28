package edu.spring.naverserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PythonCall {

public static void main(String[] args) throws Exception{
	new PythonCall().test();
}

public void test() throws Exception{
	System.out.println("===파이썬 시작===");
	Process p = Runtime.getRuntime().exec("python C:/kdigital2/python397/소스/weather.py");
	BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"MS949"));
    String line = null;
    while((line = br.readLine()) != null){
       System.out.println(line);
    }
	System.out.println("===파이썬 종료===");
	
}

}
