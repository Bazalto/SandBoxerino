package Factory;


/**
 * Created by Dimbo on 05-Feb-16.
 */
public class FactoryDemo {
    public static void main(String[] args){
        ShapeFactory factory = new ShapeFactory();
        Shape shape = factory.getShape("circle");
        shape.draw();
    }
}
