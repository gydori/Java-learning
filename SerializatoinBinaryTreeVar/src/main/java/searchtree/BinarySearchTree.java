package searchtree;

public class BinarySearchTree {
    public Node root;

    public BinarySearchTree() {
        root = null;
    }

    public Node search(Node root, int key) {
        if (root == null || root.key == key) {    //ha nincs ilyen csúcs, vagy megtaláltuk a keresett elemet
            return root;
        }
        if (root.key > key) {        //Ha a keresett elem kisebb, a bal részfába megyünk tovább
            return search(root.left, key);
        }
        return search(root.right, key); //Ha a keresett elem nagyobb, akkor a jobb részfába megyünk tovább
    }

    public void insertNode(int key) {
        root = insertRec(root, key);
    }

    public Node insertRec(Node root, int key) {
        if (root == null) {       //Ha leértünk a fa aljára, készítünk egy új csúcsot
            root = new Node(key);
            return root;
        }
        if (root.key > key) {     //Ha a bal részfába megyünk, a bal gyereket frissítjük
            root.left = insertRec(root.left, key);
        } else if (root.key < key) {        //Ha a jobb részfába megyünk, a jobb gyereket frissítjük
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    public void inorderTreeWalk(Node root) {
        if (root != null) {
            inorderTreeWalk(root.left);
            System.out.print(root.key + " ");
            inorderTreeWalk(root.right);
        }
    }

    public Node deleteRec(Node root, int key) {
        if (root == null) return root;          //Ha nem találtuk meg a keresett elemet
        if (key < root.key) {                   //Ha a keresett elem a bal részfában lehet, keressük tovább
            root.left = deleteRec(root.left, key);
        } else if (key < root.key) {            //Ha a keresett elem nagyobb, akkor a jobb részfában keresünk
            root.right = deleteRec(root.right, key);
        } else {                                  //Megtaláltuk a törölni kívánt elemet
            if (root.left == null) {              //Ha nincs bal gyerek
                return root.right;              //Visszaadjuk a jobb gyereket(ha nincs, az sem baj, mert null íródik be)
            } else if (root.right == null) {
                return root.left;
            }
            root.key = successor(root.right);                //Successor -rákövetkezővel helyettesítünk
            root.right = deleteRec(root.right, root.key);        //Töröljük a rákövetkezőt a régi helyéről
        }
        return root;
    }

    private int successor(Node root) {
        int min = root.key;
        while (root.left != null) {
            min = root.left.key;
            root = root.left;
        }
        return min;
    }
}

