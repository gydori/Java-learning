public class MyLinkedList<T> {
    private Element first;
    private Element last;

    public void add(T value) {
        if (last == null) {
            last = new Element(value, null);
            first = new Element(value, null);
        } else {
            Element newElement = new Element(value, last);
            last.setNext(newElement);
            last = newElement;
        }
        System.out.println(last);
    }

    public T get(int index) {
        Element current = first;
        while (index > 0) {
            current = current.getNext();
            index--;
        }
        return (T) current.getValue();
    }

    public class Element<T> {
        private T value;
        private Element prev;
        private Element next;

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

        public Element getNext() {
            return this.next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "value=" + value +
                    ", prev=" + prev.getValue() +
                    ", next=" + next.getValue() +
                    '}';
        }
    }
}
