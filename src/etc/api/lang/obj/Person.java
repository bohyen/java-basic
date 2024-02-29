package etc.api.lang.obj;

import java.util.Objects;

public class Person implements Cloneable {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // toString(): 객체의 정보(필드)를 문자열 형태로 리턴.
    @Override
    public String toString() {
        return "Person [이름: " + name + ", 나이: " + age + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // 주소값이 같다면 같은 객체야~
        if(obj instanceof Person) {
            Person p = (Person) obj; // Object 타입을 Person 타입으로 형 변환 -> name과 age를 확인하기 위해서.
            if(this.name.equals(p.name) && this.age == p.age) {
                return true;
            }
        }
        return false;
    }

    //equals를 오버라이딩 할 때는 hashCode도 함께 오버라이딩을 진행해 주시는 것이 좋습니다.
    //equals를 재 정의한다는 것은 내가 원하는 방식의 동등 비교를 하겠다는 것이기 때문에
    //hashcode의 값도 그에 맞게 같이 재 정의가 되어야 합니다. (hash 주소를 equals에 맞게 정의)
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    protected void finalize() throws Throwable {
        // 생성된 객체가 사라지는 시점에서 자동으로 호출 (gc가 실행될 때)
        System.out.println(this.name + "이(가) 주것습니다 ㅜㅜ");
    }

    // 객체 복사 메서드
    // Cloneable 인터페이스를 구현해서 사용해야 합니다.
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void personInfo() {
        System.out.println("이름: " + name);
        System.out.println("나이: " + age + "세");
    }






}