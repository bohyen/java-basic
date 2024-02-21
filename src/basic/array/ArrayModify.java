package basic.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModify {

    public static void main(String[] args) {

        String[] foods = {"삼겹살", "족발", "피자", "햄버거"};
        System.out.println(Arrays.toString(foods));

        foods[0] = "치킨";
        foods[2] = "탕수육";
        System.out.println(Arrays.toString(foods));

        System.out.println("---------------------------------------------");

        Scanner sc = new Scanner(System.in);
        System.out.println("수정할 음식을 입력하세요: ");
        String name = sc.next();

        boolean flag = false;
        for (int i = 0; i < foods.length; i++) {
            if (name.equals(foods[i])) {
                System.out.println("탐색 완료! 인덱스: " + i);
                break;
            }
        }

        if(!flag) {
            System.out.println("없는 음식입니다.");
        }

    }

}
