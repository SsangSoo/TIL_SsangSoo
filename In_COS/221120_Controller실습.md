

# Controller 실습

`@PostConstruct` 로 인해서 
Map형식으로 데이터가 저장되었을 때,

1. 멤버의 핸드폰넘버를 수정하고, 삭제.
2. 커피의 한글이름, 가격을 수정하고, 삭제.


이 두 가지 작업을 수행하는 메서드를 컨트롤러에 작성한 것들.

`내 생각에서 나온 코드들이라 저작권 딱히 없음.`


```java
   @PatchMapping("/{member-id}")
    public ResponseEntity updateMember(@PathVariable("member-id") long memberId,
                                       @RequestParam("phone") String phone) {

       members.get(memberId).put("phone",(Object)phone);

        return new ResponseEntity(members,HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id")long memberId) {
        members.remove(memberId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
```

```java
    @PatchMapping("/{coffee-id}")
    public ResponseEntity updateCoffee(@PathVariable("coffee-id")long coffeeId,
                                        @RequestParam("korName") String korName,
                                        @RequestParam("price")int price) {

        coffees.get(coffeeId).put("korName", korName);
        coffees.get(coffeeId).put("price",(Object)price);

        return new ResponseEntity(coffees, HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId) {

        coffees.remove(coffeeId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
```

