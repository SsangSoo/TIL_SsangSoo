package Default_Algorithm;

import java.util.Scanner;

public class Train001_05 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요.: ");
        int n = stdIn.nextInt();

        if(n == 1)
            System.out.println("A");
        else if (n == 2)
            System.out.println("B");
        else if (n == 3)
            System.out.println("C");
    }
}
