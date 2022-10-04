# 원격 프로그램 호출

클라이언트의 브라우저에서 서버의 원격 프로그램을 실행하기 위해서는 Tomcat과 같은 WAS(웹 애플리케이션 서버)를 필요로 하다.

클라이언트에서 브라우저의 URL을 통해서 요청정보를 보내면, 서버의 Tomcat과 같은 WAS가 객체를 생성한 후, 내부의 메서드를 실행한다.

그런데 원격 프로그램에 있는 프로그램을 실행시키기 위해선 두 가지의 작업이 필요한데, 
1. 원격 프로그램 호출
2. 요청한 URL과 메서드를 Mapping해줘야한다.

* 원격 프로그램 호출 같은 경우, @Controller 애너테이션을 사용.
* 요청한 URL과 메서드를 Mapping하기 위해선 @RequestMapping 애너테이션을 사용.

그런데 말입니다~? ~~(feat. 그알 김상중)~~
이상한 점은 Tomcat에서 메서드의 제어자에 static 없이, 인스턴스 메서드로 메서드를 작성했음에도 불구하고, 메서드를 실행시킨다... 무슨 일이 발생한걸까..?
분명 인스턴스가 생성되었다는 것을 의미하는데.....
맞다.. 다름 아니라 ~~귀여운~~ Tomcat이 ~~요염하게~~ 인스턴스를 생성해서, 메서드를 실행시키고 있더라는 것이다...

```
public void main() {
 System.out.println("Hello");
 }
 ```
 이런식으로...static이 없다..
이처럼 Tomcat이 내부적으로 객체를 생성하고, 그 내부의 메서드를 실행시키는 것이다.

그런데 말입니다~? ~~(feat. 그알 김상중)~~
또 이상한 점은 위의 메서드의 접근제어자를 private으로 선언하더라도, `외부`에서 원격프로그램을 호출하면, 실행이된다.

```
@Controller // import는 모른다.. 뭐.. java. << 여기서 시작하 Get Z;;;
class Main {
	@RequestMapping("hello")	// 역시 import는 모름..;;
   	private void main() {
     System.out.println("Hello");
   }
}
```
이렇게 private으로 접근을 막았음에도 불구하고, 외부에서 호출하면, 저기 메서드가 실행된다...;;

슨상님의 표현으로는..
"@RequestMapping으로 URL을 Mapping한 것이 외부에서 호출 가능하도록 한다"는 것이다.
접근제어자가 private이든 (디폴트)이든, 보호~~protect~~이든 public이든,,간에 그냥 ~~냅다~~ 외부 호출하게 한다는 것이다.


그리고, 또 스프링이 이렇게 접근제어자가 private임에도 불구하고, 이렇게 사용할 수 있는 이유는 
스프링이 `Reflection API`을 사용하기 때문에 가능하다는 것..

**Reflection API**이란, 클래스 정보를 얻고 다룰 수 있는 강력한 API를 제공한다..

Reflection API로 클래스 정보를 얻어오는 방법..기억은 안 난다. 기억 안 나면 로직으로, 대체하겠다...
~~...쩝 써보려니 안된다. 밑에서 키보드 커서 뒀다가 다시 올라와서, 기억 안 난다고 한탄중..~~
```
// Class 객체로, 클래스 정보를 얻어온다.
// Class 객체가 클래스 정보를 가진 설계도라고도 하셨다.
// Class 객체를 통해서 newInstance()로, 객체를 생성한다.
Method main = ~~.getDeclared("main"); << 이래 메서드 정보 얻어와서,
main.invoke(hello);		// hello.main();과 같음..
```
여튼 이렇게 찍으면, 접근제어자가 private임에도 불구하고, 메서드 호출이 이뤄진다.
```
4번째 5번째 줄 중간에
blabla.setAccible(true); // 이렇게 하면, private에 접근가능하다고 한다.
```
여튼 이런식으로, Reflection API를 사용하기 때문에, 가능한 일들이라고 한다.
~~이거 쓸 줄 몰라도 된다했으니,, 뭐 로직으로라도, 알고있자... 사실 중간중간 봤긴했는데.. 다시써봐야지...~~
```
Class Hello = Class.forName(com.fastcampus.hello);
Hello hello = Hello.newInstance();
Method main = hello.getDeclared("main");
main.setAccible(true);
main.invoke(hello):
```

