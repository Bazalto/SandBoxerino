package Packs;

public class PackOne {
    private int dat;
    protected int that;
    public int desu;
}

class PackTwo{
    PackOne remulu = new PackOne();
    public int desuKa = remulu.that;
}
