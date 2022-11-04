package HW8;

public class Triangle extends Shape{

    public Triangle(String name) {
        super(name);
    }

    @Override
    public void printShapeName() {
        System.out.println(name);
    }
}
