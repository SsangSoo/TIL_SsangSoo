package Default_Algorithm;

public class prac001_01 {
    static int max4(int a, int b, int c, int d) {   // 최댓값 구하기
        int max = a;
        if(b > max)
            max = b;
        if(c > max)
            max = c;
        if(d > max)
            max = d;
        return max;
    }
    
    static int min3(int a, int b, int c) {          // 최솟값 구하기
        int min = a;
        if(b < min) 
            min = b;
        if(c < min) 
            min = c;
        
        return min;
    }
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
