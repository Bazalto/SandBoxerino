package Kek;

/**
 * Created by Dimbo on 18-Jan-16.
 */

interface ImplementThis{
    void doMe();
}

class ImplementThat implements ImplementThis{
    public void doMe(){

    }
}


abstract class Peka{
    public int pepa=4;
    private int gepa;
    protected int pepas;
    abstract void setPepa(int newPepa);
    abstract int getPepa();
}

class AbstractHelper extends Peka{
    @Override
    void setPepa(int newPepa) {
        pepa = newPepa;
    }

    @Override
    int getPepa() {
        return 0;
    }
}

class Helper{
    int notStatic = 0;
    static int areStatic = 0;

    public void methodOne(){
        System.out.println("yolo");
        notStatic =1;
        areStatic=2;
    }

    public static void methodTwo(){
        System.out.println("Static");
        //notStatic =1;
        areStatic=2;
    }
}

public class StaticZ {

}
