package etc.api.io.obj;

import java.io.Serializable;

// 객체를 스트림으로 전송하려면 직렬화가 가능해야 합니다.
// 직렬화(serialize): 자바 언어에서 사용되는 Object 또는 Data를 다른 환경의 자바 프로그램에서 사용 할 수 있도록
// 바이트 형태의 연속적인 데이터로 변환하는 기술.
public class Snack implements Serializable {

    private String snackName;
    private int year; // 출시연도
    private int price; // 가격
    private String taste; // 맛

    public Snack(String snackName, int year, int price, String taste) {
        this.snackName = snackName;
        this.year = year;
        this.price = price;
        this.taste = taste;
    }

    public String getSnackName() {
        return snackName;
    }

    public void setSnackName(String snackName) {
        this.snackName = snackName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "snackName='" + snackName + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", taste='" + taste + '\'' +
                '}';
    }


}