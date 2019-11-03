public class Main {

    public static void main(String[] args) {
        /*List<String> list = Arrays.asList("a", "b", "c");
        HideValue<String> val1 = new HideValue<>("Cica");
        System.out.println(val1);
        HideValue<Integer> val2 = new HideValue<>(200);
        System.out.println(val2);*/
        Verem<String> v = new Verem<>(3);
        try {
            v.push("valami");
            System.out.println(v);
            v.push("valami2");
            System.out.println(v);
            System.out.println(v.pop());
            System.out.println(v);
            System.out.println(v.peek());
        } catch (OverflowException e) {
            System.out.println(e);
        } catch (UnderflowException e) {
            System.out.println(e);
        }

        System.out.println(v);
    }
}
