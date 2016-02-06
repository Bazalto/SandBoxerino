package Kek;

/**
 * Created by Dimbo on 15-Jan-16.
 */
public class Obj implements Cloneable{
    public String top;

    Obj(String top) {
        this.top = top;
    }

    void say() {
        System.out.println("I say: " + top);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Obj obj1 = new Obj("kek");
        Obj obj2 = (Obj) obj1.clone();
        obj2.top = "Halo";
        obj1.say();
        obj2.say();
    }
}
