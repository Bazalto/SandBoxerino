package Facade;

import sun.security.provider.SHA;

/**
 * Created by Dimbo on 05-Feb-16.
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}
