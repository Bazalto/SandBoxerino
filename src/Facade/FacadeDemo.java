package Facade;

/**
 * Created by Dimbo on 05-Feb-16.
 */
public class FacadeDemo {
    public static void main(String[] args){
        ShapeMaker shapeMaker=new ShapeMaker();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
