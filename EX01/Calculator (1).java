public class Calculator {
     public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            System.out.println("ZeroDivisionError");
            return 0;
        }
        return (double) a / b;
    }

    public int modular(int a, int b) {
        if (b == 0) {
            System.out.println("ZeroDivisionError");
            return 0;
        }
        return a % b;
    }
}
    

