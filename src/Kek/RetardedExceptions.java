package Kek;

/**
 * Created by Dimbo on 06-Feb-16.
 */
public class RetardedExceptions {
    public static void main(String[] args) {
        try {
            try {
                int a = 0;
                int b = 42 / 0;
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("inside");
            }

            System.out.println("ORA ORA In between");
        } catch (Exception ex) {
            System.out.println("outside");
        }
        String yolo="swag";
        System.out.println(yolo.getClass()+"\n");
        

    }
}
