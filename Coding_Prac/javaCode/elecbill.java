
package com.codestates.seb.electricityBill;

import java.util.Scanner;

public class ElectricityBill {
  public static void main(String[] args) {
    System.out.println("=".repeat(25));
    System.out.println(" 주택용 전기요금(저압) 계산기 ");
    System.out.println("=".repeat(25));

    //TODO:
    // 1, 100 이하인 경우 전력당 60.7 원이 부가됩니다. (사용한 전력 100 kWh 이하일 경)
    // 2, 100 이하인 경우 전력당 60.7원 부과, 100 초과인 경우 125.9원 부과 (사용한 전력이 100 kWh 초과일 경우)

    // . 100kWh 이하는 kWh당 60.7원,
    final double BELOW100 = 60.7;
    // . 100kWh 초과는 125.9원
    final double EXCESS100 = 125.9; 
    // . 200kWh 초과는 187.9원
    final double EXCESS200 = 187.9; 
    // . 300kWh 초과는 280.6원
    final double EXCESS300 = 280.6; 
    // . 400kWh 초과는 417.7원
    final double EXCESS400 = 417.7; 
    // . 500kWh 초과는 670.6원
    final double EXCESS500 = 670.6;

    // 예를 들어 150kWh를 사용하였다면 사용량의 100kWh에 대해서는 60.7원을,
    // 나머지 50kWh 사용량에 대해서는 125.9원을 책정해주셔야 합니다.
    double elecUse = 0;               // 전기 사용량
    double bill = 0;                  // 전기 요금


    Scanner scanner = new Scanner(System.in);  // 전기요금을 입력받기 위한 Scanner

    String isyn = "";
    do {

      System.out.println("사용하신 전력량을 입력해주세요 : ");
      elecUse = scanner.nextInt(); // 전력량 입력

      if (elecUse > 500) {          // . 500kWh 초과는 670.6원
        bill =
                100 * BELOW100 +   // 100이하
                        100 * EXCESS100 +   // 100초과
                        100 * EXCESS200 +   // 200초과
                        100 * EXCESS300 +   // 300초과
                        100 * EXCESS400 +   // 400초과
                        (elecUse % 500) * EXCESS500;
      } else if (elecUse > 400) {  // . 400kWh 초과는 670.6원
        bill =
                100 * BELOW100 +   // 100이하
                        100 * EXCESS100 +   // 100초과
                        100 * EXCESS200 +   // 200초과
                        100 * EXCESS300 +   // 300초과
                        (elecUse % 400) * EXCESS400;
      } else if (elecUse > 300) {  // . 300kWh 초과는 670.6원
        bill =
                100 * BELOW100 +   // 100이하
                        100 * EXCESS100 +   // 100초과
                        100 * EXCESS200 +   // 200초과
                        (elecUse % 300) * EXCESS300;
      } else if (elecUse > 200) {  // . 200kWh 초과는 187.9원
        bill =
                100 * BELOW100 +    // 100이하
                        100 * EXCESS100 +   // 100초과
                        (elecUse % 200) * EXCESS200;
      } else if (elecUse > 100) {  // . 100kWh 초과는 125.9원
        bill =
                100 * BELOW100 +    // 100이하
                        (elecUse % 100) * EXCESS100;
      } else {                    // . 100kWh 이하는 kWh당 60.7원
        bill = elecUse * BELOW100;
      }

      System.out.println("사용하신 전기량은 " + elecUse + "이며, 납부하실 요금은 " + (int) bill + "입니다.");

      System.out.println("그만하시겠습니까?(y/n)");

      scanner.nextLine(); // 그만 여부를 입력받기 위한 스캐너.

    } while(!(scanner.nextLine().equalsIgnoreCase("y"))); // y가 아니면 종료.

    System.out.println("프로그램을 종료합니다.");
  }
}
// 나중에 할 것...코드 줄여보기?
