package my.profiler;

import java.util.HashMap;
import java.util.Map;

public class ImprovedSlow {
    private static Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 1; i < 50; i++) {
            measureAndPrint("Fibonacci recursive", i, ImprovedSlow::fibRecursive);
            measureAndPrint("Fibonacci fast", i, ImprovedSlow::fibFast);
        }
    }

    private static void measureAndPrint(String label, long i, FibonacciFunction function) {
        long start = System.nanoTime();
        long result = function.calculate(i);
        long duration = System.nanoTime() - start;
        System.out.println(label + " " + i + " = " + result + " took " + duration + "ns");
    }

    interface FibonacciFunction {
        long calculate(long n);
    }

    private static long fibRecursive(long i) {
        if (i < 2) return 1;
        return memo.computeIfAbsent(i, key -> fibRecursive(key - 2) + fibRecursive(key - 1));
    }

    private static long fibFast(long i) {
        if (i < 2) return i;
        long a = 0, b = 1, c = 0;
        while (i-- > 0) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}