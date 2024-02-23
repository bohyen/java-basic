package oop.constructor;

public class BreadMain {

    public static void main(String[] args) {
        /*
        String breadName = "피자빵";
        int price = 1000;
        String ingredient = "밀가루";

        System.out.println("이름: " + breadName);
        System.out.println("가격: " + price + "원");
        System.out.println("주재료: " + ingredient);

        String breadName2 = "초코케이크";
        int price2 = 3000;
        String ingredient2 = "초콜렛";

        System.out.println("이름: " + breadName2);
        System.out.println("가격: " + price2 + "원");
        System.out.println("주재료: " + ingredient2);

        객체를 생성하지 않았을 때의 예시를 보고
        Bread 클래스를 생성해서 설계를 해 주세요.
        빵의 정보를 나타내는 출력문은 Bread의 메서드로 처리해 주세요.
        방금 배웠던 생성자를 활용하셔도 좋습니다.
        클래스 제작이 완료되면 main 메서드에 객체를 생성해서 결과를 출력해 보세요.
         */

        Bread p = new Bread();
        p.name = "피자빵";
        p.price = 1000;
        p.ingredient = "밀가루";
        p.info();

        Bread c = new Bread("초코케이크", 3000, "초콜렛");
        c.info();

    }

}