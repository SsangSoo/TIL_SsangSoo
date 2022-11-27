# DelegatingPasswordEncoder
* Spring Securtity에서 지원하는 PasswordEncoder 구현객체를 생성해주는 컴포넌트.
* DelegatingPasswordEncoder를 통해서 애플리케이션에서 사용할 PasswordEncoder를 결정하고, 결정된 PasswordEncoder로 사용자가 입력한 패스워드를 단방향으로 암호화해준다.


## DelegatingPasswordEncoder의 장점
* 다양한 방식의 암호화 알고리즘을 적용할 수 있는데, 굳이 지정하지 않으면, Spring Securtity에서 권장하는 최신 암호화 알고리즘을 사용하여 패스워드를 암호화할 수 있도록 해준다.
* 패스워드 검증에 있어서 레거시 방식의 암호화 알고리즘으로 암호화 된 패스워드의 검증을 지원한다.
* Delegating이라는 표현처럼 암호화 방식을 언제든지 변경할 수 있다.
  * 단 이 경우, 기존에 암호화되어 저장된 패스워드에 대한 마이그레이션 작업이 진행되어야 한다.

## DelegatingPasswordEncoder로 PasswordEncoder 생성
```java
// PasswordEncoderFactories로 만들 수 있다.

PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
```
 
`PasswordEncoderFactories.createDelegatingPasswordEncoder()` 코드로 DelegatingPasswordEncoder의 객체를 생성하고, 내부적으로 DelegatingPasswordEncoder가 다시 적절한 PasswordEncoder객체를 생성한다.



## 암호화 기술
1. Plain Text 저장
  * 말 그대로 암호화 되지 않은 텍스트 그 자체를 의미
2. 해시(Hash) 알고리즘
  * 단방향 암호화를 위한 핵심 알고리즘.
  * 한번 암호화되면 복호화 되기 어려운 특성이 있다.
3. MD5
  * MD2, MD4 해시 알고리즘의 결함을 보완한 알고리즘.
  * 단방향 알고리즘임에도 불구하고, 복호화가 된 사례가 종종 발견된다.
  * **다이제스트(Digest)**
    * 원본 메시지를 암호화한 메시지를 의미하는데 암호화 기술에 굉장히 자주 사용되는 용어.

4. SHA(Secure Hash Algorithm)
  * MD5의 결함을 보완하기 위해서 나온 대표적인 해시 알고리즘.
  * 해시된 문자열을 만들어내기 위해 비트 회전 연산이 추가된 방식이다.
  * 즉, 해시된 문자열의 비트 값을 회전하면서 반복적으로 해시처리를 한다.
    * 해시처리한 결과 값을 또 해시로 돌리고, 또 돌리는 방식. (키 스트레칭)
   
