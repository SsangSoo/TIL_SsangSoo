
Transaction.(th랜줵션)_액시드.

이 트랜잭션에 대해서는 아마도 스프링의 정석을 참고해서 한 번 더 포스팅할 것 같다.


# Transaction
~~한글로 적었었는데, 영... 파이다..(갱상도 사투리에서 뭔가 부정적인 늬앙스를 가진 말)~~
> 여러 개의 작업을 하나로 묶은 실행 유닛.

각 트랜잭션은 하나의 특정 작업으로 시작해서 묶여진 작업들을 다 완료해야 정상적으로 종료된다.

한 트랜잭션에 속한 여러 작업 중 하나라도 실패하면, 해당 트랜잭션에 속한 모든 작업을 실패한 것으로 간주
~~(원자성의 설명이 매우 강하다...)~~

즉, 작업이 하나라도 실패하면, 트랜잭션도 실패, 모든 작업이 성공하면 트랜잭션 또한 성공한 것.

성공 또는 실패라는 두 개의 결과만 존재하는 트랜잭션은 미완료된 작업 없이 모든 작업을 성공해야한다.



## ACID
> ACID는 데이터베이스 내에서 일어나는 하나의 트랜잭션(transaction)의 안전성을 보장하기 위해 필요한 성질.

* Atomicity
* Consistency
* Isolation
* Durability

~~정처기 생각난다...사실 원자성 밖에 그때는 이해하지 못했다..~~


## Atomicity(원자성)~~(아토미서티?)~~
* 하나의 트랜잭션에 속해있는 모든 작업이 전부 성공 or 전부 실패해서 결과를 예측할 수 있어야한다.("모 아니면 도"라는 말이 생각난다...) 
  * 실생활에서 예를 들어 은행에서 계좌이체를 한다 가정.. 
1. A에서 출금, 
2. B로 입금

1번은 성공했다. 그런데 2번은 실패했다..~~(실제로 Deep빡일듯 한데...)~~이런 경우, 원래대로 다시 1번, A에서 출금하기 전 상태로 돌아가는 성질이 원자성이다. 계좌이체라는 하나의 트랜잭션이 성공하기 위해서는, 1,2 두 작업 모두 성공해야한다.

## Consistency(일관성)
* 데이터베이스의 상태가 일관적이어야 한다는 성질.
* 하나의 트랜잭션 이전과 이후, 데이터베이스의 상태는 이전과 같이 유효해야 한다.

`어떤 하나의 트랜잭션이 실행되었을 때, 데이터의 값들이 일관되어야 한다는 의미가 아니라!`
`트랜잭션 이후, 해당 트랜잭션 이전과 이후에 데이터베이스의 제약이나 규칙을 만족해야 한다는 뜻.`

예를 들어서, "모든 고객은 반드시 이름을 가지고 있어야 한다"는 제약이 있다고 가정했을 때,
  * 이름 없는 고객이 추가되거나, 
  * 기존 고객의 이름을 삭제하게 되면, 
제약을 만족하지 못하므로, 이를 "일관성을 위반"했다라고 표현한다.



### Isolation(격리성, 고립성) ~~(A Kingdom of isolation and I look like i'm the queen..in FROZEN)~~
* 격리성은 모든 트랜잭션은 다른 트랜잭션으로부터 독립되어야 한다.

Isolation에도 Isolation level이 있다. 나중에 스정듣고, 이 부분은 포스팅 할 것 같다.
~~(코스에선 커리큘럼 상 없다고 함.)~~
* 동시에 트랜잭션을 실행 시켜도, 트랜잭션이 같이 진행되는 것이 아니라, 만약 두개의 트랜잭션을 같이 진행 시킨다면, 하나의 트랜잭션이 끝나야, 다른 하나의 트랜잭션이 진행된다.

예를 들면 하나의 계좌에 1만원이 있다고 가정했을때, 다른 두개의 계좌 B, C에 각각 6천원씩 송금한다고 가정했을 때, 마이너스 되는 것이 아니라, B 작업이 완료되고, C가 진행된다. 

그러니깐, 각 트랜잭션은 독립적으로 실행된다는 의미..
~~말로 풀기 어렵네..~~

## Durability(지속성)

* 하나의 트랜잭션이 성공적으로 수행되었다면, 해당 트랜잭션에 대한 로그가 남아야 한다.
* 런타임 오류 혹은 시스템 오류가 발생하더라도, 해당기록은 영구적이어야 함.

간략하게..내가 이해한 것이 맞다면,
트랜잭션이 성공하면, 그 기록이 남아야한다는 것 같다..


