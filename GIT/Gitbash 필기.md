# Git

## 버전관리

* 크로미움 - 크롬 브라우저의 오픈소스
* 구글 다큐먼트로 버전을 관리할 수 있음

## Git

* 분산버전관리시스템으로 코드 버전 관리 도구
* 컴퓨터 파일 변경사항 추적 / 여러명 사용자들간 해당파일 조율

## 분산버전관리시스템 (DVCS)

* 중앙집중식버전관리시스템은 중앙에서 버전관리
* 분산버전관리시스템은 원격 협업, 모든 히스토리를 클라이언트들이 공유

1. 작업하면
2. add하여 Staging area에 모아서
3. commit 으로 버전 기록

* modified : 파일이 수정된 상태 
* staged : add명령어로 올린 상태
* committed : 최신 버전이 되는 상태

## Git Bash

![image-20210804113448660](C:/Users/Pang/Desktop/md-images/image-20210804113448660.png)

* Graphic User Interface                                        Command Line Interface

### Git Bash명령어

* ls - 리스트 보기
* touch 2.txt - 2.txt 파일 생성
* pwd - Print Working Directory 현재 작업중인 디렉토리 출력
* mkdir test  - Make Directory test폴더
* cd test - test 파일로 디렉토리 변경
  * .. : 상위 디렉토리
  * . : 현재 디렉토리
* touch <파일명>
  * touch READEME.md

### Git 명령어

* git init - .git 저장소(폴더)가 생성, master 표기 됨 
* git add - 내가 작업한것을 add해서 commit 하는것
  * untracked 상태 파일을 staged로 변경 , modified 상태 파일을 staged로 변경
  * working directory /add/ staging area /commit/
  * git add .  -> 현재 모든거 다 커밋
* commit - staged 상태의 파일들을 커밋을 통해 버전으로 기록
  * git commit -m 'Add a.txt'
* git log - 저장소에 기록된 커밋을 조회 가능 
  * git log -1 - 1줄로보겠다

  * git log -2 

  * git log --oneline

  * git log --oneline --graph  

  * git rm -rf {폴더, 파일 이름} - 로컬저장소, 원격저장소에서 삭제

    커밋 하면 적용됨

  * git rm -r --cached "폴더이름" - 원격저장소에서 삭제
* touch a.txt
  git add a.txt
  git commit -m 'Init'
  git push origin master
  git remote -v

## 파일 라이프사이클

Tracked : 이전부터 버전으로 관리되고 있는 파일

* Unmodified : git satus에 나타나지 않음
* Modified : Changes not staged for commit
* Staged : Changes to be commited

## 원격저장소 활용 명령어

* 저장소 만들기
  * git clone [url주소] 
    * .git 폴더까지 받아와서 과거 로그까지 볼 수 있음
  * git init 
    * 저장소 초기화
* 작업하면서
  * git add 
  * git commit -m '메세지'
* 원격저장소
  * git remot add origin [주소] 페이지에 있는 어떤거 
    * 깃아 원격저장소 추가해줘 origin이라는 이름으로 url을
  * git remote rm origin
    * 원격저장소 주소 제거
  * git push origin master

## TIL(Today I Learned)

1 til 폴더 만들고 저장소로 설정

2. readme.md 파일 만들고 add commit
3. 원격저장소 만들고
4. push . remote설정 git push origin maseter
5. 반복

##  Git hub에서 변경하면...

* Github에서 변경하고 나중에 gitbash로 푸쉬하면

  서로 버전이 달라 충돌이 생김

* git pull origin master로 버전을 받고 coflict 파일을 수정하고, add 후 commit

## Branch

* branch 생성

  ```bash
  git branch test
  ```

* A라는 branch로 변경

  ```bash
  git checkout test
  ```

* test라는 branch 생성 및 이동

  ```bash
  git checkout -b test
  git switch -b test
  ```

* branch A 상태에서 쓰면 B와 합쳐짐

  ```bash
  git merge test
  ```

  * merge하면 branch 삭제해줘야함

* branch 목록

  ```bash
  git branch
  ```

* branch 삭제

  ``` bash 
  git branch -d {branchname}
  ```

# Branch merge 상황

## fast-forward

* 기존 master에서 변경 없어서 자동 병함

## merge commit



#
