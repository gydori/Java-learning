public class Polos {

    int num = 1;

    private int count() {
        class MethodInner {                 //Method local inner class
            public void sayHello() {
                System.out.println("hello");
            }
        }
        MethodInner mi = new MethodInner();
        mi.sayHello();
        return 100;
    }

    public InnerPolos getInner() {      //inner class
        InnerPolos ip = new InnerPolos(100);
        return ip;
    }

    class InnerPolos {
        int num2;

        public InnerPolos(int num2) {
            this.num2 = num2;
            System.out.println(num);        //elérjük a külső osztály adatait
            count();                        //valamint metódusait is
        }
    }

}

class Poloska {     //másik osztály ugyanazon a fájlban. Más fájlokból elérjük, ha egy csomagban vannak.

}
