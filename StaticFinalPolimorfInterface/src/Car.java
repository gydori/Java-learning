public class Car extends Vehicle implements Sound, Go {      //interface implements - bármennyit interface-t implementálhatunk
    //alt+enter - implement methods

    public static int numberOfCars;        //static: osztály szinten létezik, teljes futásidő alatt 1 konkrét változó
    private int wheels;                    // objektum szinten létezik, minden objektumra más

    public Car(String type, int year, int wheels) {
        super(type, year);
        this.wheels = wheels;
        numberOfCars++;                 //Konstruktor is objektumhoz tartozik, de eléri az osztály szintű változót is és tudja módosítani
    }

    public static void printSomething() {    //osztály szintű függvény
        System.out.println("Something");
        //wheels++;                         -> osztályszintű függvény nem éri el az adattagokat, mert az adattagok minden objektumra mások, a függvényből viszont csak egy van
    }

    public int getNumberOfCars() {   //objektum szintű függvény - látja az osztály szintű véltozót is
        return numberOfCars;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void doSomething(int num) {
        System.out.println("Do something: " + num);
    }

    @Override
    public void saySomething() {
        System.out.println(BASIC);
        //BASIC = "asd";        -> nem definiálhatjuk felül, mert final, de használhatjuk
    }

    @Override
    public String horn() {
        return null;
    }

    @Override
    public void goSomewhere(int a, int b) {
        System.out.println("Go somewhere from " + a + " to " + b);
    }

/*    public String print() {   //final függvényt nem lehet felülírni
        return super.print() + " valami";
    }*/
}
