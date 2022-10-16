package Default_Algorithm;

public class prac001_02 {
    static int min3(int a, int b, int c) {          // 최솟값 구하기
        int min = a;
        if (b < min)
            min = b;
        if (c < min)
            min = c;

        return min;
    }
}
