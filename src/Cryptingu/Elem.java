package Cryptingu;

public class Elem {
    public int a;
    public int rev;
    public int dec;

    public String expr;

    Elem() {
    }

    Elem(int a, int rev, int dec, String expr) {
        this.a = a;
        this.rev = rev;
        this.dec = dec;
        this.expr = expr;
    }
}
