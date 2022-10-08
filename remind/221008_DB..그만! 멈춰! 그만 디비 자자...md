삽삭갱..정처기에서 데이터베이스 이상현상 외울 때, 외웠던 세글자.. 지금은 다 잊어버렸는데, 삽삭갱은 생각난다.
~~삽살개 생각이;;;~~

이번 블로깅에서 뭐 커스토머 아이디가 이렇니 저렇니, 혹은 커스토머 아이디가 이렇니 저렇니, 보다는 나중에 "그냥 이렇게 쓸 수 있구나", 혹은 "이런식으로 사용가능 했구나. 써봐야겠네~?"로 알고 있어야겠다.

아직 사실 쓰면서 의미를 생각하면서 나름 기록하지만, 뭐 나중에 크게 다가오기를 바라며, 일단 시작.

> 어차피 나는 잘 될 것이다. 지금도 잘 되고 있다.

이 위의 문장이 나중에 어떻게 바뀌게 될지는.... 내가 나에게 기대한다. ~~누가 읽을지 모르겠지만, 글을 읽는 분 또한..기대하시라.~~

---


# 데이터베이스 정규화

데이터베이스 정규화는 데이터베이스 설계와 연관되어있다. 
데이터베이스 설계가 결론적으로 데이터가 어떻게 저장될지 구조를 정해줌.

중요한 부분
* Data redundancy
* Data integrity
* Anomaly


### Data Redundancy
데이터 중복(data redundancy)은 실제 데이터의 동일한 복사본이나 부분적인 복사본을 뜻한다.
이런 중복성으로 데이터 복구시 수월할 수도 있지만, 데이터베이스 내에서는 몇가지 문제점들을 대체로 지닌다.
* 일관된 자료 처리의 어려움
* 저장 공간 낭비
* 데이터 효율성 감소

### Data Integrity
데이터 정규화는 이러한 데이터 무결성을 강화하기 위한 목적도 지닌다.
데이터 무결성(data integrity)은 데이터의 수명 주기 동안 정확성과 일관성을 유지하는 것을 뜻한다. 즉, 입력된 데이터가 오염되지 않고 입력된 그대로 데이터를 사용할 수 있다는 뜻이다.
 
### Anomaly
데이터 이상 현상(anomaly)와 같은 경우 데이터에서 기대한 것과 다른 이상 현상을 가리킨다.
* 갱신 이상 (update anomaly)
* 삽입 이상 (insertion anomaly)
* 삭제 이상 (deletion anomaly)

#### 갱신 이상(Update Anomaly)
갱신 이상(update anomaly)은 동일한 데이터가 여러 행(레코드)에 걸쳐 있을 때에 어느 데이터를 갱신해야 하는지에 대한 논리적 일관성이 없어 발생한다.

|Employee ID|Employee Address|Skill|
|-|-|-|
|519|94 Chestnut Street|Public Speaking|
|519|96 Walnut Avenue|Carpentry|

위와 같은 경우, 519번을 갱신할 때, 어떤 데이터를 해야 하는지에 대한 문제가 발생한다.

#### 삽입 이상(Insertion Anomaly)
삽입 이상(insertion anomaly)는 데이터 삽입을 못하는 경우를 가리킨다.

```
설명을 보면, 어떤 교수님들 테이블이 있는데, 새로운 교수님의 레코드를 못 추가하고 있다고 되어있다...
"수업을 NULL과 같은 값으로 지정해야 하지 않는 이상, 담당 수업이 있어야 추가될 수 있는 이상 현상이 발생한다"고 설명하는데, 
새로운 교수님의 레코드가 명시된 테이블의 컬럼 수보다 하나 적다. 
그 제외된 컬럼이 `Course Code`라고 하는데, NULL을 언급하는 거보면, 테이블의 과목코드가 아마 `NOT NULL`로 설정된 듯하다.
```

#### 삭제 이상(Deletion Anomaly)
삭제 이상(deletion Anomaly)과 같은 경우에는 데이터의 특정 부분을 지울 때에 의도치 않게 다른 부분들도 함께 지워지는 이상현상이다.

테이블에 구성된 요소와 관련된 데이터를 지우기 위해서 레코드 전체를 지우는데, 의도치 않게 다른 요소의 데이터도 같이 삭제되는 현상이 발생한다.



# SQL 종류
* SQL에는 데이터를 조회하고 테이블을 만드는 등 다양한 문법이 있다.
* 쿼리문을 어떻게 작성하느냐에 다라, 기능이나 작업이 달라진다. 
한국어, 영어 같은 언어에도 주어나, 동사 등을 구분하는 것처럼 SQL에서도 역할에 따라 문법이 다양하게 존재한다.

SQL 문법 분류
* Data Definition Language
* Data Manipulation Language
* Data Control Language
* Data Query Language
* Transaction Control Language

##### Data Definition Language(DDL)
DDL(Data Definition Lauguage)은 데이터를 정의할 때 사용하는 언어이다.
테이블을 만들 때 사용하는 `CREATE`이나 테이블을 제거할 때 사용되는 `DROP`등이 DDL에 해당한다.
데이터베이스의 테이블과 같은 오브젝트를 정의할 때 사용한다.


