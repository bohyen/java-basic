package oop.inter.good;

public class Join implements IUserService {

    public Join() {
        System.out.println("회원 가입 요청이 들어옴!");
    }

    @Override
    public void execute() {
        System.out.println("회원 가입 로직이 실행됩니다.");
        System.out.println("DB 접속도 하고, 입력값도 가져오고, 값을 집어넣고 등등등....");
    }
}