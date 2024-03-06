package etc.enum_;

	/*
	 # 상수를 정의해서 코드를 작성하면 다양한 문제가 발생할 수 있다.
	 1. 상수의 값 자체는 변경이 불가하겠지만, 상수를 받는 객체의 필드 값은 안정적이지 못함.
	 2. 상수는 어느 클래스에서나 선언할 수 있기 때문에 무분별한 상수 선언이 이뤄질 수 있음.
	 3. 코드의 가독성 또한 좋지 못하다.

	 # enum class를 사용하면 얻을 수 있는 장점.
	 1. 코드가 단순해지고 가독성이 좋아짐.
	 2. 정의한 상수 이외의 값을 컴파일 과정에서 막기 때문에 타입 안정성이 증가함.
	 3. 관련있는 상수들끼리 모아놓기 때문에 구현의 의도를 명확하게 파악 가능.
	 */


public enum Language {

    // 상수("연관시킬 문자")
    JAVA("자바", true),
    PYTHON("파이썬", false),
    CPP("C++", true),
    JAVASCRIPT("자바스크립트", false),
    C("C", true); // 세미콜론 붙이기

    private final String name; // 상수와 연관시킬 문자값을 담을 필드를 선언
    private final boolean isCompileLang;

    public String getName() { // 한글 이름을 얻어내기 위한 메서드 (name -> private)
        return name;
    }

    public boolean isCompileLang() {
        return isCompileLang;
    }

    // 외부에서 enum 타입의 상수를 사용하면 enum 객체가 생성됨.
    // 위의 상수에 선언한 방식의 생성자 호출문을 통해 연관 문자가 매개값으로 전달되면서 name 필드를 초기화.
    private Language(String name, boolean isCompileLang) {
        this.name = name;
        this.isCompileLang = isCompileLang;
    }


}