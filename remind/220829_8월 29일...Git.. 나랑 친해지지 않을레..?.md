Git은 버전 관리 시스템이다.

버전 관리 시스템이란?
파일 수정을 시도했다가 되돌리지 못할 상황을 발생하는 경우가 종종 있다...갑자기 삭제되는... 그와 같은 상황을 대비해서 이전의 내용을 보존해주는 시스템이 있는데..그게 바로 버전관리 시스템이다.

그 중 하나가 Git!

Git으로 버전 관리, 백업, 협업을 유용하게 _~~(강력크하게..)~~_ 할 수 있다.

버전관리 사용하는 이유
1. 파일 수정 이력을 저장가능.
2. 이전 버전으로 되돌아갈 수 있음..(작업하다가 맘에 안들어서 되돌리고 싶을 떄 쉽게 가능하다는 의미)
3. 무엇이 변경되었는지 알아보기 쉽다.
4. 협업도 좋고, 백업도 수월.


그럼 Git과 같이 사용하는 GitHub가 있다. 둘의 용도는 뭘까?

Git : 소스 코드 기록을 관리하고 추적할 수 있는 버전 관리 시스템
Github : Git Repository를 관리할 수 있는 클라우드 기반 시스템
쉽게 말해서 Git으로 버전을 관리하고, Giuhub은 Git으로 관리한 파일들의 버전을 클라우드로 저장하는 온라인 원격 저장소 기능을 제공해준다.
Git으로 관리한 파일을 GitHub로 업로드하면 그 업로드된 파일을 버전 관리, 협업, 백업이 가능하다.

Git의 저장소를 Git Repository라고 하는데, 작업하는 소스코드폴더의 버전 관리를 받게 하기 위해 Local 컴퓨터의 폴더를 Git과 관련지어서 Git의 관리 아래 두는 것, 쉽게 말해서 Git으로 관리되는 폴더를 Git Repository라고 한다. 
_~~(깃 레뽜지또뤼.. 레포라고도 함.)~~_

그 중 두 종류의 저장소(레포)가 있는데, Local이냐 Remote냐로 나뉜다. (로컬이냐? 원격이냐...) 

내가 작업한 건 Local에 저장하고, Local에 저장한 것을 을 공유할 때, Remote Repository로 공유하면 됨. 
그리고 다른 사람이 그 사람의 Remote Repository에 공유한 것을 나한테 가져올 수 있음..(pull or clone)

git의 명령어의 기능은 다음과 같다.
다른 사람의 Remote Repository를 나의 Remote Repository로 복사해오는 것 : Fork
나의 Remote Repository에서 Local Repository로 가져오는 것 : clone
코드 변경사항을 저장하는 명령어 : commit
commit된 파일들을 Local Repository에서 나의 Remote Repository로 올려주는 작업 : Push
Push완료 후, Github로 Pull request(요청)를 통해서 Fork해왔던 다른 사람의 공유 remote 레포로 반영 여부를 요청 가능하다.
다른 사람의 Remote Repository에서 나의 Local Repository로 가져오는 작업 : Pull



먼저 
git을 설치하면, 가장먼저 사용자 이름과 이메일 주소를 설정해야함.
git bash로 다음과 같은 명령어로 설정하면됨.

```
$ git config --global user.name "나의 사용자 이름"
$ git config --global user.email "내 이메일 주소"
```
~~_나는 마소 앱스토어로 우분투를 실행시켜서 git을 체험했다._~~
잘 들어갔으면 오류 메시지 없이 다음 프롬프트 명령줄이 뜰 것이다!
_~~(리눅스는 잘 들어갔으면 아무 반응이 없다. 근데 잘 못 들어가면 잘 못 들어간다고 바로 바로 빠른 피드백을 준다.)~~_
--global 옵션은 한번만 설정하면 된다고한다. 혹여, 사용자이름이나 이메일을 변경해야 한다면, 다시 명령어를 줌으로서 변경이 가능하다고 한다.
(※ 만약 프로젝트를 여러개 진행하면서 프로젝트마다 다르게 사용자이름과 이메일 주소를 사용하려면 global 옵션을 빼면 된다..)

텍스트 에디터는 기본적으로 vi가 열린다는데, 그것도 변경이 가능하다고 한다.
```
$ git config --global core.editor.nano 
```
를 입력하면 vi가 아니라 nano로 변경된다함..

git -scm에서 설정확인을 하려면, 

```
$ git config --list를 하면 된다고 함..
```


ssh로 git과 github 연결하는 법.
git에서 
$ ssh-keygen을 입력하면, 사용자 홈디렉터리에 .ssh디렉터리가 있고, 그 안에 
id-rsa / id-rsa.pub 두개의 파일이 생성된다.
이 두 파일을 ssh 키 페어라고 한다.

