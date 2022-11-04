package HW8;

public class GraphicRedactor {
    public static void main(String[] args) {
        Shape tr = new Triangle("1");
        Shape cr = new Circle("2");

        TitleShape.printShapeTitle(tr);
    }
}