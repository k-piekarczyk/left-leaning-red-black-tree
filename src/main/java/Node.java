public class Node<K extends Comparable<K>, V> {
    private K key;
    private V value;
    private boolean isRed = true;
    private Node leftChild = null;
    private Node rightChild = null;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public boolean isRed() {
        return isRed;
    }

    public void switchColor() {
        isRed = !isRed;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
