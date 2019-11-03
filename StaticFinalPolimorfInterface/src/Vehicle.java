public abstract class Vehicle {
    private final String type;
    private int year;

    //final: -adattagra: konstanst csinál (közvetlenül a létrehozásakor, vagy a konstruktorban adhatunk neki értéket, nem változtatható meg.
    //       -metódusra: nem lehet felülírni
    //       -osztályra: nem lehet belőle leszármaztatni
    public Vehicle(String type, int year) {
        this.year = year;
        this.type = type;
    }

    public abstract void doSomething(int num);

    public String getType() {
        return this.type;
    }

/*    public void setType(String type) {
        this.type = type;
    }*/

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public final String print() {
        return "Vehicle: " + type + ", year: " + year;
    }
}
