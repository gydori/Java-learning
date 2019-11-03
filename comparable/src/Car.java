public class Car implements Comparable<Car> {

    private int horsepower;
    private int ccm;

    public Car(int horsepower, int ccm) {
        this.horsepower = horsepower;
        this.ccm = ccm;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getCcm() {
        return ccm;
    }

    @Override
    public String toString() {
        return "Car{" +
                "horsepower=" + horsepower +
                ", ccm=" + ccm +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        int myPower = this.horsepower * this.ccm;
        int paramPower = o.horsepower * o.ccm;
        if (myPower > paramPower) return 1;
        if (myPower == paramPower) return 0;
        return -1;
    }
}
