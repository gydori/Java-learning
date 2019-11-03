public class NewLinkedList {
    //Head: referencia az elso elemre. null, ha üres a lista.
    private Node head = null;
    //Tail: referencia az utolsó elemre. null, ha üres a lista.
    private Node tail = null;
    private Node actualNode = null;

    //elöre-hátra mozgatható referencia, egy adott elemre a listában. Ha a lista üres akkor null az értéke
    //segítségével tudjuk a listában tárolt elemeket manipuláni: elérni, lekérdezni, megváltoztatni.
    private int size;

    /*
    head <- null
    tail <- null
    actualNode <- null
     */
    public NewLinkedList() {
        this.head = null;
        this.tail = null;
        this.actualNode = null;
    }

    //return Head==Tail==null
    public boolean isEmpty() {
        if (this.head == this.tail && this.tail == null) {
            return true;
        }
        return false;
    }

    //return actualNode == head
    public boolean isFirst() {
        if (this.actualNode == this.head) {
            return true;
        }
        return false;
    }

    //return actualNode == tail
    public boolean isLast() {
        if (this.actualNode == this.tail) {
            return true;
        }
        return false;
    }

    //HA actualNode !=null AKKOR return actualNode.value
    public int getActualValue() {
        if (this.actualNode != null) {
            return this.actualNode.value;
        }
        return -1;
    }

    //HA actualNode !=null AKKOR actualNode.value = value
    public void setActualNodeValue(int newValue) {
        if (this.actualNode != null) {
            this.actualNode.value = newValue;
        }
    }

    //HA actualNode !=null ÉS ¬isLast() AKKOR actualNode <- actualNode.prevoiusNode
    public void stepBackward() {
        if (this.actualNode != null && !isFirst()) {
            this.actualNode = actualNode.previousNode;
        }
    }

    //HA actualNode != null ÉS ¬isFirst() AKKOR actualNode <- actualNode.nextNode
    public void stepForeward() {
        if (this.actualNode != null && !isLast()) {
            this.actualNode = this.actualNode.nextNode;
        }
    }

    //actualNode <- tail
    public void stepLast() {
        this.actualNode = this.tail;
    }

    //actualNod <- Head
    public void stepFirst() {
        this.actualNode = this.head;
    }

    /*
    insertFirst(ertek)
        actualNode <- ujCsomopont <- ÚJ Node
        ujCsomopont.Ertek <- ertek
        ujCsomopont.Elozo <- null
        ujCsomopont.Kovetkezo <- Head
        HA isEmpty() AKKOR Head <- Tail <- ujCsomopont
        KÜLÖNBEN
        Head.Elozo <- ujCsomopont
        Head <- ujCsomopont
     */
    public void insertFirst(int value) {
        this.actualNode = new Node(value, null, this.head);
        if (isEmpty()) {
            this.head = this.actualNode;
            this.tail = this.actualNode;
        } else {
            this.head.previousNode = this.actualNode;
            this.head = this.actualNode;
        }
    }

    /*
    insertLast(ertek)
        HA isEmpty() AKKOR insertFirst(ertek)
        KÜLÖNBEN
        Akt <- ujCsomopont <- ÚJ Node
        ujCsomopont.Ertek <- ertek
        ujCsomopont.Elozo <- Tail
        ujCsomopont.Kovetkezo <- null
        Tail.Kovetkezo <- ujCsomopont
        Tail <- ujCsomopont
     */
    public void insertLast(int value) {
        if (isEmpty()) {
            insertFirst(value);
        } else {
            this.actualNode = new Node(value, this.tail, null);
            this.tail.nextNode = this.actualNode;
            this.tail = this.actualNode;
        }
    }

    /*
    insertBefore(ertek)
    HA isEmpty() VAGY isFirst() AKKOR insertFirst(ertek)
    KÜLÖNBEN
        ujCsomopont <- ÚJ Node
        ujCsomopont.Ertek <- ertek
        ujCsomopont.Elozo <- Akt.Elozo
        ujCsomopont.Kovetkezo <- Akt
        Akt.Elozo.Kovetkezo <- ujCsomopont
        Akt.Elozo <- ujCsomopont
        Akt <- ujCsomopont
     */
    //Aktualis elem ele valo beszuras
    public void insertBefore(int value) {
        if (isEmpty() || isFirst()) {
            insertFirst(value);
        } else {
            Node newNode = new Node(value, this.actualNode.previousNode, this.actualNode);
            this.actualNode.previousNode.nextNode = newNode;
            this.actualNode.previousNode = newNode;
            this.actualNode = newNode;
        }
    }

    /*
    insertAfter(ertek)
    HA isEmpty() VAGY isLast() AKKOR insertLast(ertek)
    KÜLÖNBEN
        stepForward()
        insertBefore(ertek)
    */
    //Aktualis elem utan valo beszuras
    public void insertAfter(int value) {
        if (isEmpty() || isLast()) {
            insertLast(value);
        } else {
            stepForeward();
            insertBefore(value);
        }
    }

    /*
    removeFirst()
    HA ¬isEmpty() AKKOR
        HA isFirst() AKKOR Akt <- Head.Kovetkezo
                           Head <- Head.Kovetkezo
        HA Head != null AKKOR Head.Elozo <- null
                        KÜLÖNBEN
                        Tail <- null
     */
    //Az elso elem torlese
    public void removeFirst() {
        if (!isEmpty()) {
            if (isFirst()) {
                this.actualNode = this.head.nextNode;
                this.head = this.head.nextNode;
            } else if (this.head != null) {
                this.head.previousNode = null;
            } else {
                this.tail = null;
            }
        }
    }

    /*
    removeLast()
    HA ¬isEmpty() AKKOR
        HA Tail==Head AKKOR removeFirst(); VÉGE
        HA isLast() AKKOR Akt <- Tail.Elozo
                                 Tail <- Tail.Elozo
                                 Tail.Kovetkezo <- null
     */
    //Az utolso elem torlese
    public void removeLast() {
        if (!isEmpty()) {
            if (this.tail == this.head) {
                removeFirst();
            } else if (isLast()) {
                this.actualNode = this.tail.previousNode;
                this.tail = this.tail.previousNode;
                this.tail.nextNode = null;
            }
        }
    }

    /*
    removeActual()
    HA ¬isEmpty() AKKOR
    HA isFirst() AKKOR removeFirst(); VÉGE
    HA isLast() AKKOR removeLast(); VÉGE
    Akt.Elozo.Kovektkezo <- Akt.Kovektezo
    Akt.Kovetkezo.Elozo <- Akt.Elozo
    Akt <- Akt.Kovetkezo
     */
    //actualis elem torlese
    public void removeActual() {
        if (!isEmpty()) {
            if (isFirst()) {
                removeFirst();
            } else if (isLast()) {
                removeLast();
            } else {
                this.actualNode.previousNode.nextNode = this.actualNode.nextNode;
                this.actualNode.nextNode.previousNode = this.actualNode.previousNode;
                this.actualNode = this.actualNode.nextNode;
            }
        }
    }

    public boolean contains(int searchValue) {
        stepFirst();
        while (this.actualNode.nextNode != null) {
            if (this.actualNode.value == searchValue) {
                return true;
            }
            stepForeward();
        }
        if (this.actualNode.value == searchValue) {
            return true;
        }
        return false;
    }

    public String toString() {
        stepFirst();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (this.actualNode.nextNode != null) {
            sb.append(this.actualNode.value).append(", ");
            stepForeward();
        }
        sb.append(actualNode.value);
        sb.append("]");
        return sb.toString();
    }

    private class Node {
        //a csomopont erteke
        int value;
        //a elozo nodra mutato referencia
        Node previousNode = null;
        //az kovetkezo nodra mutato referencia
        Node nextNode = null;


        public Node(int value, Node previousNode, Node nextNode) {
            this.value = value;
            this.previousNode = previousNode;
            this.nextNode = nextNode;
        }

    }
}
