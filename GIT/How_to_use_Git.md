1. 바탕화면에 TIL 폴더를 생성하여 **로컬 저장소** 생성

2. GIT BASH에서 **cd TIL** 를 쳐서 경로 설정

3. **git init** 을 쳐서 TIL 폴더에 Git 저장소를 생성 (.git) 폴더 생성

4. **touch README.md** 를 통해 파일 생성

5. **git add README.md** 를 통해 인덱스에 추가

   **git status**로 커밋될 준비가 된 파일 확인 가능

6. **git commit -m '메시지'**  을 통해 파일 변경 추가 등 저장소에 기록

7. **git status**로 커밋되었는지 확인

8. **git remote add origin** https://github.com/[유저네임]/[원격저장소 이름].git  을 통해 원격 저장소 정보를 추가

9. **git push origin master** 을 통해 로컬 저장소 내용을 원격 저장소에 반영 

* 커밋이란 파일이나 디렉토리 변경 내용을 저장소에 기록하는 작업
* 파일 변경 시 add 다시하고 커밋하여 푸쉬하면 됨.
  5번부터 9번 다시 실행 (8번 빼고)

## 원격저장소 위치 바꾸기

* git remote -v 원격저장소 위치 확인가능
* git remote set-url origin [주소] 로 저장소 위치 변경가능