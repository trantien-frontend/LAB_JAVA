import java.util.Scanner;

public class Triangle extends Geometry {
    private Point firstVertices;
    private Point secondVertices;
    private Point thirdVertices;

    public Triangle() {
        firstVertices = new Point();
        secondVertices = new Point();
        thirdVertices = new Point();
    }

    public Triangle(Point firstVertices, Point secondVertices, Point thirdVertices) {
        this.firstVertices = firstVertices;
        this.secondVertices = secondVertices;
        this.thirdVertices = thirdVertices;
    }

    @Override
    public void input(Scanner scanner) {
        System.out.println("Nhập giá tr của first Vertices: ");
        firstVertices.input(scanner);
        System.out.println("Nhập giá tr của second Vertices: ");
        secondVertices.input(scanner);
        System.out.println("Nhập giá tr của third Vertices: ");
        thirdVertices.input(scanner);
    }

    @Override
    public void output() {
        System.out.println("Giá trị của firstVertices: ");
        firstVertices.output();
        System.out.println("Gia trị của secondVertices: ");
        secondVertices.output();
        System.out.println("Gia trị của thirdVertices: ");
        thirdVertices.output();

        if (perimeterCalculate() == -1 || areaCalculate() == -1) {
            System.out.println("Tọa độ sai không phải tam giác !!!");
        } else {
            System.out.println("Giá trị của chu vi: " + perimeterCalculate());
            System.out.println("Giá trị của diện tích: " + areaCalculate());
        }
    }

    public double distance(Point second, Point first) {
        System.out.println("--------------------------------");
        System.out.println(Math.sqrt(Math.pow(second.getX() - first.getX(), 2) + Math.pow(second.getY() - first.getY(), 2)));
        System.out.println("--------------------------------");
        return Math.sqrt(Math.pow(second.getX() - first.getX(), 2) + Math.pow(second.getY() - first.getY(), 2));
    }

    @Override
    public boolean isValid() {
        double distanceAB = distance(secondVertices, firstVertices);
        double distanceAC = distance(thirdVertices, firstVertices);
        double distanceBC = distance(thirdVertices, secondVertices);
        return (distanceAB + distanceBC > distanceAC) && (distanceAB + distanceAC > distanceBC) && (distanceAC + distanceBC > distanceAB);
    }
    @Override
    public double perimeterCalculate() {
        if (!isValid()) {
            return -1;
        }
        double distanceAB = distance(secondVertices, firstVertices);
        double distanceAC = distance(thirdVertices, firstVertices);
        double distanceBC = distance(thirdVertices, secondVertices);
        return distanceAB + distanceAC + distanceBC;
    }

    @Override
    public double areaCalculate() {
        if (!isValid()) {
            return -1;
        }

        double distanceAB = distance(secondVertices, firstVertices);
        double distanceAC = distance(thirdVertices, firstVertices);
        double distanceBC = distance(thirdVertices, secondVertices);

        double p = perimeterCalculate();
        double s = Math.sqrt(p * (p - distanceAB) * (p - distanceAC) * (p - distanceBC));

        return s;
    }
}
