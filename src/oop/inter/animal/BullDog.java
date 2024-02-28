package oop.inter.animal;

public class BullDog extends Livings implements Violent, Huntable {


    @Override
    public void feed(String foodName) {
        System.out.println("불독이 " + foodName + "을 먹어요.");
    }

    @Override
    public boolean sleep() {
        return false;
    }

    @Override
    public void angry() {
        System.out.println("불독이 화를 내요!");
    }

    @Override
    public void fight() {
        System.out.println("불독이 싸움을 거네요!");
    }

    @Override
    public void hunt(Animal animal) {
        System.out.println("불독이 사냥을 해요!");
    }
}