##### Data Manipulation Language(DML)
DML(Data Manipulation Language)은 데이터베이스에 대한 접근 권한과 관련된 문법이다.
어느 유저가 데이터베이스에 접근할 수 있는지 권한을 설정한다.
권한을 주는 `GRANT`나, 권한을 가져가는 `REVOKE`등이 DCL에 포함된다.

##### Data Query Language(DQL)
DQL(Data Query Language)은 정해진 스키마 내에서 쿼리할 수 있는 언어이다. `SELECT`가 DQL에 해당한다.
이렇게 언어를 분류했지만, DQL을 DML의 일부분으로 취급하기도 한다.

##### Tramsaction Control Language(TCL)
TCL(Transaction Control Language)은 DML을 거친 데이터의 변경사항을 수정할 수 있다. `COMMIN`처럼 DML이 작업한 내용을 데이터베이스에 커밋하거나, `ROLLBACK`처럼 커밋했던 내용을 다시 롤백하는 문법이 있다.



# SQL Advanced 
~~advanced 뜻이 고오오오급이란다..~~


##### CASE
SQL에서 프로그래밍 언어의 if문과 같은 기능을 사용가능한데 이가 CASE이다.
* CASE를 사용시, 특정 조건에 따라 다른 결과를 받을 수 있다.
```
SELECT CASE
	WHEN CustomerId <= 25 THEN 'GROUP 1'
	WHEN CustomerId <= 50 THEN 'GROUP 2'
	ELSE 'GRUOP 3'
       END
  FROM Customers
```
▲ CASE 예시
 
위의 쿼리문은 `CustomerId` 필드 값에 따라 3개의 그룹('GROUP 1','GROUP 2','GROUP 3')으로 나뉜다. `CustomerId` 필드값이 25이하인 경우에는 'GROUP 1'. 26부터 50 사이인 경우에는 'GROUP 2', 51이상은 'GROUP 3'으로 분류한다.


#### SUBQUERY
~~서브쿠어리~~

쿼리문 작성시 다른 쿼리문을 포함할 수 있다.
이 때, 포함되는 쿼리문을 SUBQUERY(서브쿼리)라고 한다.
서브쿼리는 실행되는 쿼리에 중첩으로 위치해, 정보를 전달한다.

서브쿼리는 **소괄호**로 감싸야 한다.
서브쿼리의 결과는 개별 값이나 레코드 리스트다.

그리고 서브쿼리의 결과를 하나의 칼럼으로 사용할 수 있다.
```
SELECT CustomerId, CustomerId = (SELECT CustomerId FROM customers WHERE CustomerId = 2)
FROM customers
WHERE CustomerId < 6
```
▲ 서브쿼리 사용 예시

##### IN, NOT IN
IN은 특정한 값이 서브쿼리에 있는지 확인할 수 있다. 
아래의 예시는 customers 테이블에서 'CustomerId'의 값이 서브쿼리에서 돌려받는 값에 속한 결과들만 조회한다.
```
SELECT *
FROM customers
WHERE CustomerId IN (SELECT CustomerId FROM customers WHERE CustomerId <10 )
```
▲ 서브쿼리와 IN 사용 예시
서브쿼리에서는 'CustomerId'가 10 이하인 데이터를 돌려주기 때문에, 최종 조회된 데이터 'CustomerId'도 10 이하다.

~~만야아아악!~~
`IN`대신 `NOT IN`을 사용한다면, 서브쿼리에서 조회된 10 미만을 제외한(10을 초과하는) 레코드를 조회한다.

##### EXISTS
`EXISTS` 또는 `NOT EXISTS`는 돌려받는 서브쿼리에 존재하는 레코드를 확인한다.
~~만야아아아악!~~
조회하려는 레코드가 존재한다면 참(TRUE~~: th루~~)을, 그렇지 않은 경우 거짓(FALSE~~: 풜쓰~~)을 리턴한다.
아래의 쿼리는 employees 테이블에서부터 'EmployeeId'필드를 조회한다.
이 때 서브 쿼리로 customers 테이블의 'SupportRepId' 필드값과 employees 테이블의 'EmployeeId' 필드값을 비교해 일치하는 레코드를 가져온다.
```
SELECT EmployeeID
FROM employees e
WHERE EXISTS (
       SELECT 1
       FROM customers c
       WHERE c.SupportRepId = e.EmployeeId
       )
ORDER BY EmployeeId
```
▲ 서브쿼리와 EXISTS 예시


##### FROM

FROM에도 서브쿼리를 사용가능하다.
쿼리문과 서브쿼리를 사용해서 조회된 결과를 하나의 테이블이나 조회할 대상으로 지정해 사용할 수 있다.
```
SELECT *
FROM (
       SELECT CustomerId
       FROM customers
       WHERE CustomerId < 10
       )
```
▲ FROM 내에 서브쿼리 사용 예시..
