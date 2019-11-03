import java.io.Serializable;

public class Garage implements Serializable {   //implementáljuk az interfészt, ami nem tartalmaz metódust
    private int sqmeter;
    private transient String name;  //transient-nem vesz részt a fájlba kiírási folyamatban
    private boolean isFull;
    private Car car;

    public Garage(int sqmeter, String name, boolean isFull, Car car) {
        this.sqmeter = sqmeter;
        this.name = name;
        this.isFull = isFull;
        this.car = car;
    }

    public int getSqmeter() {
        return sqmeter;
    }

    public void setSqmeter(int sqmeter) {
        this.sqmeter = sqmeter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "sqmeter=" + sqmeter +
                ", name='" + name + '\'' +
                ", isFull=" + isFull +
                '}';
    }
}
