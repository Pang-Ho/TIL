# 자바에서 api 호출해서 사용하기



## 네이버 감정분석 api

* 요청 http post

* 요청 헤더 

  * X-NCP-APIGW-API-KEY-ID:{Client ID}
  * X-NCP-APIGW-API-KEY:{Client Secret}
  * Content-Type: application/json

* 요청 바디

  * 필드명 content 타입 String

* 요청 예시

  ```shell
  {
    "content": "싸늘하다. 가슴에 비수가 날아와 꽂힌다."
  }
  ```



```java
package sentiment;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class sentiment {

    public static void main(String[] args) {
    	String clientId = "a915v5yfhq";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "FWK3yoC7jAZM11s0ac3VetPJ1ycVCORFnOCHbqIU";//애플리케이션 클라이언트 시크릿값";
        try {
            String apiURL = "https://naveropenapi.apigw.ntruss.com/sentiment-analysis/v1/analyze";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            //json으로 message를 전달하고자 할 때 
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoInput(true);  // InputStream으로 응답 헤더와 메시지를 읽어들이겠다는 옵션
			con.setDoOutput(true); //POST 데이터를 OutputStream으로 넘겨 주겠다는 설정 
			con.setUseCaches(false);
			
            //요청 바디 json 형태로 보내야됨.
            OutputStream outputStream = con.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
            writer.append(
            		"{\"content\": \"싸늘하다. 가슴에 비수가 날아와 꽂힌다.\"}"
            		);
            writer.flush();
            BufferedReader br = null;
            
            
            int responseCode = con.getResponseCode();
            if(responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            String inputLine;

            if(br != null) {
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            } else {
                System.out.println("error !!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
}
}

```

* 콘솔 값

```java
{"document":{"sentiment":"negative","confidence":{"negative":99.3676,"positive":0.0077638607,"neutral":0.62463653}},"sentences":[{"content":"싸늘하다.","offset":0,"length":5,"sentiment":"negative","confidence":{"negative":0.9961359,"positive":2.2740211E-4,"neutral":0.0036366575},"highlights":[{"offset":0,"length":4}]},{"content":" 가슴에 비수가 날아와 꽂힌다.","offset":5,"length":17,"sentiment":"negative","confidence":{"negative":0.927976,"positive":7.042612E-4,"neutral":0.07131973},"highlights":[{"offset":1,"length":15}]}]}
```

