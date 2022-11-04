package HW8;

public class Quad extends Shape{
    public Quad(String name) {
        super(name);
    }

    @Override
    public void printShapeName() {
        System.out.println(name);
    }
}