![](https://velog.velcdn.com/images/tjdtn4484/post/ade52e45-3291-4737-9d7d-d5983c3e2689/image.png)

~~...흠...좀 다르네..;; 여기까지만..~~


중요한건, 
* **@Controller**로 브라우저에서 원격 호출 가능한 프로그램 등록
* **@RequestMapping("URL")**으로 메서드와 URL을 Mapping한다.


---


# HTTP 요청과 응답

다음과 같은 클래스가 있다고 가정하자..

```
class YoilTeller {
	public static void main(String[] args) {
    	
        String year = args[0];
        String month = args[1];
        String day = args[2];
       	
        int yyyy = Integer.parseInt(year);
        int mm   = Integer.parseInt(month);
        int dd   = Integer.parseInt(day);
        
	
    	Calendar cal = Calender.getYear..? 
```
~~에라이 Calendar... 생각 안 난다...슨상님 Spring 깃헙에 있다..~~
~~이게 중요한 건 아니다만, 여하튼~~ 
이렇게 클래스를 하나 만들고, 컴파일해서 터미널에서

```
java com.~패키지~.YoilTeller 2022 10 04 
ㄴ>(엔터)
```
딱 하면, 
2022 10 04가 
main 메서드의 String[] args로 차례차례 들어가서,
args[0]엔 "2022" 가
args[1]엔 "10" 이
args[2]엔 "1" 이 들어간다.

그래서 위의 로직대로 처리된다.

그런데, 위의 내용을 클라이언트 브라우저에서 URL로 요청하려면 어떻게 해야될까??
위의 코드를 쪼금 바꿔보자.. (import는 무시)


~~@Controller // 원격프로그램 가능하도록 호출,~~
~~class Hello {~~
 ~~@RequestMapping("/hello")~~
 ~~public void main(HttpServletRequest request) {		// 매개변수로, HttpServletRequest 객체를 받아온다.~~
 	
   ~~int year  = request.getName("year");~~
   ~~int month = request.getName("month");~~
    ~~int day   = request.getName("day");~~

~~이 밑으로는 Calendar 처리 및 출력과 같다.~~
~~참고로 이 코드 틀리게 적은것이다.;;;~~

~~이렇게 하면,~~ 완성 후, URL에 
`~~~~~localhost:8080/ch2/hello?year=2022&month=10&day=4`
이런 식으로, URL로 서버에 요청하면 String[] args로 나오던 것과 유사한 방식으로 나온다. 콘솔창에 나온다...

근데, 코드가.. 다 틀렸었다...ㅠㅠ 
다시 써봐야겠다..
```
@Controller // 프로그램 호출 가능하도록 등록
class Hello {
 @RequestMapping("/hello2")
 public void main(HttpServletRequest request) {
 
  String year  = request.getParameter("year");  // getParameter...< 이 메서드를 기억지 못 했다...
  String month = request.getParameter("month"); 
  String day   = request.getParameter("day"); 	
  
  int yyyy = Integer.parseInt("year");
  int mm   = Integer.parseInt("month");
  int dd   = Integer.parseInt("day");

~~~ 밑에는 역시 Calender...
```
이게 맞다....

여튼, 터미널에서 java ~~~ 2022 10 4 이런식으로 들어갔었던 것이
브라우저에서 `~~~~~localhost:8080/ch2/hello?year=2022&month=10&day=4`  와 같이 써주면,
서버에 있는 Tomcat같은 WAS가 `HtttpServletRequest` 객체를 생성해서, 해당 URL에서, QueryString의 정보를 받아서,
메서드 내부로 값을 넘겨준다.

하지만 위의 코드는 콘솔로 나오게 해준다.

그래서 브라우저에 나오게 하려면, 
`HttpServletResponse` 또한 매개변수로 넣어줘야 한다.

그리고 코드 출력 부분을
```
PrintWriter out = response.getWriter(); // 맞나..? 몰겠다. 그리고 여기 getWriter메서드가 예외처리를 해줘야 하는 걸로 보였다..
out.println(year);
out.pinrlnt(month);
out.println(day);
```
이렇게 하면 브라우저로 출력된다.

여튼 여기서 중요하다고 생각되는 것은
* 터미널에서 정보를 받아와서 String[] args에 담아서 정보를 줬다면, 이번에는 QueryString으로 정보를 받아와서 `HttpServletRequest`객체가 메서드에 전달한다는 것.이다..
* 그리고, 브라우저에 출력을 하기 위해서는 HttpServletResponse(생각 안 남 순간..) 객체를 생성해서, 작업 결과를 출력스트림으로 브라우저에 나타내줘야한다.

main부분을 다시 써보자면, 
```
@Controller 
class Hello { 
	@RequestMappint("/hello")
    public void main(HttpServletRequest request, HttpServletResponse response) {
    ~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
response.setContentType("text/html");  	// text형식, html타입
response.setCharacterEncoding("utf-8");	// 인코딩형식(보통 utf-8
```
이런식으로 다시 해줘야한다..
~~눈으로 보기만 하면 역시 좀 부족하다... response관련된 메서드도, 쳐보니깐 좀 손에 익는다..~~

여튼 이 부분에서 중요한건,,,

* **HttpServletRequest**객체가 생성되서, 브라우저가 URL로 요청한 정보를 받아서 메서드로 넘겨주는 것이고,(마치 main(String[] args)처럼....)
* 요청받아서 처리한 결과를 브라우저에 출력하기 위해서는 **HttpServletResponse** 객체가 필요하다.
   * 브라우저에 출력하기 위해서는   response.setContentType("text/html") ~~'get'을 까먹음..~~
   * response.setCharactorEncoding("utf-8"); // 인코딩 정보를 같이 써주고,
   * PrinterWriter , getWriter로 출력스트림을 얻어서, 브라우저로 출력한다.!
   



---

이번 블로깅....쫌.. 길다..?
머릿 속으로 나온 글들이 이마이라니;;;;
흠.. 좀 괜찮은건가 모르갰다..

그리고, 아무리.. 눈으로 보고 이해해봤자, 써보지 않으면, 말짱 도루묵이다..

여튼 스프링의 정석 요약 계속 꾸준히 해야겠다!!
정말 다행인건, 이제야 스프링의 정석 강의가 귀에 들어온다는 것..
원래는 안 들어왔었다..ㅠ
후... 여튼 이제 잘 될일만 남았다..

> 나는 어치파 잘 될 사람이다..
   
