import java.util.Scanner;

public class Rectangle extends Geometry {
    private Point firstVertices;
    private Point secondVertices;
    private Point thirdVertices;
    private Point fourthVertices;

    public Rectangle() {
        this.firstVertices = new Point();
        this.secondVertices = new Point();
        this.thirdVertices = new Point();
        this.fourthVertices = new Point();
    }

    public Rectangle(Point firstVertices, Point secondVertices, Point thirdVertices, Point fourthVertices) {
        this.firstVertices = firstVertices;
        this.secondVertices = secondVertices;
        this.thirdVertices = thirdVertices;
        this.fourthVertices = fourthVertices;
    }

    public Point getFirstVertices() {
        return firstVertices;
    }

    public Point getSecondVertices() {
        return secondVertices;
    }

    public Point getThirdVertices() {
        return thirdVertices;
    }

    public Point getFourthVertices() {
        return fourthVertices;
    }

    public void setFirstVertices(Point firstVertices) {
        this.firstVertices = firstVertices;
    }

    public void setSecondVertices(Point secondVertices) {
        this.secondVertices = secondVertices;
    }

    public void setThirdVertices(Point thirdVertices) {
        this.thirdVertices = thirdVertices;
    }

    public void setFourthVertices(Point fourthVertices) {
        this.fourthVertices = fourthVertices;
    }

    @Override
    public void input(Scanner scanner) {
        System.out.println("Nhập giá trị của first Vertices: ");
        firstVertices.input(scanner);
        System.out.println("Nhập giá tr của second Vertices: ");
        secondVertices.input(scanner);
        System.out.println("Nhập giá tr của third Vertices: ");
        thirdVertices.input(scanner);
        System.out.println("Nhập giá tr của fourth: ");
        fourthVertices.input(scanner);
    }

    @Override
    public void output() {
        System.out.println("Giá trị của firstVertices: ");
        firstVertices.output();
        System.out.println("Gia trị của secondVertices: ");
        secondVertices.output();
        System.out.println("Gia trị của thirdVertices: ");
        thirdVertices.output();
        System.out.println("Gia trị của fourthVertices: ");
        fourthVertices.output();

        if (!isValid()) {
            System.out.println("Tọa độ sai không phải HCN !!!");
        } else {
            System.out.println("Giá trị của chu vi: " + perimeterCalculate());
            System.out.println("Giá trị của diện tích: " + areaCalculate());
        }
    }

    public boolean isEdgeRectangle(double distanceAB, double distanceBC, double distanceCD, double distanceDA) {
        return distanceAB == distanceCD && distanceBC == distanceDA;
    }

    public boolean isVuongGoc(Point _firstVertices, Point _secondVertices, Point _thirdVertices) {
        double xA = _firstVertices.getX();
        double yA = _firstVertices.getY();

        double xB = _secondVertices.getX();
        double yB = _secondVertices.getY();

        double xC = _thirdVertices.getX();
        double yC = _thirdVertices.getY();

        double dotProduct = ((xB - xA) * (xC - xA) + (yB - yA) * (yC - yA));
        double magnitudeA = Math.sqrt(Math.pow(xB - xA, 2) + Math.pow(yB - yA, 2));
        double magnitudeB = Math.sqrt(Math.pow(xC - xA, 2) + Math.pow(yC - yA, 2));
        return Math.abs(dotProduct / (magnitudeA * magnitudeB)) == 1.0;
    }

    @Override
    public boolean isValid() {
        double lengthAB = distance(firstVertices, secondVertices);
        double lengthBC = distance(secondVertices, thirdVertices);
        double lengthCD = distance(thirdVertices, fourthVertices);
        double lengthDA = distance(fourthVertices, firstVertices);

        if (!isEdgeRectangle(lengthAB, lengthBC, lengthCD, lengthDA)) return false;

        boolean isVuongGoc = !isVuongGoc(firstVertices, secondVertices, thirdVertices) || !isVuongGoc(secondVertices, thirdVertices, fourthVertices) || !isVuongGoc(thirdVertices, fourthVertices, firstVertices) || !isVuongGoc(fourthVertices, firstVertices, secondVertices);
        if (isVuongGoc) return false;

        return true;
    }

    public double distance(Point firstVertices, Point secondVertices) {
        return Math.sqrt(Math.pow(secondVertices.getX() - firstVertices.getX(), 2) + Math.pow(secondVertices.getY() - firstVertices.getY(), 2));
    }

    @Override
    public double perimeterCalculate() {
        if (!isValid()) return -1;
        double distanceEdgeAB = distance(firstVertices, secondVertices);
        double distanceEdgeBC = distance(secondVertices, thirdVertices);
        return 2 * (distanceEdgeAB + distanceEdgeBC);
    }

    @Override
    public double areaCalculate() {
        if (!isValid()) return -1;
        double distanceEdgeAB = distance(firstVertices, secondVertices);
        double distanceEdgeBC = distance(secondVertices, thirdVertices);
        return distanceEdgeAB * distanceEdgeBC;
    }
}
