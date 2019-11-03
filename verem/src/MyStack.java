import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
    private List<T> list;

    public MyStack() {
        this.list = new ArrayList<T>();
    }

    public void push(T value) {
        this.list.add(value);
    }

    public T pop() {
        if (list.size() > 0) {
            T pop = this.list.get(list.size() - 1);
            this.list.remove(list.size() - 1);
            return pop;
        } else {
            return null;
        }

    }

    public T peek() {
        if (list.size() > 0) {
            return this.list.get(list.size() - 1);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return this.list.toString();
    }
}
