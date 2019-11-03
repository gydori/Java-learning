package Employer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Use {
    public static void main(String[] args) {
        Employer emp1 = new Employer("dolgozó1", 30);
        Employer emp2 = new Employer("dolgozó2", 35);
        Employer emp3 = new Employer("dolgozó3", 40);
        List<Employer> list = new ArrayList<Employer>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        WorkPlace wp = new WorkPlace(list);
        System.out.println(wp);
        list.remove(0);
        System.out.println(wp);

        try {
            FileOutputStream fout = new FileOutputStream("workplace.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(wp);

            FileInputStream fin = new FileInputStream("workplace.txt");
            ObjectInputStream ois = new ObjectInputStream(fin);
            WorkPlace wp2 = (WorkPlace) ois.readObject();
            System.out.println(wp2);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
