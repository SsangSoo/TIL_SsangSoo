Controller 클래스에서 HTTP메서드마다 **RequstEntity**로 값을 리턴하게 되는데, 전체 목록을 표시해줄 때, Page형식으로 보여주기 위한 코드를 구현해봤다..

Spring에 PageNation을 위한 API가 있다곤 하지만, 그냥 JSON의 데이터 형식을 파악하고, 그냥 이렇게 하면 되겠다 싶어서 구현해봤다..

> 이로써 내가 얻은 것!
> 1. RequestEntity로 반환하면 알아서 JSON형식으로 주는 것! 이라기보다는 저 문장이 좀 더 와 닿게 되었다는 것.
> 2. 그리고 만약 페이지정보와 List형식의 객체를 함께 주어야 한다면, 하나의 객체로 묶어서 주어야 한다는 것.
> 3. 그리고.. 약간의 알고리즘 비스무리한 거 연습...;;;

여튼...결과대로 나오니 기분 좋다..

아래는 내가 생각해서 구현한 코드
저작권 없다... 왜냐하면 내 생각에서 나온 코드라서 저작권 침해의 위반을 받을 필요가 쩌얼~때! 없다.!

```java
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PageInfo {
    private int page;
    private int size;
    private final int totalElements = 20;	// 원래 20개가 있어서 그냥 하드코딩함.
    private int totalPages;
}
```


```java
// 서비스 계층의 엔티티 클래스의 메서드이다.

public List<Member> findMembers() {
        // TODO 페이지네이션을 적용하세요!
        List<Member> memberList = new ArrayList<>();

        List<Member> list = (List<Member>) memberRepository.findAll();
        // list에 있는 걸 최신 순서로 넣기.
        for(int i=list.size()-1; i >= 0; i--) {
            memberList.add(list.remove(i));
        }
        return memberList;
    }
```

```java
@GetMapping
    public ResponseEntity getMembers(@RequestParam("page")int page,
                                     @RequestParam("size")int size) {
        // TODO 페이지네이션을 적용하세요!
        List<Member> members = memberService.findMembers();
        List<MemberResponseDto> response = mapper.membersToMemberResponseDtos(members);

        // pageInfo 정보 담기
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPage(page);
        pageInfo.setSize(size);
        pageInfo.setTotalPages( (pageInfo.getTotalElements()/size)
                + (pageInfo.getTotalElements()%size > 0 ? 1 :0 )
        );	// 총 페이지 size를 어떻게 지정하냐에 따라 달라짐.
        
        

        int startIndex = (page-1) * size;		// 지정한 페이지의 보여줄 Member들 시작 인덱스
        int endIndex = startIndex + (size-1);	// 지정한 페이지에서 보여줄 Member들 끝 인덱스

        List<MemberResponseDto> tmpList = new ArrayList<>(); // responseEntity로 담을 List.. 

		// tmpList에 페이지 만큼 담기.
        for(int i=startIndex; i<=endIndex; i++) {
            tmp.add(response.get(i));
        }


		// tmp, pageInfo 객체를 묶기 위해서 "List.of(tmp, pageInfo)"를 사용.
        return new ResponseEntity<>(List.of(tmp, pageInfo), HttpStatus.OK);
    }
```

유효하지 않은 건 어떻게 해야될지 생각은 안 해봤다만,, 아마 500번 버스나, 404번 버스를 타야되지 않을까..?

코드가 더럽긴하나,,그냥 결과대로는 나온다는 것에 일단 의의를 둬본다..

> 나는 어차피 잘 될 놈이다.




