import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        cell[][] arr1 = new cell[2][2];
        arr1[0][0] = cell.MINE;
        arr1[0][1] = cell.FIELD;
        arr1[1][0] = cell.MINE;
        arr1[1][1] = cell.FIELD;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                switch (arr1[i][j]) {
                    case MINE:
                        System.out.print("M");
                        break;
                    case FIELD:
                        System.out.print("F");
                        break;
                    case EMPTY_FIELD:
                        System.out.print(" ");
                        break;
                }
            }
            System.out.println();
        }

        System.out.println(Car.numberOfCars);   //példányosítás nélkül is lekérhetjük, mert static: osztálynév.változónév

        Car c5 = new Car("asd", 1284, 4);
        Car c2 = new Car("asd", 1284, 4);
        Car c3 = new Car("asd", 1284, 4);
        Car c4 = new Car("asd", 1284, 4);
        Car.printSomething();   //statikus függvény hívása: osztálynév.függvénynév - objektumra nem hívhatjuk meg

        System.out.println(Car.numberOfCars);

        //polimorfizmus: leszármazott osztály objektuma kezelhető ősosztály típusú objektumként is
        Audi a1 = new Audi("a5", 2010);
        Citroen c1 = new Citroen("i5", 2003);
        Car[] arr = new Car[2];     //Ős típusú tömbbe tesszük a leszármazott objektumokat - innentől kezdve csak az ősosztály dolgait érjük el
        arr[0] = a1;
        arr[1] = c1;
        //arr[0].audiSign();        -> nem érjük el, mert Car-ként kezeli őket
        if (arr[0] instanceof Audi) {     //instanceof: megvizsgálja, hogy az adott osztály objektuma-e (arr[0] egy Audi-e)
            System.out.println("AUDI");
            Audi at = (Audi) arr[0];   //típuskonverzió - ha tudjuk, hogy arr[0] egy audi, akkor az (Audi)-t eléírva újra audit csinálhatunk belőle
            at.audiSign();  //innentől kezdve hivatkozhatunk rá úgy, mint egy audira
            //((Audi)arr[0]).audiSign();  ->nem vesszük ki külön változóba, hanem rögtön metódust hívunk rá
        }
        List<Car> cars = new ArrayList<>();
        cars.add(a1); // ctrl+q - kidobja a függvény dokumentációját
        cars.add(c1);

        for (Car c : arr) {

        }

        //Ez ugyanaz, mint ez:
/*        for (int i = 0; i < arr.length; i++) {
            Car c = arr[i];
        }*/

    }

    enum cell {
        MINE,
        FIELD,
        EMPTY_FIELD
    }


}
