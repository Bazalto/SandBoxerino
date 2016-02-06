package Kek;

interface MathOperation {
    double operation(double a, double b);
}

public class LambdaPls {
    public static void main(String[] args) {
        MathOperation substract = (a, b) -> a - b;

        System.out.println("4 - 2 = " + operate(4,2,substract));
    }

    static double operate(double a, double b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
