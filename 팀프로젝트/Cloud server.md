# 클라우드 플랫폼 서버 세팅

## 같은 네트워크 망

* 같은 네트워크 망에서는 ip주소만 알면 http://서버ip주소 를 통해 접속 가능

## 다른 네트워크 망

* ??



## 포트 포워딩

* 외부에서 서버에 접속 방법

| 비공인ip                                   | 서버접속용 공인ip                                      | 공인ip                                                       |
| ------------------------------------------ | ------------------------------------------------------ | ------------------------------------------------------------ |
| 네이버 서버 내부 네트워크 내 연결 가능한ip | 포트포워딩을 통해 외부에서 서버에 접속할 수 있는 방법  | http://네이버서버ip:port/url                                 |
| port : 22 - 외부에서도 연결이 가능하도록   | port : 1024 ~ 65534 설정하기 난 3333                   |                                                              |
| 10.41.225.92                               | 서버 접속용 공인 IP : 210.89.188.236, 외부 포트 : 3333 | 49.50.172.118 (8662135)<br />port번호마다 타 서비스 전용<br />8080 : 톰캣<br />1521 : <br />3306 : mysql |

![image-20211026102052496](C:/Users/Pang/Desktop/TIL/md-images/image-20211026102052496.png)



![image-20211026102811468](C:/Users/Pang/Desktop/TIL/md-images/image-20211026102811468.png)

서버 이름kdigitalserver

관리자 이름root

비밀번호Y4a?h+*t!Tqfu => 1234

kidigital3-3 비밀번호 => J3J2JR3Etq => 1234



## 터미널 명령

```
//비번 바꾸는 명령
passwd root
//자바 컴파일러 버전 확인
javac - version
//위치 확인
witch tomcat / witch maven / witch tomcat

- 설치 사용 명령어
wget – 다운로드
tar cvf - 압축
tar xvf – 압축해제
yum – 다운로드+설치(yum repository에 등록한 패키지만 다운로드 설치 가능)
rpm – redhat package manager( 네이버서버는 리눅스 centos 7버전이고 centos는 redhat계열 리눅스임)
yum 레포에 등록되지 않아 다운로드 설치 불가능할 때 다운로드 설치

ls - 디렉토리 목록 확인
pwd - 현재 디렉토리 확인
cd - 디렉토리 이동
ln -s 폴더명 이름 - 심볼릭 링크 등록
find / which- 파일 찾기
```



## 클라우드 서버에 프로그램 설치

1. maven 설치 – spring 라이브러리 관리
2. jdk 설치 – 자바 컴파일 실행
3. tomcat 설치 – 웹서버
4. mysql 설치 – 데이터베이스서버



* maven 설치

  1. https://maven.apache.org/download.cgi 접속 

  2. 중간쯤 Files 제목에서 apache-maven-3.8.3-bin.tar.gz – 우클릭 - 링크 주소를 복사
      (설치시 인증 – 연결 오류등 뜨면 화면 상단에서 other mirrors 에서 다른 url로 변경

    https://downloads.apache.org/maven/maven-3/3.8.3/binaries/apache-maven-3.8.3-bin.tar.gz

	3. 메이븐 설치할 저장소로 이동. /usr/mydir 디렉토리 생성하여 저장.
	
	   디렉토리 생성 mkdir /usr/mydir
	   디렉토리 이동 cd /usr/mydir
	   현재폴더 확인 pwd
	
	4. 2번에서 복사한 링크 주소를 wget 명령어를 통하여 설치 파일 다운로드.
	
	   wget https://downloads.apache.org/maven/maven-3/3.8.3/binaries/apache-maven-3.8.3-bin.tar.gz
	
	5. 내려받은 tar.gz 파일 압축 해제.
	
	   tar -xvf apache-maven-3.8.3-bin.tar.gz
	
	6. 심볼릭 링크 등록
	
	   ln -s apache-maven-3.8.3 maven
	
	7. 환경변수 설정.
	
	   vi ~/.bash_profile - 환경변수 설정하는 명령어
	   이제 vi 명령어만 쓸 수 있음
	   
	   소문자 o 입력 빈 라인 확보 – 아래 입력
	   export MAVEN_HOME=/usr/mydir/maven
	   PATH=$PATH:$HOME/bin:$MAVEN_HOME/bin
	   
	   export PATH
	   esc 입력 후 아래 저장-종료 명령 입력 - 엔터
	   :wq
	   
	8. 환경변수 적용
	   source ~/.bash_profile
	
	9. 확인1
	   echo $PATH
	
	10. 확인2
	    (환경변수 설정한 값)mvn -version
	

* 참고 	
  vi edior
  아래 1줄 삽입 - o
  한 문자 삽입 - i
  한줄 삭제 - dd

