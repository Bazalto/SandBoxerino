package Kek;

/**
 * Created by Dimbo on 15-Jan-16.
 */
interface Classic{
    void sayHi();

}

class Illitka{
    Illitka(){
        System.out.println("TOPLEL");
    }
}

public class AnonPls {
    public static void main(String[] args){
        Classic classic = new Classic(){
            public void sayHi() {
                System.out.println("hallo");
            }


        };
        Classic classic1 = () -> System.out.println("Hi");

        classic.sayHi();
        classic1.sayHi();

        new Illitka();

    }
}
