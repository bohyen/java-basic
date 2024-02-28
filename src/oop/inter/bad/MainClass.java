package oop.inter.bad;

import static util.Utility.input;

public class MainClass {

    public static void main(String[] args) {

        System.out.println("진행하실 번호를 입력하세요.");
        System.out.println("1. 가입  2. 로그인  3. 정보수정  4. 탈퇴");
        String menu = input("> ");

        if(menu.equals("1")) {
            Join join = new Join();
            join.join();
        } else if(menu.equals("2")) {
            Login log = new Login();
            log.login();
        } else if(menu.equals("3")) {
            Update update = new Update();
            update.update();
        } else if(menu.equals("4")) {
            Delete del = new Delete();
            del.delete();
        }

    }

}