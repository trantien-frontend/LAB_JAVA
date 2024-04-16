import java.util.Scanner;

public class LineSegment extends Geometry {
    private Point firstPoint;
    private Point secondPoint;
    private double length;

    public LineSegment() {
        firstPoint = new Point();
        secondPoint = new Point();
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public double getLength() {
        return length;
    }

    @Override
    public void input(Scanner scanner) {
        System.out.println("Nhập tọa độ điểm đầu tiên: ");
        firstPoint.input(scanner);
        System.out.println("Nhập tọa độ điểm thứ hai: ");
        secondPoint.input(scanner);
    }

    @Override
    public void output() {
        System.out.println("Giá trị của firstPoint: ");
        firstPoint.output();
        System.out.println("Gia trị của secondPoint: ");
        secondPoint.output();

        String formatLength = String.format("%.2f", length);
        System.out.println("Giá trị của length: " + formatLength);
    }

    public void length() {
        double x = Math.abs(firstPoint.getX() - secondPoint.getX());
        double y = Math.abs(firstPoint.getY() - secondPoint.getY());
        this.length = Math.sqrt((x * x) + (y * y));
    }

    @Override
    public boolean isValid() {
        throw new RuntimeException("Hàm này không sử dụng cho LineSegment");
    }

    @Override
    public double perimeterCalculate() {
        throw new RuntimeException("Không thể tính diện tích cho LineSegment");
    }

    @Override
    public double areaCalculate() {
        throw new RuntimeException("Không thể tính chu vi cho LineSegment");
    }
}
