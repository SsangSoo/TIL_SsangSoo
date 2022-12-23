> ⚡ 생각대로 살지 않으면 사는대로 생각한다. 
> ⚡ 나는 어차피 잘 될 놈이다. 이미 잘 되고 있고, 계속해서 잘 되고 있다.

---

# Git branch
브랜칭(branching)은 기존 개발중인 메인 개발 코드를 그대로 복사하여 새로운 기능 개발을 메인 개발 코드를 건드리지 않고 할 수 있는 버전 관리 기법이다.



> ### 브랜치 생성하기/변경하기 (git switch)
* 새로운 브랜치로 Git이 바라보는 곳, HEAD를 변경하는 작업을 switch라고 한다.
* 브랜치를 생성할 때는 생성(create)의 의미로 -c 를 붙여줘야 하고, 기존에 있는 브랜치로 옮길 때는 붙이지 않아도 된다.

```
# feature라는 브랜치를 새로 생성하는 경우, -c를 붙임.
$ git switch -c feature

# checkout이라는 명령어도 사용할 수 있다.
$ git checkout -b feature

# 기존에 있던 main 브랜치로 HEAD를 변경하려면, -c를 붙이지 않는다.
$ git switch main
$ git checkout main
```

> ### 브랜치 합치기(git merge)

```git
# 기능 개발이 진행됨.
$ git commit -m "기능1의 세부 기능1"
$ git commit -m "기능1의 세부 기능2"
$ git commit -m "기능1 개발 완료"

# 머지를 위해 main 브랜치로 전환
$ git switch main

# main 브랜치로 feat/todo 브랜치를 병함
$ git merge feat/todo
```

---
**실제 개발 시**에는 로컬에서 합치기 보다는 Github의 pull request 기능을 이용하여 변경 내역을 충분히 확인하고 난 다음에 머지~~(가 머지? 사실 알고 있지..후후)~~하는 경우가 더 많기 때문에, 로컬에서 머지(Merge)하지 않고 feature 브랜치를 push하여 pull request를 요청하는 것을 권장한다.

```
# Github 리포지토리로 푸시
$git push origin 리포지토리

# Github에서 Pull Request.
```

