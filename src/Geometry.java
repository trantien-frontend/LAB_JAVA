import java.util.Scanner;

public abstract class Geometry {
    public abstract void input (Scanner scanner);
    public  abstract  void output ();
    public  abstract  boolean isValid();
    public abstract double perimeterCalculate();
    public abstract double areaCalculate();
}
