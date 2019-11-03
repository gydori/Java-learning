package Diagram;

public class Factorial {

    public static void factorial(long[] tomb) {
        long[][] eredmeny = new long[2][tomb.length];
        for (int i = 0; i < tomb.length; i++) {
            long start = System.currentTimeMillis();
            System.out.println("start:" + start);
            long result = 1;
            for (int j = 1; j <= tomb[i]; j++) {
                result = result * j;
            }
            long end = System.currentTimeMillis();
            System.out.println("end:" + end);
            System.out.println("result: " + result);
            long time = end - start;
            eredmeny[0][i] = tomb[i];
            eredmeny[1][i] = time;
            System.out.println(eredmeny[0][i] + " " + eredmeny[1][i]);
        }
/*        double[][] eredmenyD = new double[2][tomb.length];
        for (int i = 0; i < eredmeny.length; i++) {
            for (int j = 0; j < eredmeny[i].length; j++) {
                eredmenyD[i][j] = eredmeny[i][j];
            }
        }
        return eredmenyD;*/
    }

    public static long factRec(long num) {
        if (num == 0) {
            return 1;
        }
        return num * factRec(num - 1);
    }

    public static void factTime(long[] tomb) {
        long[][] eredmeny = new long[2][tomb.length];
        for (int i = 0; i < tomb.length; i++) {
            long start = System.currentTimeMillis();
            factRec(tomb[i]);
            long end = System.currentTimeMillis();
            long time = end - start;
            eredmeny[0][i] = tomb[i];
            eredmeny[1][i] = time;
            System.out.println(eredmeny[0][i] + " " + eredmeny[1][i]);
        }
    }
}
