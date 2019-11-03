public class Verem<E> {
    private int pointer;
    private int size;
    private E[] arr;

    public Verem(int size) {
        this.size = size;
        this.arr = (E[]) new Object[this.size];
        this.pointer = 0;
    }

    public void push(E value) throws OverflowException {
        if (pointer > this.size - 1) {
            throw new OverflowException("Túlcsordulás!!");
        } else {
            arr[pointer] = value;
            pointer++;
        }
    }

    public E pop() throws UnderflowException {
        pointer--;
        if (pointer < 0) {
            throw new UnderflowException("Alulcsordulás!!");
        } else {
            E result = arr[pointer];
            arr[pointer] = null;
            return result;
        }
    }

    public E peek() throws UnderflowException {
        pointer--;
        if (pointer < 0) {
            throw new UnderflowException("Alulcsordulás!!");
        } else {
            return arr[pointer];
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Stack: [ ");
        for (int i = 0; i < this.size; i++) {
            sb.append(arr[i]);
            sb.append(' ');
        }
        sb.append(']');
        return sb.toString();
    }
}
