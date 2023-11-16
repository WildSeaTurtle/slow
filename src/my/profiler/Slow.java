package my.profiler;

public class Slow {
    public static void main(String[] args) {
        for (int i = 1; i < 50; i++) {
            long start = System.currentTimeMillis();
            System.out.println("Fibonacci recursive " + i + " = " + fibRecursive(i) + " took " + (System.currentTimeMillis() - start) + "ms");
            start = System.currentTimeMillis();
            System.out.println("Fibonacci fast      " + i + " = " + fibFast(i) + " took " + (System.currentTimeMillis() - start) + "ms");
        }
    }



    static long fibRecursive(long i) {
        if (i < 2) return 1;
        return fibRecursive(i-2) + fibRecursive(i -1);
    }




    static long fibFast(long i) {
        if (i < 2) return i;
        int a = 0, b = 1, c = 0;
        while (i-- > 0) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

public class FactorialExample {

    public static void main(String[] args) {
        int number = 5; // Change this to the desired number
        long result = factorial(number);
        System.out.println("Factorial of " + number + " = " + result);
    }

    // Recursive function to calculate factorial
    static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
