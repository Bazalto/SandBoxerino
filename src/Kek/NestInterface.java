package Kek;

/**
 * Created by Dimbo on 02-Feb-16.
 */

interface Outer{
    void outerMethod();

    interface Inner{
        void innerMethod();
    }
}

public class NestInterface implements Outer{

    @Override
    public void outerMethod() {

    }
}
