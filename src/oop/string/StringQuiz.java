package oop.string;

import java.util.Scanner;

public class StringQuiz {

    public static void main(String[] args) {

        /*
		 1. 주민등록번호 13자리를 입력받습니다.
		 2. 주민등록번호는 -을 포함해서 받을 예정입니다.
		 3. 13자리가 아니라면 다시 입력받습니다.
		 4. ex)
		 921013-1234567 -> 1992년 10월 13일 32세 남자
		 960223-2345678 -> 1996년 2월 23일 28세 여자
		 031125-3456789 -> 2003년 11월 25일 21세 남자
		 031125-4123456 -> 2003년 11월 25일 21세 여자

		 제대로 출력이 될 때까지 다시 입력 받으세요.
		*/

        Scanner sc = new Scanner(System.in);

        System.out.println("주민등록번호 13자리를 입력하세요.");
        System.out.println("-을 포함해서 입력하세요.");

        while (true) {
            System.out.print("> ");
            String ssn = sc.next();

            if(ssn.indexOf("-") == -1) {
                System.out.println("-을 포함해서 입력하세요.");
                continue;
            } else if(ssn.length() != 14) {
                System.out.println("주민등록번호는 13자리 입니다.");
                continue;
            }

            ssn = ssn.replace("-", "");
            char c = ssn.charAt(6);
            String str = ssn.substring(0, 2);
            int year = Integer.parseInt(str); // 연도를 정수로 변환.
            String month = ssn.substring(2, 4);
            String day = ssn.substring(4,6);

            if(c == '1' || c == '2') {
                year += 1900;
            } else {
                year += 2000;
            }

            int age = 2024 - year;

            String gender;
            if(c == '1' || c == '3') {
                gender = "남자";
            } else {
                gender = "여자";
            }

            System.out.printf("%d년 %s월 %s일 %d세 %s\n", year, month, day, age, gender);
            break;
        }

        sc.close();

    }

}