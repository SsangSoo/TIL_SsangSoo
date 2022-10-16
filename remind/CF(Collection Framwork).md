조금 늦었다..
9월 13~14일 추석 연휴 직후부터 이틀간, 코드스테이츠에서 Collection Framwork를 학습하는 날이었다.
(물론 애너테이션, 열거형등 다른 부분도 했다..)

그래도 메인요리는 CF, ~~광고 아니..~~ 컬렉션 프레임워크였다.~~(퀄렉션 후레임워크)~~


여튼 삽질을 맘껏 해보기로 한 나는, 이전까지는 그냥 코드를 슥보고 로직만 보고, 음~ 하고 넘어갔지만, 이번엔 그냥 하나하나 다 쳐봤다...(자바의 정석 공부하면서, 사실 CF는 뭔가 두려웠다... 어려웠거든..ㅠ)
근데 역시 막상 해보니 별건 없었다...

그리 어려운 이터레이터도 쓰는데, 막상 써보려고 해보니 쉬웠고, 머리로 이해한 건 데이터를 순차적으로 읽어가면서 사용할 수 있나보다 했는데.. 머리론 어려워서 두려워했지만, 막상 써보니 그냥 음... ㄹㅇ 식은 죽 먹기였다... 별로 내키진 않지만, 쉬운 일이었다고나 할까..

그리고 내가 어제 코드스테이츠에서 문제를 푸는데, 
매개변수로 받아온 ArrayList에서 마지막 요소를 제거한 결과만, 남기고 새로운 ArrayList를 반환하는 문제를 주었다.
그냥 마지막 요소제거 하고, 새로운 리스트로 넘겨주면 되었겠지만..

```
(예를 들어,  
매개변수로 받아온 list가 있으면.
```
```
	list.remove(list.size()-1);

	Arraylist<String> arraylist = list;
 
  	return arraylist   
 ```
```
이런식으로..
```


근데 나는 자바의정석 3판을 보면서 문제를 풀어갔는데,

유독 subList가 쓰고 싶었다. 그래서 처음부터 마지막 요소의 앞까지만 arrayList에 저장하는 형식으로 해서 return을 해보고 싶었다.

근데 
```
List<String> list = new ArrayList<>():

```
이렇게 해서 
```
list = list.subList(0, arrayList.size()-1);

return list;
```
근데 안된다?

ClassCatingExcetion이 발생했다..

왜 안되는지 몰랐었다..(근데 이제 알았다..)

subList는 List를 반환한다..
근데 형변환은 자손타입에서 조상타입으로 가능하고, 그 형변환된 조상타입에서 다시 자손타입으로도 역시 형변환 가능하다(본래의 타입으로 되돌아오기 때문에..)


근데 subList는 그냥 List를 반환하고, 

```
List<String> list = new ArrayList<>();
```
로 선언하긴 했지만, 참조변수의 타입이 List기 때문에, 결국 List타입이고, ArrayList로 선언했지만, 
```
list = arrayList.subList(0, arrayList.size()-1);
```
로 하면, 결과적으로 
```
List<String> list = new ArrayList<>();
```
이렇게 선언한 내용이
```
List<String> list = arrayList.subList(0, arrayList.size()-1);
```
로 결국 나는 List타입의 list를 받은것이다.
그러니 return 할때,
```
return (ArrayList)list;
```
이런 식으로 해줘도 당연히 ClassCastingException이 발생할 수 밖에...
이렇게 또 객체지향에 한발 다가간다.

그리고
CF의 소스코드들을 뜯어보면서 문제를 푸는데, 흠... 삽질을 해야한다는 강박이 생겨서, 좀 귀찮긴 했지만, 소스코드 뜯어보면서 막 이것저것 해보니.. 얻는 것은 ㄹㅇ 많았다.

페어 프로그래밍 하면서, 페어가 궁금했던 부분들도 함께 소스코드 보면서, 코드로 구현해봤는데, 얻는 건 ㄹㅇ 많았다... 여튼 어제 나는 성장했다.

마지막
```
List list = new ArrayList();
``` 
이렇게 하면 이런식이다.

![](https://velog.velcdn.com/images/tjdtn4484/post/ddca429b-c7c5-4f36-aa46-0a557bc3de3b/image.png)

그런데
``` 
list = arrayList.subList(0, arrayList.size()-1);
```
이렇게 되면,
![](https://velog.velcdn.com/images/tjdtn4484/post/4c82b068-c963-40f0-80d5-f6de34842637/image.png)

~~그림이 개판인데...~~

이런식으로 new ArrayList() 연결이 끊어지고, 
0x200을 참조해서, arrayList의 subList 메서드로 만들어진, 0x200을 참조하게 된다.
(메모리주소는 예를 든것이다..)

여튼 나는 오늘도 발전했다.
여전히 발전중이다.

>난 어차피 잘될 놈이다.
