package Default_Algorithm;

public class prac001_03 {
    static int min4(int a, int b, int c, int d) {   // 최솟값 구하기
        int min = a;
        if(b < min)
            min = b;
        if(c < min)
            min = c;
        if(d < min)
            min = d;

        return min;
    }

}
