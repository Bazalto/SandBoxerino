package Facade;

import sun.security.provider.SHA;

/**
 * Created by Dimbo on 05-Feb-16.
 */
public class ShapeMaker {
    private Shape square;
    private Shape rectangle;

    public ShapeMaker() {
        square = new Square();
        rectangle = new Rectangle();
    }

    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}
