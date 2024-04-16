import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Math.pow(5,2));
        int choose;
        do {
            menu();
            System.out.println("Vui lòng chọn: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    LineSegment lineSegment = new LineSegment();
                    lineSegment.input(scanner);
                    lineSegment.length();
                    lineSegment.output();
                    break;
                case 2:
                    Triangle triangle = new Triangle();
                    triangle.input(scanner);
                    triangle.output();
                    System.out.println(triangle.isValid());
                case 0:
                    break;
            }
        }
        while (choose != 0);
    }

    public static void menu() {
        System.out.println("Vui lòng chọn !!!");
        System.out.println("1. LineSegment");
        System.out.println("2. Triangle");
        System.out.println("3. Rectangle");
        System.out.println("4. Circle");
        System.out.println("0. Exits Program");
    }
}