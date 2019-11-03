public class InterfaceClass {
    public void createNyavog() {
        Nyavog ny = new Nyavog() {
            public void nyav() {           // készítettünk egy anonymus classt, mely implementálja az interfacet
                System.out.println("Meow");
            }
        };
        ny.nyav();
    }

    interface Nyavog {
        void nyav();
    }

}
