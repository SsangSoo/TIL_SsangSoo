package Default_Algorithm;

public class prac001_05 {
    static int med3(int a, int b, int c) {
        if((b >= a && c <= a) || (b <= a && c >=a))
            return a;
        else if((a > b && c < b) || (a < b && c > b))
            return b;
        return c;
    }
}
// 중앙값을 메서드는 다음과 같이 작성할 수도 있습니다. 그러나 실습1C-1(Train001C_01)의 med3 메서드에 비해 효율이 떨어지는데 그 이유를 설명하세요.
// >> 명확한 답이 떠오르지 않는다.
