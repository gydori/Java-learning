public class AnonymClass {
    void show() {
        System.out.println("AnonymShow");
    }
}

class Demo {
    AnonymClass ac = new AnonymClass() {        //új osztály az AnonymClass alapján
        void show() {                           //Amiben felülírjuk az eredeti show függvényt
            super.show();
            System.out.println("Ez egy új class");
        }
    };

    public void testAnonym() {
        ac.show();
    }
}