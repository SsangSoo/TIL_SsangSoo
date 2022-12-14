# 의사코드
**작성시(중요!!!)**_~~(오로지 내 생각)~~_
1. 일단 **사람의 언어**로 로직을 쓴다.
2. 사람의 로직을 **컴퓨팅 사고**로 전환해서 의사코드 작성
~~(이때까지 그냥 1,2번 섞어가며 무작정 함..습관들이자...사소한 문제라도..)~~

**장점**
* 코드 구현 하다가 막히고, 막히고, 막히다보면, 초기화를 할 때가 있다.
그러면 새로 하게 되는데, 막혔던 **시간**이 있었다면, 그 **시간**이 허용지물..
* 디버깅 용이
**어디서** 막혔는지 논리적으로 **찾을 수 있음**..
* 협업에 유리
**프로그래밍 모르는 사람**도, **로직 이해**하는데 도움 됨.

# 시간 복잡도 ✪ ω ✪
코드를 작성 할 때, 보다 더 **효율적인 방법**으로 코드를 작성하는 것을 고려할 것 중 하나.
* "**입력값의 변화에 따라 연산 실행시, 연산 횟수에 비해 시간이 얼마나 걸리는가**"를 고려
* 입력값이 커져도 **시간을 최소화**한 알고리즘.

### 표기법
* 빅-오메가(최선)
* 빅-세타(평균)
* **빅-O 표기법(최악)** 
위 세 가지 중
주로 **빅-O 표기법**

**최악**임에도 주로 쓰는 이유
* 시간복잡도를 표현할 때 "**이 정도 시간까지 걸릴 수 있다"** 라는 의미로 사용되기 때문.
* 최선, 평균의 경우보단, **최악의 경우'까지'도** 고려하는 의미.


### 빅-O 표기법 종류
####  O(1) - constant complexity - 2차함수 y축이 항상 일정
* 입력값이 증가해도 시간이 늘어나지 않음.
* 입력값의 크기와 관계없이 출력값 즉시 얻어낼 수 있음.



#### O(n) -  linear complexity - 2차함수 기울기 일정(정비례)
* 입력값이 증가함에 따라 시간 또한 같은 비율로 증가하는 것
  *   ex) 입력값이 1에서 100배로 증가시 시간도 100배가 걸림.
  * 가령, n에 어떤 수를 더한다고해서 O(계수*n)가 되는 것이 아니라, 시간은 n의 크기에 따라 달라지기 때문에, 계수의 의미가 커지면 커질수록 무의미해짐.
 

#### O(log n) -  logarithmic complexity - 로그함수 그래프
* 경우의 수가 줄어드는 걸 예시로 생각하면 쉬우울 거 같음.
* 해당 시간복잡도를 가진 자료구조 : Binary Search Tree


####  O(n^2) -  quadratic complexity - 기하급수적으로 늘어나는 그래프
* 입력값이 증가함에 따라 시간이 n의 제곱수의 비율로 증가하는 것
  * 2n, 5n 을 모두 O(n)이라고 표현하는 것처럼, n^3과 n^5 도 모두 O(n^2)로 표기
  * n이 커지면 커질수록 지수가 주는 영향력이 점점 무의미해짐...


#### O(2^n) - exponential complexity - O(n&2)보다 더 기하급수적인 그래프
* Big-O 표기법 중 가장 느린 시간 복잡도

##### 데이터 크기에 따른 시간복잡도
* 데이터 크기제한	/	예상되는 시간 복잡도
* n <= 1,000,000		/	O(n) or O(logn)
* n <= 10,000         /	O(n2)
* n <= 500			/  	O(n3)	


---
# 탐욕 알고리즘(Greedy Algorithm)
> 선택의 순간마다 당장 눈앞에 보이는 최적의 상황만을 쫓아 최종적인 해답에 도달하는 방법

**탐욕 알고리즘으로 문제 해결시 단계**
1. 선택 절차(Selection Procedure): 현재 상태에서의 최적의 해답을 선택
2. 적절성 검사(Feasibility Check): 선택된 해가 문제의 조건을 만족하는지 검사
3. 해답 검사(Solution Check): 원래의 문제가 해결되었는지 검사하고, 해결되지 않았다면 선택 절차로 돌아가 위의 과정을 반복

_실생활 예시)_
* 거스름돈 동전 최소화
* 배낭 짐싸기

결국, 매 순간, **최적**이라 생각되는 해답(locally optimal solution)을 **찾으며**, 이를 토대로 **최종 문제의 해답**(globally optimal solution)에 **도달**하는 문제 해결 방식


- 탐욕 알고리즘을 적용하려면, 해결하려는 문제가 다음의 2가지 조건을 성립하여야 함.
  - 탐욕적 선택 속성(Greedy Choice Property) : 앞의 선택이 이후의 선택에 영향을 주지 않아야 함.
  - 최적 부분 구조(Optimal Substructure) : '문제에 대한 최종 해결 방법'은 '부분 문제에 대한 최적 문제 해결 방법'으로 구성됨.

탐욕 알고리즘은 항상 최적의 결과를 도출하는 것은 아니지만, 어느 정도 최적에 근사한 값을 빠르게 도출할 수 있다. 이로 인해 인해 탐욕 알고리즘은 근사 알고리즘으로 사용 가능하다.

