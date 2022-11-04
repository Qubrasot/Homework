package HW8;

public class Ellipse extends Shape{

    public Ellipse(String name) {
        super(name);
    }

    @Override
    public void printShapeName() {
        System.out.println(name);
    }
}
