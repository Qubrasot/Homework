package HW8;

public class Hexagon extends Shape{

    public Hexagon(String name) {
        super(name);
    }

    @Override
    public void printShapeName() {
        System.out.println(name);
    }
}
