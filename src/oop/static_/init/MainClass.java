package oop.static_.init;

public class MainClass {

    public static void main(String[] args) {

//        DBManager manager = new DBManager();

        /*
		 - 정적 초기화자를 호출하려면 클래스를 로딩하시면 됩니다.
		 # 클래스 로딩 방법
		 1. 클래스의 이름을 참조하여 static 멤버를 호출.
		 2. 객체를 생성함.
		 - 정적 초기화자는 클래스 로딩 시 최초 1회만 호출됩니다.
		 */


        System.out.println("manager.addr = " + DBManager.addr);
        System.out.println("manager.uid = " + DBManager.uid);
        System.out.println("manager.upw = " + DBManager.upw);

    }

}