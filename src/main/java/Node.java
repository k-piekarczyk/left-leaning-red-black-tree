public class Node<K extends Comparable<K>, V> {
    private K key;
    private V value;
    private boolean isRed = true;
    private Node<K, V> leftChild = null;
    private Node<K, V> rightChild = null;

    Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public boolean isRed() {
        return isRed;
    }

    public void swapColors(Node<K, V> other) {
        boolean temp = this.isRed;
        this.isRed = other.isRed;
        other.isRed = temp;
    }

    public void invertColor() {
        isRed = !isRed;
    }

    public void makeBlack() {
        isRed = false;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K, V> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<K, V> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<K, V> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<K, V> rightChild) {
        this.rightChild = rightChild;
    }
}
