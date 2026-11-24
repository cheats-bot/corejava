package calc;

public class Division {
    public double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero");
            return Double.NaN;
        }
        return (double) a / b;
    }
}

