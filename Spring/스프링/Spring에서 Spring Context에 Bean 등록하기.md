# 제곧내

* 스프링 레거시에서 XML로 Spring Context에 자바 Bean을 등록하는 방법
  1. 빈 태그를 사용해서 클래스이름을 지정하여 직접 Spring Context로 Bean을등록하거나,
  2. `@Component` 애너테이션이 붙은 클래스들을 **component-scan**으로 스캔해서 Spring Context에 Bean으로 등록.

* XML을 사용하지 않는 스프링 부트에서 Spring Context에 자바 Bean을 등록하는 방법.
  1. `@Bean` 애너테이션을 사용해서 Spring Context에 Bean을 등록하거나,
  2. 레거시와 마찬가지로, `@Component`애너테이션이 붙은 클래스들을 Bean으로 등록하거나 한다.


## @Bean과 @Componet의 차이점.
`@Bean` 같은 경우, 소스 코드를 보면, 아래 그림과 같이 메서드레벨에 지정할 수 있는 애너테이션이다. 
![빈](https://user-images.githubusercontent.com/85716720/202906802-cbff6885-26bd-4f9e-9e0b-6ef8a30b1689.PNG)

그러면, 메서드에서 반환하는 객체를 Spring Context에 **Bean**으로 등록한다.

반면 `@Component`가 붙은 객체 같은 경우, 컴포넌트 스캔을 할 때, 스캔 대상에서 `@Component`가 붙은 클래스를 Spring Context에 **Bean**으로  등록한다.
