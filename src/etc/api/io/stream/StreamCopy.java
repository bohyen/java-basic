package etc.api.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamCopy {

    public static void main(String[] args) {

        try(FileOutputStream fos = new FileOutputStream("C:/MyWorkspace/copy.png");
            FileInputStream fis = new FileInputStream("C:/MyWorkspace/chicken.png")) {

            int data = 0;
            while(data != -1) {
                // 1byte 단위로 데이터를 읽어들임과 동시에 데이터를 작성.
                data = fis.read();
                fos.write(data);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}