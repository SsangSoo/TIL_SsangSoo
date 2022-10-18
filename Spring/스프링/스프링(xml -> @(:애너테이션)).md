
# **@Bean**
  * 레거시에서 XML에서 `<bean/>`태그로 **Bean**이 **ApplicatioinContext** 즉, **Spring Container**에 등록되었다면, <br> 부트에서는 `@Bean` 애너테이션으로 **Spring Container**에 등록된다.


```
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})	// @Bean의 타겟은 참고로 메서드타입에 붙일 수 있다. 
@Retention(RetentionPolicy.RUNTIME)					
@Documented
public @interface Bean {
``` 
@Bean 애너테이션의 소스코드이다.
혹여 아래와 같은 메서드가 있다면,
```
    @Bean
    public Calculation CalcService() {
        return new Calculation();
    }
```
**xml**에서는 아래와 같은 방식으로 정의 가능하다
```
<beans>
    <bean id="CalcService" class="패키지경로.Calculation"/>
</beans>
```

**xml**에서 클래스를 Bean으로 등록하려면 아래와 같이 했었다.

```
<beans>
    <bean id="calculation " class="패키지 경로.Calculation"/>
</beans>
```

위와 같이 `id`는 **클래스의 첫글자를 소문자**로, `class`는 **패키지경로를 포함한 클래스**를 사용해서 **Bean**으로 등록했다..



# **@Configuration**
  * 해당 애너테이션을 클래스작성시 앞에 붙여주면, 해당 클래스 안의 **@Bean**이 붙은 메서드를 모두 호출해서 반환된 객체를 **스프링 컨테이너**에 등록한다.
  * **XML**파일에서 `<bean/>`태그로 등록되어서 **Bean**이 정의 되는 것처럼, **@Configuration**이 클래스에 붙으면, 클래스 안에 **@Bean** 애너테이션이 붙어서 반환 되는 객체들이 **Spring Container**에 의해서 관리된다.
    * **관리 : 생성, 소멸, 연결.**

 * 빈 정의가 들어있는 인터페이스를 구현한 클래스를 **@configruation**으로 설정할 수도 있다.
```
public interface Config {

    @Bean
    TransferServiceImpl transferService() {
        return new TransferServiceImpl();
    }
}

@Configuration
public class DependencyConfig implements Config {

}
```
위와 같이 인터페이스 안에 **@Bean**이 등록되어 있는데, 그 인터페이스를 구현한 클래스 앞에 **@Configuration**을 붙임으로써, **@Bean**이 있는 인터페이스를 구현한 클래스를 스프링 컨테이너가 **Bean**을 참조할 수 있도록 할 수 있다.


### **@Import(타입)** 
```
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Import {
```
위와 같이 소스 코드가 정의 되어있다.

아래의 코드를 예를 들면,
```
@Configuration
public class ConfigA {

    @Bean
    public A a() {
        return new A();
    }
}

@Configuration
@Import(ConfigA.class)
public class ConfigB {

    @Bean
    public B b() {
        return new B();
    }
}
```
**Spring Container**에 `A메서드`와 `B메서드`를 통해서 `@Bean`으로 등록할 때,  **Spring Container**에 매개변수로 `ConfigA.class`, `ConfigB.class`를 줄 필요 없이, `ConfigB` 클래스에 `ConfigA`클래스가 Imoort 되어있으므로, `ConfigB`클래스만 넘겨주면, `ConfigA`,`ConfigB`클래스를 모두 넘겨준 것과 같고, `ConfigB`만 매개변수로 넘겨주면, `@Bean`으로 등록된 `A`클래스와 `B`클래스를 모두 `Bean`으로 등록가능하다.


# **@ComponentScan**
* xml에서 `<context:component-scan base-package="패키지경로"/>``태그와 똑같은 역할을 한다.
* @Configuration`애너테이션이 붙은 클래스 앞에 `@ComponentScan` 애너테이션을 붙이면, 해당 클래스 안의 `@Component`가 붙은 클래스를 **Bean**으로 등록한다.

---

### 정리
* **@Configration** : xml파일
* **@ComponentScan** : xml에서 `<context:component-scan base-package="패키지경로"/>``태그와 똑같은 역할
* **@Bean** : xml 안에서 `<Bean/>`태그로 Bean정의한 것과 같은 기능.

* 참고 해봐야 되는 것 : Componenet Scane 기본대상

