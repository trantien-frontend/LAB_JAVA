import java.util.Scanner;

public class Point {
    private double x;
    private double y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double _x, double _y) {
        this.x = _x;
        this.y = _y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void input (Scanner scanner) {

        boolean isInput = false;

        while (!isInput) {
            try {
                System.out.println("Nhập vào giá trị của x: ");
                this.x = Double.parseDouble(scanner.nextLine());

                System.out.println("Nhập vào giá trị của y: ");
                this.y = Double.parseDouble(scanner.nextLine());

                isInput = true;
            } catch (RuntimeException exception) {
                System.out.println("Giá trị nhập không hợp lệ !!!");
            }
        }

    }

    public void output () {
        System.out.println("Giá trị hoành độ: " + this.x);
        System.out.println("Giá trị của tung độ: " + this.y);
}

}
