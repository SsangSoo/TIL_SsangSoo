```
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Problem03 {
    public static void browserStack(String[] actions, String start) {
        Stack<String> prevStack = new Stack<>();    // 뒤로가기를 눌렀을 때, 쌓이는 스택
        Stack<String> nextStack = new Stack<>();    // 앞으로가기를 눌렀을 떄, 쌓이는 스택
        Stack<String> current = new Stack<>();      // 현재페이지 하나만 들어감.
     

        // TODO:

        current.push(start);    // 시작페이지.

        for(String str : actions) {   //
            if(str.equals("<<")) {              // 뒤로가기 클릭시.
                if((!prevStack.isEmpty()))   {    // prevStack에 요소가 있으면,
                    nextStack.push(current.pop());  // nextStack에 current의 요소를 빼서 넣고,
                    current.push(prevStack.pop());  // prevStack에서 마지막요소를 current로 넣음.
                }
            } else if(str.equals(">>")) {        // 앞으로 가기 클릭시
                if(!nextStack.isEmpty()) {      // nextStack에 요소가 있으면,
                    prevStack.push(current.pop());  // prevStack에 current의 요소를 빼서 넣고,
                    current.push(nextStack.pop());  // current에 nextStack의 마지막 요소를 빼서 넣음.
                }
            } else if(!(str.equals("<<") || str.equals(">>"))) {   // 새로운 페이지 접속,(앞뒤로가기가 아니라면)
                if(!str.equals(current.peek())) {       // 현재 페이지와 다른 페이지라면,
                    prevStack.push(current.pop());      // 현재페이지의 요소를 prevStack에 넣고,
                    current.push(str);                  // current에 str을 넣음.
                    nextStack.clear();                  // 새로운 페이지가 들어오면, nextStack 비움.
                }
            }
        } // 향상된 for문 끝

    }
}
```
actions의 요소는 페이지가 들어갈 것이고, 페이지 외엔, "<<"(뒤로 가기) , ">>"(앞으로 가기) 이렇게 배열 요소를 가진다.
각 인덱스는 '새로운 페이지 클릭', '뒤로가기 클릭', '앞으로 가기 클릭' 이 세가지 행동을 순차적으로 진행했다고 생각하면 된다.

코드스테이츠 연습문제를 저작권 문제 때문에, 약간은 변형해서 올렸다. Stack 구현은 괜찮은데, 문제 요구사항에 맞게 구현하려니... 요구사항 이해하는데 시간 많이 걸렸다...

자기 전 1시간동안 구현 해보려고 한건데, 12시 가까이에 너무 잠와서 자다 일어나서 했는데.. 풀렸다..
역시 사람은 자야된다...

머리가 젤 잘 돌 때... 걸을 때, 샤워할 때, 화장실에서 DDong 배출할 때, 자고 일어났을 때,,
요즘 잘 때도, 일어나기 직전에... 코딩생각하면서 기상한다...

역시.. 나는 개발자로
> 어차피 잘 될 놈이다.
