package Default_Algorithm;

public class Train001_02 {
    static int max3(int a, int b, int c) {  // 최댓값 구하기
        int max = a;
        if(b > max)
            max = b;
        if(c > max)
            max = c;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(Train001_02.max3(3,2,1));
        System.out.println(Train001_02.max3(3,2,2));
        System.out.println(Train001_02.max3(3,1,2));
        System.out.println(Train001_02.max3(2,1,3));
        System.out.println(Train001_02.max3(3,3,2));
        System.out.println(Train001_02.max3(2,2,3));
        System.out.println(Train001_02.max3(2,3,1));
        System.out.println(Train001_02.max3(2,3,2));
        System.out.println(Train001_02.max3(1,3,2));
        System.out.println(Train001_02.max3(2,3,3));
        System.out.println(Train001_02.max3(1,2,3));
    }
}
