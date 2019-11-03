package searchtree;

public class Node {
    public int key;
    public Node left, right;

    public Node(int key) {
        this.key = key;
        left = right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
