public class Main {
    public static void main(String[] args) {
        String a = "fsasad";
        String b = new String("bármi");
        char[] ch = {'a', 'b', 'c'};
        String c = new String(ch); //karaktertömbből String
        char[] back = c.toCharArray();  //String ->char[]
        c += "kiscica";     //String bővítése - ilyenkor új string jön létre, a régit a garbage collector elviszi
        //System.out.println(c + " " + countLetter('i', c));
        String input = "Feri; 29; Szeged";
        String arr[] = input.split(";");    //String darabolása reguláris kifejezés alapján
        //int age = Integer.parseInt(arr[1]);
        //compareStrings();
        System.out.println(compareTo("alma", "almaaa"));
        StringBuilder sb = new StringBuilder("asda");
        sb.append("ads");
        sb.toString();
        //appendTest();
        //arrayTest(new int[]{1, 2, 3, 4});
        /*try {
            throwException(0);          //A függvényhívás helyén kezeljük le a kivételt
        } catch (ArithmeticException e) {
            System.out.println("ne ossz 0-val!");
        }*/
        try {
            customCicaString("kiscica");
        } catch (KiscicaException e) {
            e.printStackTrace();
        }

    }

    public static int countLetter(char letter, String s) {
        int out = 0;
        for (int i = 0; i < s.length(); i++) {      //String hossza: .length()
            if (s.charAt(i) == letter) out++;       //Adott indexen lévő character: string.charAt(i)
        }
        return out;
    }

    public static void compareStrings() {
        String a = "a";
        String b = new String("b");
        if (a == b) {           //ilyet ne!
            System.out.println("Equal==");
        }
        if (a.equals(b)) {          //ilyet igen!
            System.out.println("Equal");
        }
        if (a.compareTo(b) == 0) {
            System.out.println("EqualCompared");
        }
        System.out.println(a.compareTo(b));     // 0-megegyeznek, -1 - a második a nagyobb, 1-az első a nagyobb alfabetikusan
    }

    /*Készítsünk egy compareTo függvényt, mely 2 Stringet vár paraméterül
      és karakterenként összehasonlítja őket. Ha az adott karakter nagyobb,
      mint a másik String ugyanazon indexű karaktere, térjen vissza 1 értékkel.
      Ha a másik String adott karaktere nagyobb, -1 értékkel, ha nem volt sehol
      eltérés, akkor 0-val!*/

    public static int compareTo(String s1, String s2) {
        int size = (s1.length() > s2.length()) ? s2.length() : s1.length();
        int result = 0;
        for (int i = 0; i < size; i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                result = -1;
                break;
            }
            if (s1.charAt(i) > s2.charAt(i)) {
                result = 1;
                break;
            }
        }
        if (result == 0 && s1.length() != s2.length()) {
            result = s1.length() - s2.length();
        }
        return result;
    }

    /*
    public static int comparTo(String a, String b){
    for(int i = 0; i<Math.min(a.length(), b.length()); i++){
        if(a.charAt(i) > b.charAt(i)){
            return 1;
        }else if (a.charAt(i) < b.charAt(i)){
            return -1;
        }
    }
    return a.length()-b.length();
    }
     */

    public static void appendTest() {
        long before = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 100000; i++) {
            s += 'a';
        }
        long after = System.currentTimeMillis();
        System.out.println("+=diff: " + (after - before));

        before = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append('a');
        }
        after = System.currentTimeMillis();
        System.out.println("builder diff: " + (after - before));
    }

    public static void arrayTest(int[] arr) {
        try {       //try blokkba kerül az a kód, amitől kivételt várhatunk
            for (int i = 0; i <= arr.length; i++) {
                System.out.println(arr[i]);
            }
            System.out.println("cica");
        } catch (ArrayIndexOutOfBoundsException e) {        //megadjuk, hogy milyen kivételt várunk
            System.out.println("Ez így nem volt jó ötlet.");    //ha kivétel következett be, akkor ez a kódblokk fut le
        } catch (Exception e) {        //az Exception mindent elkap, több catch blokk is lehetséges
            System.out.println("Valami más hiba");
        } finally {             //mindenképp lefut, nem kötelező
            System.out.println("vége");
        }
        System.out.println("Függvény vége");
    }

    public static void throwException(int div) throws ArithmeticException {     //Nem a függvényben kezeljük le a kivételt, hanem visszaadjuk a hívó félnek
        int b = 10 / div;
        System.out.println(b);
    }

    public static void customCicaString(String s) throws KiscicaException {
        if (s.contains("cica")) {
            throw new KiscicaException("Találtam cicát");
        } else {
            System.out.println(s);
        }
    }
}
