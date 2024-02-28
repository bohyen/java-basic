package oop.obj_arr;

public class Score {

    /*
	 - 이름, 국어, 영어, 수학, 총점, 평균(double)을
	  담을 수 있는 객체를 디자인하세요.

	 - 학생의 모든 정보를 한 눈에 확인할 수 있게
	  scoreInfo() 메서드를 선언해 주세요.
	  메서드 내부에는 출력문을 이용해서 모든 정보를 출력해 주세요.

	 - 캡슐화를 구현해서 작성해 주세요. (생성자는 맘대로 하세요.)
	*/

    private String name;
    private int kor;
    private int eng;
    private int math;
    private int total;
    private double average;

    public Score() {}

    public Score(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.setTotalAndAvg();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getTotal() {
        return total;
    }

    /*
    public void setTotal() {
        // 이미 kor, eng, math가 세팅이 완료되었다고 가정.
        this.total = this.kor + this.eng + this.math;
    }
    */

    public double getAverage() {
        return average;
    }

    /*
    public void setAverage() {
        this.average = this.total / 3.0;
    }
    */

    // 총점과 평균을 한번에 계산해서 세팅하는 메서드
    public void setTotalAndAvg() {
        this.total = this.kor + this.eng + this.math;
        this.average = this.total / 3.0;
    }

    public void scoreInfo() {
        System.out.printf("이름: %s  국어: %d점  영어: %d점  수학: %d점\n총점: %d점  평균: %.2f점\n"
                , name, kor, eng, math, total, average);
    }

    // 점수 유효성 검증
    public static boolean isValidateScore(int score) {
        if(score > 100 || score < 0) {
            System.out.println("유효하지 않은 점수입니다. (0 ~ 100)");
            return false;
        }
        return true;
    }


}