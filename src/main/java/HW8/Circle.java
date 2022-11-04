package HW8;

public class Circle extends Shape{

    public Circle(String name) {
        super(name);
    }

    @Override
    public void printShapeName() {
        System.out.println(name);
    }
}
