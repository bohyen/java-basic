package etc.exception.basic;

import java.util.Scanner;

public class TryCatchExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("정수1: ");
            int i = sc.nextInt();
            System.out.print("정수2: ");
            int j = sc.nextInt();

            System.out.println("나눗셈 시작!");


            // try 블록에는 예외 발생 가능성이 있는 코드를 배치합니다.
            System.out.printf("%d / %d = %d\n", i, j, i / j);
        } catch (Exception e) {
            // catch 블록에는 try블록에서 실제 예외가 발생했을 경우
            // 실행할 코드를 작성합니다.
            System.out.println("예외 발생!");
        }

        System.out.println("프로그램 정상 종료!");

        sc.close();

    }

}