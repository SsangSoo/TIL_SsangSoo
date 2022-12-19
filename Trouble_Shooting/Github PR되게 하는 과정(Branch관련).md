인텔리제이에서 Github와 연동시켜서 지지고 볶아봤다. 

시나리오는 이렇다.
Github에서 레포를 하나 만들고, 인텔리제이에서 Spring 사이트에서 프로젝트를 하나 받고, 받아온 프로젝트를 깃허브에 Push하는 과정..
그리고, 하나의 브랜치를 더 만들어서 PR을 보내는 과정..

# 일단 나는 영어 몬한다..
브랜치로 지지고 볶아보고, 이래저래 와리가리 하다가, 그냥 이렇게 하면 되겠구나라고 생각하게 되었다.

---


Spring 사이트에서 프로젝트를 받아왔다. 그리고 인텔리제이에서 프로젝트를 열었다.
처음 브랜치이름은 Master로 되어있었고, Github에서 생성한 브랜치 이름은 main으로 되어있다.

자! 일단 해야될 것! 먼저 local Repo랑 Remote Repo랑 연결을 해줘야한다.

> 사실 제일 먼저 해줘야 할 것은 인텔리제이에서 Github아이디와 연동시켜줘야 한다.
인텔리제이의 File - Settings - 검색창에 Github - 동그라미 영역의 '+' 버튼 눌러서 Log in via Github...를 누른다.
![](https://velog.velcdn.com/images/tjdtn4484/post/d5ba8db5-8c14-4f1c-9959-62f1d2750e1f/image.png)
(나는 이미 연동 되있지렁이~... ㅈㅅ.)

여튼 그리고 Apply - OK 하면 일단 깃허브 아이디와 연동된다.

그리고, 깃허브 아이디와 연동했으면 그 다음 해야될것! 이제 local Repo랑 Remote Repo랑 연결을 해줘야한다!

아.. 그전에 지금 나는 Git과 연동 시켜놔서

![](https://velog.velcdn.com/images/tjdtn4484/post/3472effa-dca7-4abc-9e7a-8cf5c85e0726/image.png)
이렇게 나오지만, 원래는 저기가 **VCS**로 되어있다. (뭔지 모른다...대충 그냥 감으로만 알아서..여튼..) **VCS**를 클릭하고, 젤 처음의 **Enable~~머시기**가 있다. 그거 누르고, Git으로 설정해주자.

이제 ㄹㅇ 진짜... local Repo랑 Remote Repo랑 연결을 해줘야한다!!!

![](https://velog.velcdn.com/images/tjdtn4484/post/226cc39a-fb49-4fdd-9434-8ddc4058feee/image.png)

Git - Manage Remote를 눌러서
![](https://velog.velcdn.com/images/tjdtn4484/post/326927a9-7cc6-4de3-a554-0b9b19392b40/image.png)
요거 누르고, 원격저장소(origin)하고, URL(Github Repo)로 연동시켜주면 된다.
그리고 OK하고, 그럼 이제 local Repo랑 Remote Repo랑 연결이 된거다.

인텔리제이에서 master로 되어있다만, **fetch**해주면 된다.
그러면 브랜치 이름이 바껴있을 것이고, 그리고,
![](https://velog.velcdn.com/images/tjdtn4484/post/c50b8a83-a499-4c38-b79e-b5e4afe558c3/image.png)

커밋 누르고, 커밋할 부분들 체크하고, 커밋 메세지를 적어준다. 
그리고, commit을 하면 커밋이 되고, push까지 하려면, ![](https://velog.velcdn.com/images/tjdtn4484/post/7b78c51c-fde1-4003-8ff5-333c197eda49/image.png)
요거 눌러주면된다.

그러면, local Repo에서 remote Repo의 어디로 push할지 정하고, push해주면 쫜~! 하고, push successful(철자맞는지 몰겠다...여튼)하면서 push 완료되었다는 메세지가 이쁘게 뜬다.



그리고, 다른 브랜치를 생성해서 PR이 되게하려면,,,,,

# 일단 내가 겪은 문제는 두 개의 브랜치가 서로 연결이 안 되어있었기도 했고, local에서 dev라는 브랜치로 remote Repo의 main 브랜치로 넣으면 되는 줄 아는 착각 때문에 삽질 좀 했다..

사실 삽질했지만, 그냥 이렇게 하면 되구나란 방법을 찾았지.. 어떤 삽질 과정을 겪었는지는...흠...죄다 영어라서, 그냥 이렇게 크게 적은 내용만으로 이해했을 뿐...

여튼...


일단은
![](https://velog.velcdn.com/images/tjdtn4484/post/8d2df381-714e-4435-8490-11781f045cd2/image.png)

이렇게 Remote Repo의 main브랜치와 같은 이름의 local Repo에서 **New Branch from 'main'..**을 클릭한다.

그러면 main과 연결된 브랜치가 하나 생성될것이다. 일단 dev는 내가 만들었기 때문에, 다른걸로 한 번 해보겠다...
아니다. dev와 연결된 feat이라는 브랜치 하나 만들어보겠다.
![](https://velog.velcdn.com/images/tjdtn4484/post/f3b7c111-39b9-44b4-bcd2-a0f5fcfd8808/image.png)

인텔리제이 하단의 이 부분이 지금 헤더가 가리키는 브랜치라고 생각쓰 하면된다. 
![](https://velog.velcdn.com/images/tjdtn4484/post/c8ce6200-a081-4423-b0b6-75353e464e39/image.png)

feat이라는 브랜치 하나 생성
![](https://velog.velcdn.com/images/tjdtn4484/post/f4ce020d-fc49-4d67-b861-b639014c2796/image.png)

위에 Checkout branch를 체크하고, **CREATE**한 결과, feat 브랜치로 바꼇다.
![](https://velog.velcdn.com/images/tjdtn4484/post/51868480-ecbc-483a-8659-4b01cde96af4/image.png)

기존 코드에서 이런 코드를 추가 작성했다고 가정하자.

![](https://velog.velcdn.com/images/tjdtn4484/post/162074de-587f-460e-a6cf-11d7dc5e1aef/image.png)

일단 이렇게 나옴.

그리고, 똑같이 Git 탭의 Fetch를 하면
![](https://velog.velcdn.com/images/tjdtn4484/post/52d70567-c45c-4f7a-b0b2-9fc8046f458b/image.png)

요래 나온다.
그리고 , commit and Push 를 누르면,![](https://velog.velcdn.com/images/tjdtn4484/post/6ce58873-8f21-4204-a8f7-1eeb0392f047/image.png)

이렇게 나오고, 
**PUSH**를 빠방 하자!
![](https://velog.velcdn.com/images/tjdtn4484/post/d9c289fb-ec11-4244-b43a-b0bf409d5b5b/image.png)
커밋이라, push 되었다고 뜬다!

![](https://velog.velcdn.com/images/tjdtn4484/post/e788a5e3-b971-4ca5-ad20-edb856206eb8/image.png)
원격에서 만들어지쥬~?
![](https://velog.velcdn.com/images/tjdtn4484/post/32cab353-475a-4846-9aba-11694c8b0d40/image.png)
그리고, Pull requests에서 새로운 PR을 하려고 하면, feat 브랜치가 main브랜치로, Pull Request하려고 한다. 
그래서 TITLE 적고, 내용 적고, "PR 요청해요~" 하면 알아서 될 것이다~!!!


후후..
끝.



[이거 해당 레포 주소~!](https://github.com/SsangSoo/Todo-App)
