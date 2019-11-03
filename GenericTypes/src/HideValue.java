public class HideValue<E /*extends Number*/> {
    private E value;

    public HideValue(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HideValue{" +
                "value=" + value +
                '}';
    }
}
