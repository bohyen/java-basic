package oop.modi.constructor.pac1;

public class A {

    // 같은 클래스 내에서는 모두 사용이 가능하다.
    A a1 = new A(true);
    A a2 = new A(50);
    A a3 = new A(3.14);


    // 생성자 선언
    public A(boolean b) {}
    A(int i) {} // default
    private A(double d) {}


}