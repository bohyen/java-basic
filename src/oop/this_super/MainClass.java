package oop.this_super;

public class MainClass {

    public static void main(String[] args) {

        Player p1 = new Player();
        p1.name = "플레이어1";
        p1.characterInfo();

        System.out.println("-------------------------------------------");

        Player p2 = new Player("플레이어2");
        p2.characterInfo();

        System.out.println("-------------------------------------------");

        Player p3 = new Player("플레이어3", 100);
        p3.characterInfo();

        System.out.println("-------------------------------------------");

        p1.attack(p2);
        p2.attack(p3);
        p3.attack(p1);

        System.out.println("-------------------------------------------");

        Warrior w1 = new Warrior("전사짱짱맨");
        w1.characterInfo();


    }

}