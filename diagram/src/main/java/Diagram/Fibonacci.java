package Diagram;

public class Fibonacci {

    public static void fibonacci(long[] tomb) {
        long[][] eredmeny = new long[2][tomb.length];
        long start = System.currentTimeMillis();
        for (int i = 0; i < tomb.length; i++) {
            int prev1 = 1;
            int prev2 = 1;
            int fib = 1;
            for (int j = 2; j < tomb[i]; j++) {
                fib = prev1 + prev2;
                prev1 = prev2;
                prev2 = fib;
            }
            long end = System.currentTimeMillis();
            long time = end - start;
            eredmeny[0][i] = tomb[i];
            eredmeny[1][i] = time;
            System.out.println(eredmeny[0][i] + " " + eredmeny[1][i] + " " + fib);
        }
    }

    public static long fiboRec(long num) {
        if (num == 1) {
            return 1;
        }
        if (num == 2) {
            return 1;
        }
        return fiboRec(num - 1) + fiboRec(num - 2);
    }

    public static void fiboTime(long[] tomb) {
        long[][] eredmeny = new long[2][tomb.length];
        for (int i = 0; i < tomb.length; i++) {
            long start = System.currentTimeMillis();
            fiboRec(tomb[i]);
            long end = System.currentTimeMillis();
            long time = end - start;
            eredmeny[0][i] = tomb[i];
            eredmeny[1][i] = time;
            System.out.println(eredmeny[0][i] + " " + eredmeny[1][i]);
        }
    }
}
