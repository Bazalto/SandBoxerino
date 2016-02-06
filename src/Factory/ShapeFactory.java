package Factory;

/**
 * Created by Dimbo on 05-Feb-16.
 */
public class ShapeFactory {
    public Shape getShape(String shape){
        if (shape.equalsIgnoreCase("Circle")) return new Circle();
        else if (shape.equalsIgnoreCase("Rectangle")) return new Rectangle();
        else if(shape.equalsIgnoreCase("Square"))return new Square();
        else return null;
    }
}