pub는 공개키라고 한다. _~~(public의 약자인듯..? 자바에서 접근제어자 public도 접근 제한이 없는데..비슷한 맥락인듯..)~~_
그리고 id-rsa는 나만 보관해야하는 키. 개인 키라고도하고, 비밀 키라도고 한다._~~(쁘라이빗이랑 시크릿 키)~~_

여튼 공개키를 복사한다. (터미널에서 명령어로 id_rsa.pub 파일 내용 확인)
리눅스는 다음과 같다.

```
cat id_rsa.pub
```

그리고 자신의 Github에서 프로필의 setting을 들어간다.![](https://velog.velcdn.com/images/tjdtn4484/post/f7a65858-6393-40ab-8add-4ff358d3a64d/image.PNG)

그러면 왼쪽 사이드에 Access에서 열쇠모양의 SSH and GPG keys가 나옴.

그럼 SSH keys 탭에서 초록색 버튼 New SSH key를 누른다.
그럼 key제목을 쓰고,  Key라고 넓은 칸에 복사했던 공개키를 붙인 후, Add SSH key하면 
![](https://velog.velcdn.com/images/tjdtn4484/post/c6289dd1-67d7-43e6-8cc9-5c006ea38c3c/image.PNG)
이렇게 나온다.


git에서 push를 하면 명령어가 보통 이렇던데 ,,
git push origin main
origin이 뜻하는 것은 원격저장소의 이름을 뜻한다고 한다.

그래서 
git remote add [origin(원격저장소 이름)] [해당저장소url]
로서 추가하면 push가 이루어진다.
 
git branch 이름 변경(master에서 main으로)_~~(master는 뭔가 주종 관계의 느낌으로.. 뭔가 단어에 그런 늬앙스가 있다고 한다..)~~_

```
$ git branch -m master main

```

```
$ git remote add [해당원격저장소이름] [복사한 url] 
```
ㄴ> 원격저장소의 이름은 지정하고 싶은대로 하면 된다.
그럼 그 원격저장소의 이름과 브랜치를 지정해서 push나 pull이 가능하다.

$ git push [원격저장소이름] [해당브랜치] 
명령어를 입력하면 GitHub에 commit한 파일들이 올라가있다.
(이거 보고 깜짝 놀람..)


어떤 폴더에서 
$ git clone URL페이지 
를하면 하위에 URL페이지와 연결된 github의 local repo와 연결된다.


정말 중요하다고 생각했던 내용은 아래와 같다.

아무 폴더나 지정해서 push를 넣으면 안된다.
폴더에서
```
$git remote -v 
```
로 연결이 되어있나 안 되어있나 확인 해보면된다.

그리고 remote된게 있으면 그폴더는 git repo와 연결이 된것이다.

리눅스를 예로들어서
연결된 폴더에서 
$ cd .. 해보자
그럼 상위폴더로 가는데 그 상위폴더에서 
$ git remote -v 하면 맟아무거도 나오지 않는다면..


그건 git과 관련없는 폴더다..

예를 들어서 사진과 같이 /home/kss10/git 디렉터리에서 
```
$ git remote -v
```
명령어를 넣어보면 사진과 같이 아무것도 뜨지 않는다.

![](https://velog.velcdn.com/images/tjdtn4484/post/1123ad4f-6a7d-4fe8-b366-2c4b61a86489/image.PNG)

~~_CLI는 틀렸으면, 바로바로 피드백을 준다.. 반면에 명령어가 잘 들어가면 군말없다.._~~
그리고, /home/kss10/git의 하위에 있는 be-simple-git-workflow 디렉터리에서 또 다음 명령어를 넣어보자.
```
$ git remote -v
```

![](https://velog.velcdn.com/images/tjdtn4484/post/fe4263d8-8caa-4eae-b493-e63779a29cf1/image.PNG)

이렇게 연결된 목록이 뜬다.
/home/kss10/git/ 은 연결된 목록이 없기 때문에, git과 연결된 폴더가 아니지만, 
/home/kss10/git/be-simple-git-workflow/ 에서는 연결된 목록이 보인다. 그래서 해당 폴더는 git과 연결된 폴더이다.!
~~_(막 git을 접해본 입장에선 이게 좀.. 아니 좀이 아니라 그냥 크게 느껴진다..)_~~

오늘은 여기까지...

> 나는 어차피 잘 될 놈이다.

ㅋ.

9.2일 수정..
지금 화면은 WSL2로 우분투로 실습한 내용인데..
리눅스 root계정으로라도 윈도우 영역인 /mnt/c/.... 로 들어가면, 권한이 거부된다...그러나 리눅스 영역으로 가면 군말없이 된다...

차라리 윈도우에서 git을 하려면 Git bash를 쓰는 게 낫다...
