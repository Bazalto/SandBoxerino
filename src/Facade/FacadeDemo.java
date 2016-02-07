package Facade;

public class FacadeDemo {
    public static void main(String[] args){
        ShapeMaker shapeMaker=new ShapeMaker();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
