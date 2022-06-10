# MySQL 설치 방법



**Homebrew 설치**

Homebrew 홈페이지 : https://brew.sh/index_ko

* 터미널에 코드 입력

~~~bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
~~~



**MySQL 설치**

* mysql 검색

  ~~~bash
  brew search mysql
  ~~~

* mysql 설치

  ~~~bash
  brew install mysql
  ~~~

* mysql 서버 시작

  ~~~bash
  mysql.server start
  ~~~

* mysql 초기 설정

  ~~~bash
  mysql_secure_installation
  ~~~

* mysql 로그인

  ~~~bash
  mysql -u root -p
  ~~~

  설정한 비밀번호 입력하고나면 터미널 커서가 mysql> 로 바뀌면서 사용할 수 있게 된다.