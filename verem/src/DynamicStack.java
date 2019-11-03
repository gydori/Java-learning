public class DynamicStack<T> {
    private Element top;

    public void push(T value) {
        Element newEl = new Element<T>(value, null);
        if (top != null) {
            newEl.setPrev(top);
        }
        top = newEl;
    }

    public T peek() {
        if (top == null) {
            return null;
        } else {
            return (T) top.getValue();
        }
    }

    public T pop() {
        if (top == null) {
            return null;
        } else {
            Element popEl = top;
            top = popEl.getPrev();
            return (T) popEl.getValue();
        }
    }

    public class Element<T> {
        private T value;
        private Element prev;

        public Element(T value, Element prev) {
            this.value = value;
            this.prev = prev;
        }

        public T getValue() {
            return value;
        }

        public Element getPrev() {
            return prev;
        }

        public void setPrev(Element prev) {
            this.prev = prev;
        }
    }
}
