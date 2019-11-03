import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class MyArrayList<E> implements Iterable {
    private Node head = null; //legelső
    private Node tail = null; //legutolsó
    private Node actualNode = null;
    private int size = 0;

    public boolean isEmpty() {
        if (this.head == this.tail && this.tail == null) {
            return true;
        }
        return false;
    }

    public boolean isFirst() {
        if (this.actualNode == this.head) {
            return true;
        }
        return false;
    }

    public boolean isLast() {
        if (this.actualNode == this.tail) {
            return true;
        }
        return false;
    }

    public void stepBackward() {
        if (this.actualNode != null && !isFirst()) {
            this.actualNode = actualNode.previousNode;
        }
    }

    public void stepForeward() {
        if (this.actualNode != null && !isLast()) {
            this.actualNode = this.actualNode.nextNode;
        }
    }

    public void stepLast() {
        this.actualNode = this.tail;
    }

    public void stepFirst() {
        this.actualNode = this.head;
    }

    public void add(E value) {
        actualNode = new Node(value, tail, null);
        if (isEmpty()) {
            head = actualNode;
            tail = actualNode;
        } else {
            tail.nextNode = actualNode;
            tail = actualNode;
        }
    }

    public void add(int index, E value) {
        if (index > size) {
            System.out.println("Exception: index out of bound");
        } else if (index == size) {
            add(value);
        } else {
            stepFirst();
            while (actualNode.id < index) {
                stepForeward();
            }
            Node newNode = new Node(value, actualNode.previousNode, actualNode);
            newNode.id = index;
            actualNode.previousNode.nextNode = newNode;
            actualNode.previousNode = newNode;
            actualNode = newNode;
            for (int i = index; i < size - 1; i++) {
                stepForeward();
                actualNode.id++;
            }
        }
    }

    public E get(int index) {
        stepFirst();
        while (actualNode.id < index) {
            stepForeward();
        }
        return actualNode.value;
    }

    public void remove(int index) {
        if (index > size - 1) {
            System.out.println("Exception: index out of bound");
        } else if (index == size - 1) {
            tail.previousNode.nextNode = null;
            tail = actualNode;
        } else if (index == 0) {
            head.nextNode.previousNode = null;
            head = head.nextNode;
        } else {
            stepFirst();
            while (actualNode.id < index) {
                stepForeward();
            }
            actualNode.previousNode.nextNode = actualNode.nextNode;
            actualNode.nextNode.previousNode = actualNode.previousNode;
            for (int i = index; i < size - 1; i++) {
                stepForeward();
                actualNode.id--;
            }
        }
        size--;
    }

    public boolean contains(E searchValue) {
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

    public int size() {
        return size;
    }


    public String toString() {
        stepFirst();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (this.actualNode.nextNode != null) {
            sb.append(this.actualNode.value).append(" " + actualNode.id + " n:" + (actualNode.nextNode == null ? null : actualNode.nextNode.value) + " p:" + (actualNode.previousNode == null ? null : actualNode.previousNode.value)).append(", ");
            stepForeward();
        }
        sb.append(actualNode.value + " " + actualNode.id + " n:" + (actualNode.nextNode == null ? null : actualNode.nextNode.value) + " p:" + (actualNode.previousNode == null ? null : actualNode.previousNode.value));
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator iterator() {
        stepFirst();
        return new Iterator() {

            @Override
            public boolean hasNext() {
                return actualNode != null;
            }

            @Override
            public E next() {
                E data = actualNode.value;
                actualNode = actualNode.nextNode;
                return data;
            }
        };
    }

    @Override
    public void forEach(Consumer action) {
        Objects.requireNonNull(action);
        for (Object t : this) {
            action.accept(t);
        }
    }


    private class Node {

        E value;
        int id;
        Node previousNode = null;
        Node nextNode = null;


        public Node(E value, Node previousNode, Node nextNode) {
            this.id = size;
            size++;
            this.value = value;
            this.previousNode = previousNode;
            this.nextNode = nextNode;
        }

    }


}
