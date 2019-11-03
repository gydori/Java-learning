public class Main {
    public static void main(String[] args) {
        System.out.println("asdadas");

        Polos p = new Polos();
        Polos.InnerPolos ip = p.getInner();
        System.out.println(ip.num2);
        Demo d = new Demo();
        d.testAnonym();
    }
}
