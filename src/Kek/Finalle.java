package Kek;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Finalle {
    public static void main(String[] args) {
        int i = 5;
        BufferedInputStream bif = new BufferedInputStream(new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        });
        try {
            StaticZ obk = new StaticZ();
            int dock = bif.read();
        } catch (NullPointerException ex) {
            System.out.printf("Yolo");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
