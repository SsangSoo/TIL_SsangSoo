> ⚡ 생각대로 살지 않으면 사는대로 생각한다.
> ⚡ 나는 어차피 잘 될 놈이다. 이미 잘 되고 있고, 계속해서 잘 되고 있다.

---

```
SecretKey를 시스템 환경 변수에 등록한 변수를 사용할 때는 applicatioin.yml 파일의 프로퍼티명과 동일한 문자열을 사용하지 않도록 주의해야한다!

시스템 환경 변수와 application.yml에 정의한 프로퍼티명의 문자열이 동일한 경우 application.yml 파일에 정의된 프로퍼티를 클래스의 필드에서 참조할 때(예: ${jwt.key.secret}) yml에 정의해둔 값이 채워지는 것이 아니라, 시스템 환경 변수의 값으로 채워지므로 개발자가 의도하지 않은 값으로 채워질 수 있다.

따라서 가급적 시스템 환경 변수의 값도 application.yml에서 먼저 로드한 뒤에 application.yml에서 일관성 있게 프로퍼티 값을 읽어오는 것이 좋다.

시스템 환경 변수에 정의한 변수명과 application.yml에 정의한 프로퍼티명의 이름을 각각 다르게 추가하면 디버깅 시, application.yml에서 값을 로드하는지 시스템 환경 변수에서 값을 로드하는지 직관적으로 알 수 있다.
```

위에 글에서 존댓말을 반말로 쓴 것과 한 문장 추가한 거 외엔 그냥 컨텐츠 copy한거다.
여튼 그렇다..


근데 저게 무슨 말이냐..
예를 들어서 시스템 환경변수의 이름으로 `JWT_SECRET_KEY`라는 이름으로 설정하고,
yml에도 프로퍼티 명을 `JWT_SECRET_KEY`라는 이름으로 설정했다고 가정해보자...?

> 프로퍼티는 Map형태의 <String,String> 이다. 여튼..

* 시스템 환경변수의 `JWT_SECRET_KEY`  예시
`JWT_SECRET_KEY` = **ssangsoo123412341234**

* yml 파일의 `JWT_SECRET_KEY` 예시
`JWT_SECRET_KEY` = **ssangsoo432143214321**


이렇게 두개의 `JWT_SECRET_KEY` 키가 있다고 가정했을 때

java에서는 
```java
*.getSecretKey("${JWT_SECRET_KEY}");
```

이렇게 사용할 것이다.

그러면, 개발자는 yml 파일에 있는 `JWT_SECRET_KEY`에 대한 값인  **ssangsoo432143214321**를 원했지만, yml이 아닌 시스템 환경변수에 정의되어 있는 `JWT_SECRET_KEY`의 값인 **ssangsoo123412341234**을 불러온다는 의미이다.

그래서 다르게 하란 것!!!

---
-끝-


