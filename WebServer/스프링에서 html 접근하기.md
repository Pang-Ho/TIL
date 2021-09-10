![image-20210909002127585](../md-images/image-20210909002127585.png)

src/main/webapp/resouces에 css, image, js을 저장하는 경우

src/main/webapp/resouces/templates에 html을 저장한 경우

* 이미지 불러오기

  => <img src="/컨텍스트명/resources/imgs/logo.png" alt="Logo"

* 만약 imgs/logo.png로 쓰면 http://localhost:9090/myapp/resources/templates/imgs/logo.png로 인식함
* 결국 서로 다른 폴더에 있기에 컨텍스트 루트부터 쓴다.



views에 있는 jsp가 이미지 불러올 경우

src="resources/imgs/logo.png"
