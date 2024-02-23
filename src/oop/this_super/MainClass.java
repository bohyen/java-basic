package oop.this_super;

public class MainClass {

    public static void main(String[] args) {

        Player p1 = new Player();
        p1.name = "플레이어1";
        p1.characterInfo();

        System.out.println("-------------------------------------------");

        Player p2 = new Player("플레이어2");
        System.out.println("main에서 p2의 주소값: " + p2);
        p2.characterInfo();

        System.out.println("-------------------------------------------");

        Player p3 = new Player("플레이어3");
        System.out.println("main에서 p3의 주소값: " + p3);
        p2.characterInfo();


    }

}