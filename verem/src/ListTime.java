import java.util.ArrayList;
import java.util.List;

public class ListTime {
    public static void addTime(long[] tomb) {
        long[][] eredmeny = new long[tomb.length][2];
        for (int i = 0; i < tomb.length; i++) {
            List<Integer> list = new ArrayList<>();
            long start = System.currentTimeMillis();
            for (int j = 0; j < tomb[i]; j++) {
                list.add((int) Math.random());
            }
            long end = System.currentTimeMillis();
            long time = end - start;
            eredmeny[i][0] = tomb[i];
            eredmeny[i][1] = time;
            System.out.println(eredmeny[i][0] + " " + eredmeny[i][1]);
        }
    }

    public static void addGetTime(long[] tomb) {
        long[][] eredmeny = new long[tomb.length][3];
        for (int i = 0; i < tomb.length; i++) {
            List<Integer> list = new ArrayList<>();
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

    public static void addGetContainsTime(long[] tomb) {
        long[][] eredmeny = new long[tomb.length][4];
        for (int i = 0; i < tomb.length; i++) {
            List<Integer> list = new ArrayList<>();
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
            start = System.currentTimeMillis();
            for (int j = 0; j < tomb[i]; j++) {
                list.contains((int) Math.random());
            }
            end = System.currentTimeMillis();
            time = end - start;
            eredmeny[i][3] = time;
            System.out.println(eredmeny[i][0] + " add: " + eredmeny[i][1] + " get: " + eredmeny[i][2] + " contains: " + eredmeny[i][3]);
        }
    }


}
