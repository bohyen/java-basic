package basic.casting;

public class CastingExample2 {

    public static void main(String[] args) {

      int i = 72;
      char c = (char) i;
        System.out.println("c = " + c);
        
        double d = 4.98765;
        int j = (int) d;
        System.out.println("여러분들의 이번 달 월급 = " + j*1000000);
        
        int k = 1000;
        byte b = (byte) k;
        System.out.println("b = " + b);

    }

}
