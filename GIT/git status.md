```bash
$ git status
On branch master
# 트래킹되고 있지 않은 파일들 (Working directory)
Untracked files:
# Staging area에 포함시키기 위해서는 git add를 해.
# Staging area -> 커밋 대상 파일들 모아놓는 공간(커밋이 될 예정인 것들)
  (use "git add <file>..." to include in what will be committed)
        new.txt

# 커밋하기 위해 추가된 것은 없는데,untracked files는 존재한다.
# Working directory -> 파일 있어
# Staging area -> 파일 없어
nothing added to commit but untracked files present (use "git add" to track)
```

```bash
$ git status
On branch master
# 커밋될 변경사항들 (staging area)
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   new.txt
```

```bash
$ git status
On branch master
# Staging area (Staged O)
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   new.txt


# staged X (커밋을 위해)
# Working directory
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   2.txt

# 트래킹 X
# Working directory
Untracked files:
  (use "git add <file>..." to include in what will be committed)
        hi.txt


```

