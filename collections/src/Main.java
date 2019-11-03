import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] arr1 = new int[10];   //fix méretű, típustól függő, bejárás
        for (int n : arr1) {
            //n - a tömb aktuális eleme, nem tudtuk módosítani
        }
        for (int i = 0; i < arr1.length; i++) {
            //i - a tömb indexe, arr[i] a tömb adott eleme
        }
        //-----------------------------------------------------------

        List<String> stringList = new ArrayList<>();
        stringList.add("cica");
        stringList.add("nagycica");
        stringList.add("oroszlán");
        stringList.add("tigris");
        stringList.add("kiscica");
        System.out.println(stringList);
        /*stringList.clear();         //Minden elem törlése
        System.out.println(stringList);*/
        String deleted = stringList.remove(0);
        System.out.println(deleted);
        System.out.println(stringList);
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        /*removeOdds(intList);
        System.out.println(intList);*/
        /*removeOddsWithIterator(intList);
        System.out.println(intList);*/
        //-------------------------------------------------------------------------
        Set<Integer> hashInt = new HashSet<>();
        Set<Integer> intSet = new TreeSet<>();  //halmaz piros-fekete fa által
        intSet.add(1);      //Minden elem csak egyszer szerepelhet a halmazban
        intSet.add(2);      //Az elemek rendezetlenek
        intSet.add(1);
        System.out.println(intSet);
        //-------------------------------------------------
        Map<Integer, String> map = new HashMap<>(); //kulcs-érték párokat tárolunk benne
        map.put(1, "Cica");     //kulcs-érték pár hozzáadása
        map.put(200, "Macska");
        System.out.println(map.get(200));
        //------------------------------------------------------
        Stack<Integer> intStack = new Stack<>();        //Verem adatszerkezet, LIFO
        intStack.push(1);           //Verembe rakás mindig a tetejére
        intStack.push(5);
        intStack.push(20);
        System.out.println(intStack);
        int element = intStack.pop();       //Verem tetején lévő elem kivétele
        System.out.println(intStack);
        element = intStack.peek();      //nem vesszük ki, csak megnézzük mi van ott
        System.out.println(element);
        System.out.println(intStack);
        //-----------------------------------------------------------
        Queue<Integer> intQueue = new ArrayDeque<>();       //Sor - FIFO
        intQueue.add(1);            //Sorba berakás, a sor végére
        intQueue.add(5);
        intQueue.add(20);
        System.out.println(intQueue);
        System.out.println(intQueue.poll());        //Sor első elemének kivétele a sorból
        System.out.println(intQueue);
    }


    /*
    A listából való törlés index szerinti bejárás esetén nem megfelelő,
    mert a törlések miatt kihagy bizonyos elemeket.
     */
    public static void removeOdds(List<Integer> input) {
/*        for (int i : input) {
            if (i % 2 == 1) input.remove((Object) i);
        }*/
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) % 2 == 1) {        //lista adott indexű elemének lekérése
                input.remove(i);                //adott indexű elem törlése
            }
        }
    }

    public static void removeOddsWithIterator(List<Integer> input) {
        Iterator<Integer> it = input.iterator();        //lista iterátorának lekérése
        while (it.hasNext()) {      //ameddig van nem vizsgált elem
            int element = it.next();        //lekérjük a következő nem vizsgált elemet
            if (element % 2 == 1) {
                it.remove();        //az éppen mutatott elemet töröljük
            }
        }
    }

    public static void removeNegativeNumbers(Set<Integer> input) {
        Iterator<Integer> it = input.iterator();
        while (it.hasNext()) {
            int element = it.next();
            if (element < 0) {
                it.remove();
            }
        }
        System.out.println(input);
    }

    public static void printMapWithForeach(Map<Integer, String> input) {
        for (Map.Entry<Integer, String> element : input.entrySet()) {
            System.out.println(element);
        }
    }

    public static void printMapWithIterator(Map<Integer, String> input) {
        Iterator it = input.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> element = (Map.Entry<Integer, String>) it.next();
            System.out.println(element.getKey() + " " + element.getValue());
        }
    }
}
