package Diagram;

import java.util.ArrayList;
import java.util.List;

public class ListTime {
    public static double[][] addTime(long[] tomb) {
        long[][] eredmeny = new long[2][tomb.length];
        for (int i = 0; i < tomb.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
            long start = System.currentTimeMillis();
            for (int j = 0; j < tomb[i]; j++) {
                list.add((int) Math.random());
            }
            long end = System.currentTimeMillis();
            long time = end - start;
            eredmeny[0][i] = tomb[i];
            eredmeny[1][i] = time;
            System.out.println(eredmeny[0][i] + " " + eredmeny[1][i]);
        }
        double[][] eredmenyD = new double[2][tomb.length];
        for (int i = 0; i < eredmeny.length; i++) {
            for (int j = 0; j < eredmeny[i].length; j++) {
                eredmenyD[i][j] = eredmeny[i][j];
            }
        }
        return eredmenyD;
    }

    public static void addGetTime(long[] tomb) {
        long[][] eredmeny = new long[tomb.length][3];
        for (int i = 0; i < tomb.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
            long start = System.currentTimeMillis();
            for (int j = 0; j < tomb[i]; j++) {
                list.add((int) Math.random());
            }
            long end = System.currentTimeMillis();
            long time = end - start;
            eredmeny[i][0] = tomb[i];
            eredmeny[i][1] = time;
            start = System.currentTimeMillis();
            for (int j = 0; j < tomb[i]; j++) {
                list.get((int) Math.random() * (int) tomb[i]);
            }
            end = System.currentTimeMillis();
            time = end - start;
            eredmeny[i][2] = time;
            System.out.println(eredmeny[i][0] + " add: " + eredmeny[i][1] + " get: " + eredmeny[i][2]);
        }
    }

    public static double[][] addGetContainsTime(long[] tomb) {
        long[][] eredmeny = new long[4][tomb.length];
        for (int i = 0; i < tomb.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
            long start = System.currentTimeMillis();
            for (int j = 0; j < tomb[i]; j++) {
                list.add((int) Math.random());
            }
            long end = System.currentTimeMillis();
            long time = end - start;
            eredmeny[0][i] = tomb[i];
            eredmeny[1][i] = time;
            start = System.currentTimeMillis();
            for (int j = 0; j < tomb[i]; j++) {
                list.get((int) Math.random() * (int) tomb[i]);
            }
            end = System.currentTimeMillis();
            time = end - start;
            eredmeny[2][i] = time;
            start = System.currentTimeMillis();
            for (int j = 0; j < tomb[i]; j++) {
                list.contains((int) Math.random());
            }
            end = System.currentTimeMillis();
            time = end - start;
            eredmeny[3][i] = time;
            System.out.println(eredmeny[0][i] + " add: " + eredmeny[1][i] + " get: " + eredmeny[2][i] + " contains: " + eredmeny[3][i]);
        }
        double[][] eredmenyD = new double[4][tomb.length];
        for (int i = 0; i < eredmeny.length; i++) {
            for (int j = 0; j < eredmeny[i].length; j++) {
                eredmenyD[i][j] = eredmeny[i][j];
            }
        }
        return eredmenyD;
    }

}