[toast UI](https://github.com/nhn/tui.editor/pull/2633)에서 `pull request`와 `코드 리뷰`를 참고할 수 있다.


> ### 브랜치 삭제하기 (git branch -d)
* 보통 머지된 feature 브랜치는 이미 dev 브랜치에 기록이 완벽하게 남아있기 때문에 굳이 남겨둘 이유가 없어 삭제를 권장하는 편이다.

```git
git branch -d 브랜치명
```
Git은 원활한 버전 관리를 위해서, 브랜치가 합쳐지지 않으면 삭제하지 못하도록 설정이 되지만, 종종 다 만들지 못한 기능의 기록을 삭제하고 싶을 때는 `-D` 옵션을 쓰면 삭제할 수 있다.
```git
git branch -D 브랜치명
```
다만, 머지되지 않은 브랜치 삭제는 버전 기록 시스템의 사용 목적과는 맞지는 않다. 
잘 못 만들었던 기능이지만, 해당 기능으로 돌아가는 경우가 있기 때문에 돌아갈 여지를 만들어두는게 좋을 수도 있다. 이런 경우는 팀 및 회사 정책에 따르는 것을 권장한다고 한다.


# Git 명령어
(feat. CC,CV (복붙) )

## Git 설정
로컬 레포지토리와 연결할 유저 정보를 설정한다.
```
# 버전 히스토리를 식별할 때 사용할 이름을 설정합니다.
$ git config --global user.name "[firstname lastname]"
```
```
# 각 기록과 연결할 이메일 주소를 설정합니다.
$ git config --global user.email “[valid-email]”
```

## 도움말 보기
help 명령어를 이용하여 각 명령어 및 옵셥의 기능에 대해 살펴볼 수 있다.
```
# git에서 제공하는 모든 명령어를 볼 수 있습니다.
$ git help -all
```
```
# 특정 command에서 사용할 수 있는 모든 옵션을 볼 수 있습니다.
$ git [command] -help
```

## 세팅 및 초기화
레포지토리를 초가화하거나 존재하는 레포지토리를 클론할 수 있다.
```
# 현재 디렉토리를 기준으로 Git 저장소가 생성됩니다.
$ git init
```
```
# URL을 통해 리모트 레포지토리를 로컬 레포지토리에 복제합니다.
$ git clone [url]
```
## Stage & Commit
스테이지 영역을 이용하여 커밋할 수 있다.
```
# 다음 커밋을 위해 현재 디렉토리에서 수정된 파일을 확인할 수 있습니다.
$ git status
```
```
# 다음 커밋을 위해 파일을 추가(스테이지)합니다. (stage)
$ git add [file]
```
```
# 추가한 파일을 언스테이징합니다. 변경 사항은 유지됩니다.
$ git reset [file]
```
```
# 스테이지되지 않은 변경 사항을 보여줍니다.
$ git diff
```
```
# 스테이지했지만 커밋하지 않은 변경 사항을 보여줍니다.
$ git diff --staged
```
```
# 스테이지된 컨텐츠를 메시지와 함께 커밋합니다. (스냅샷 생성)
$ git commit -m “[descriptive message]”
```

## Branch & Merge
작업 내역을 브랜치로 분리해 컨텍스트를 변경, 통합할 수 있다.
```
# 브랜치 목록을 보여줍니다. * 표시로 현재 작업중인 브랜치를 확인할 수 있습니다.
$ git branch
```
```
# 현재 커밋에서 새로운 브랜치를 생성합니다.
$ git branch [branch-name]
```
```
# 다른 브랜치로 전환합니다.
$ git switch [branch-name]
$ git checkout [branch-name]

# 새로은 브랜치를 생성하고 해당 브랜치로 전환합니다.
$ git switch -c [branch-name]
$ git checkout -b [branch-name]
```
```
# 현재 브랜치에 특정 브랜치의 히스토리를 병합합니다.
$ git merge [branch-name]
```
```
# 현재 브랜치의 모든 커밋 히스토리를 보여줍니다.
$ git log
```

## 비교 및 검사
로그 및 변경 사항을 검사할 수 있다.
```
# 브랜치B에 없는 브랜치A의 모든 커밋 히스토리를 보여줍니다.
$ git log branchB..branchA
```
```
# 해당 파일의 변경 사항이 담긴 모든 커밋을 표시합니다. (파일 이름 변경도 표시)
$ git log --follow [file]
```
```
# 브랜치A에 있지만 브랜치B에 없는 것의 변경 내용(diff)을 표시합니다. (branch간 상태 비교)
$ git diff branchB...branchA
```

## 공유 및 업데이트
특정 레포지토리의 업데이트 사항을 검색하여 로컬 레포지토리를 업데이트 할 수 있다.
```
# url을 통해 특정 리모트 레포지토리를 별칭으로 추가합니다.
$ git remote add [alias] [url]
```
```
# 별칭으로 추가한 리모트 레포지토리에 있는 모든 브랜치 및 데이터를 로컬로 가져옵니다.
$ git fetch [alias]
```
```
# 리모트 브랜치를 현재 작업중인 브랜치와 병합하여 최신 상태로 만들 수 있습니다.
$ git merge [alias]/[branch]
```
```
# 로컬 브랜치의 커밋을 리모트 브랜치로 전송합니다.
$ git push [alias] [branch]
```
```
# 리모트 레포지토리의 정보를 가져와 자동으로 로컬 브랜치에 병합합니다.
$ git pull
```

## 히스토리 수정
브랜치 또는 커밋을 수정하거나 커밋 히스토리를 지울 수 있다.
```
# 특정 브랜치의 분기 이후 커밋을 현재 작업중인 브랜치에 반영합니다.
$ git rebase [branch]
```
```
# 득정 커밋 전으로 돌아가며 스테이지된 변경 사항을 모두 지웁니다.
$ git reset --hard [commitish]
```

## 임시 저장
브랜치를 전환하기 위해 변경되었거나 추적중인 파일을 임시로 저장할 수 있다.
```
# 수정하거나 스테이지된 변경사항을 스택에 임시 저장하고 현재 작업 내역에서 지웁니다.
$ git stash
```
```
# 스택에 임시 저장된 변경사항의 목록을 보여줍니다.
$ git stash list
```
```
# 스택에 임시 저장된 변경사항을 다시 현재 작업 내역에 적용합니다.
$ git stash apply
```
```
# 스택에 임시 저장된 변경사항을 다시 현재 작업 내역에 적용하고 스택에서 삭제합니다.
$ git stash pop
```
```
# 스택에 임시 저장된 변경사항을 삭제합니다.
$ git stash drop
```
