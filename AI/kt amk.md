## AMK

스피커 + 라즈비언(라즈베리파이 소형컴퓨터)

![image-20210923093034831](../md-images/image-20210923093034831.png)

## AMK 접속 방법

* 무선 네트워크를 사용하는 노트북에서 공유 네트워크를 이용해 AMK를 같은 무선 네트워크 망을 사용하게 한다.

* ssh 파일과 wpa_supplicant.conf를 통해 무선 네트워크에 들어갈 수 있음

* wpa_supplicant.conf(무선 네트워크 아이디와 패스워드)

  ```python
  ctrl_interface=DIR=/var/run/wpa_supplicant GROUP=netdev
  update_config=1
  country=US
  
  network={
  	ssid="mynotebook"
  	psk="kdigital"
  	key_mgmt=WPA-PSK
  }
  ```

* vncviewer를 통해 같은 네트워크 망을 사용하는 AMK 서버로 들어갈 수 있다.

* cmd를 통해 AMK가 접속한 무선 랜 ip주소를 확인

* 노트북 ipconfig하면 ip주소가 192.168.137.1 

  // 모바일핫스팟 ip주소 192.168.137.49

* ![image-20210923193754156](C:/Users/PANG/Desktop/TIL/md-images/image-20210923193754156.png)

* 서버 접속시 username - pi  // password - raspberry

* kt 서버에 접속하기 위해 api key가 필요

  바탕화면에서 clientkey.json을 받고,

  home/pi/downloads/clientkey.json

  이걸 user_auth.py 에 clientKey, id, url 복붙

## 톰캣서버 접속방법

노트북 - 스프링서버 - 웹브라우저 - http://localhost/...

노트북 - 스프링서버 - amk - 웹브라우저 - http://노트북 ip주소:port/file



## 터미널

pwd : 현재 폴더 경로

ls : 현재 디렉토리 안에 폴더

cd : 현재 디렉토리 안에 폴더로 이동

python3 ex1.py : python3폴더안에 ex1.py 실행

mkdir : 새로운 디렉토리 만듦

rm 파일/ rm -r 폴더 : 파일 또는 폴더 삭제

cp 원본 / 변경 : 파일 복사



## AMK 예제

* 1번째 예제 ex1_kwstest.py

  기가지니 호출어 듣고 => kt 서버에서 음성=>텍스트 변환=>벨소리로 반응

* 2번째 예제 ex2

  sound to text (STT)

* 3번째 예제, 4번째 예제

  text to sound (TTS)

  터미널에서 aplay testtts.wav로 파일 재생

* 5번째 예제, 6번째 예제

  문자로 질문하면 문자로 답변

  음성으로 질문하면 텍스트로 답변

* 7번째 예제, 8번째 예제

  기가지니로 호출하고 음성을 텍스트로 변환

  기가지니로 호출하고 음성 질문을 텍스트 답변

* 9번째 예제

  버튼 누르고 음성 질문을 텍스트로 답변

## AMK 예제를 이용한 프로그램 만들기

1. 2, 4 번 예제를 이용해서 음성 내용을 음성 파일로 변환
2. 2, 4 번 예제를 이용해서 음성 내용에 대한 설정한 답변을 음성으로 내보냄