import searchtree.BinarySearchTree;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        /*Garage g = new Garage(52, "Rókusi", true, new Car("Feri", 90));
        System.out.println(g);
        try {
            FileOutputStream fs = new FileOutputStream("garage.ser");
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("garage.ser"));
            out.writeObject(g);
            out.close();
            fs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Garage g2;

        try {
            FileInputStream fileIn = new FileInputStream("garage.ser");
            ObjectInputStream oi = new ObjectInputStream(fileIn);
            g2 = (Garage) oi.readObject();
            System.out.println(g2);
            oi.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        BinarySearchTree bst = new BinarySearchTree();
        bst.insertNode(15);
        bst.insertNode(10);
        bst.insertNode(20);

        System.out.println(bst.search(bst.root, 20));
        System.out.println(bst.search(bst.root, 30));
        bst.inorderTreeWalk(bst.root);

        bst.deleteRec(bst.root, 10);

        System.out.println(bst.search(bst.root, 20));
        System.out.println(bst.search(bst.root, 15));
        System.out.println(bst.search(bst.root, 10));
        System.out.println(bst.search(bst.root, 25));

        var szo = "Szo";        //lokális változó - arra jó, hogy nem kell kírni a változó létrehozásánál a típust
        // Mindig inicializálni kell, a típusa az inicializált érték alapján dől el
        try {
            var os = new ObjectOutputStream(new FileOutputStream("cica.tyt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
