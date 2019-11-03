import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //System.out.println(cezar("Gabi", 5));
        ecode("kjdkfjkdjfkdjfk", "cica");
        Integer[] nums = {8, 3, 7, 10, 5, 3, 8, 5, 9, 15, 8, 5, 9, 15, 8};
        List<Integer> code = Arrays.asList(nums);
        decode(code, "cica");
    }

    public static String cezar(String str, int x) {
        x = x % 26;

/*        List<Integer> strToCharCode = new ArrayList<>();                        // str átalakítása ASCII kóddá
        for (int i = 0; i < str.length(); i++) {
            strToCharCode.add(str.charAt(i));
        }*/

        List<Integer> strCezarCharCode = new ArrayList<>();                     // int-tel való eltolás az ASCII táblán
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {     // Nagybetűk
                if (str.charAt(i) + x > 'Z') {
                    strCezarCharCode.add(str.charAt(i) + x - 'Z' + 'A' - 1);
                } else {
                    strCezarCharCode.add(str.charAt(i) + x);
                }
            } else {                                                            // Kisbetűk
                if (str.charAt(i) + x > 'z') {
                    strCezarCharCode.add(str.charAt(i) + x - 'z' + 'a' - 1);
                } else {
                    strCezarCharCode.add(str.charAt(i) + x);
                }
            }
        }

/*        List<Character> strCezar = new ArrayList<>();                          // Visszaalakítás kódból stringgé
        for (int i = 0; i < strCezarCharCode.size(); i++) {
            strCezar.add(Character.toChars(strCezarCharCode.get(i))[0]);
        }*/

        String result = strCezarCharCode.stream().map(Character::toChars).map(String::valueOf).collect(Collectors.joining(""));
        return result;
    }

    public static void ecode(String str, String key) {
        List<Integer> code = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            code.add(str.charAt(i) ^ key.charAt(j));
            if (j == key.length() - 1) {
                j = 0;
            } else {
                j++;
            }
        }
        System.out.println(code);
    }

    public static void decode(List<Integer> code, String key) {
        int j = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < code.size(); i++) {
            str.append((char) (code.get(i) ^ key.charAt(j)));
            if (j == key.length() - 1) {
                j = 0;
            } else {
                j++;
            }
        }
        System.out.println(str);
    }

}
