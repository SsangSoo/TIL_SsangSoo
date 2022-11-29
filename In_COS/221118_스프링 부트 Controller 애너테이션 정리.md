# 애너테이션 정리

#### @SpringBootApplication
`@SpringBootApplication` 은 코드 상에서는 보이지 않지만 내부적으로 세가지 일을 해준다.

* 자동 구성을 활성화.
* 애플리케이션 패키지 내에서 `@Component`애너테이션이 붙은 클래스를 검색한 후(scan), Spring Bean으로 등록한다.
* `@Configuration` 이 붙은 클래스를 자동으로 찾아주고, 추가적으로 Spring Bean을 등록해준다.

#### @RestController
* Spring MVC에서는 특정 클래스에 `@RestController` 애너테이션을 추가하면 해당 클래스가 REST API의 리소스를 처리하기 위한 API 엔드포인트로 동작함을 정의한다.
* @RestController 가 추가된 클래스는 애플리케이션 로딩 시, Spring Bean으로 등록한다.


#### @RequestMapping
* 클라이언트의 요청과 클라이언트 요청을 처리하는 핸들러 메서드(Handler Method)를 매핑해주는 역할을 한다.

> **핸들러 메서드(Handler Method)**
> 클라이언트의 요청을 처리하는 메서드를 의미한다.


## Controller클래스 내의 메서드에서 인자로 사용가능한 애너테이션

#### @PostMapping
* 클라이언트의 요청 데이터(request body)를 서버에 생성할 때 사용하는 애너테이션

#### @GetMapping
* 클라이언트가 서버에 리소스를 조회할 때 사용하는 애너테이션

#### @PathVariable
* 핸들러 메서드의 파라미터 종류 중 하나이다.
* `@PathVariable`의 괄호 안에 입력한 문자열 값은 `@GetMapping("/{member-id}") `처럼 중괄호({ }) 안의 문자열과 동일해야 한다.

#### @PutMapping
* HTTP Put Method에 해당하는 단축 표현으로 서버의 리소스를 수정할 때 사용. 리소스의 모든 정보를 수정할 때 사용한다.

#### @PatchMapping
* HTTP Put Method에 해당하는 단축 표현으로 서버의 리소스를 수정할 때 사용. 리소스의 일부 정보만 수정할 때 사용한다.

#### @DeleteMapping
* HTTP Delete Method에 해당하는 단축 표현으로 서버의 리소스를 삭제할 때 사용.

#### @RequestParam
* 쿼리 파라미터, form-data 등의 Servlet request Parameter를 바인딩 해야 할 경우 사용

#### @RequestHeader
* request header를 바인딩해서 header의 key/value에 접근할 수 있다.

#### @RequestBody
* request body를 읽어서 지정한 Java 객체로 deserialization 해준다.
  * deserialization = 역직렬화 / JSON에서 JAVA로

#### @RequestPart
* 'multipart/form-data' 형식의 request 데이터를 part 별로 바인딩할 수 있도록 해준다.

#### @MatrixVariable
* URL 경로 세그먼트 부분에 key/value 쌍으로 된 데이터에 바인딩할 수 있도록 해준다.

