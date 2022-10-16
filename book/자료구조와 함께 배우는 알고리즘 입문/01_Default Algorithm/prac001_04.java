package Default_Algorithm;

public class prac001_04 {
    // 세 값의 대소 관계인 13가지 조합의 중앙값을 구하여 출력하는 프로그램을 작성하세요.
    static int med4(int a, int b, int c) {
        if(a >= b) {
            if (b >= c)         //    c <= b <= a
                return b;
            else if (a <= c)    //    b <= a <= c
                return a;
            else
                return c;
//        } else if(b >= c)
//            if(a <= c)               //    a <= c <= b
//                return c;
//            else if(b <= a)          //    c <= b <= a
//                return b;
//            else
//                return a;

//            위에 내용은 틀림..
//            다시 풀어보기.. a >= b 의 조건이 성립하지 않았다면, a < b 의 조건인 채로 else if문으로 문장흐름이 바뀐다.
//             a < b의 조건이 있기때문에, 이 조건을 토대로 조건을 생각하면서 코딩하면됨.
        } else if(c < a)  // c < a < b
            return a;
          else if(b < c)       // a < b < c
            return b;
          else
            return c;
        }
}
