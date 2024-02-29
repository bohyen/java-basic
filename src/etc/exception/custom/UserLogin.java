package etc.exception.custom;

public class UserLogin {

    String userAccount; // 계정명
    String userPassword; // 가입시 설정한 패스워드

    // 객체 생성 시 id, pw 한번에 세팅
    public UserLogin(String userAccount, String userPassword) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
    }

    // 로그인 검증
    public String loginValidate(String inputAccount, String inputPassword)
            throws LoginValidateException {

        // 계정명이 일치하는가?
        if(this.userAccount.equals(inputAccount)) {
            // 패스워드가 일치하는가?
            if(this.userPassword.equals(inputPassword)) {
                // 로그인 성공
                return "SUCCESS";
            } else {
                // 패스워드가 틀림!
                throw new LoginValidateException("비밀번호가 틀렸습니다!");
            }
        } else {
            // 계정 정보가 틀림!
            throw new LoginValidateException("회원가입부터 하세요!");
        }

    }


}