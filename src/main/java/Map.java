public class Map<K extends Comparable<K>, V> implements MapInterface<K, V> {
    private Node<K, V> root = null;

    @Override
    public void setValue(K key, V value) {
        root = insert(key, value, root);
        root.makeBlack();
    }

    @Override
    public V getValue(K key) {
        return findKey(key, root);
    }

    public Node<K, V> insert(K key, V value, Node<K, V> currentNode) {

        if (currentNode == null) return new Node<>(key, value);
        else if (key.compareTo(currentNode.getKey()) < 0)
            currentNode.setLeftChild(insert(key, value, currentNode.getLeftChild()));
        else if (key.compareTo(currentNode.getKey()) > 0)
            currentNode.setRightChild(insert(key, value, currentNode.getRightChild()));
        else {
            currentNode.setValue(value);
            return currentNode;
        }

        if (isNodeRed(currentNode.getRightChild()) && isNodeBlack(currentNode.getLeftChild())) {
            currentNode = rotateLeft(currentNode);
            currentNode.swapColors(currentNode.getLeftChild());
        }

        if (isNodeRed(currentNode.getLeftChild()) && isNodeRed(currentNode.getLeftChild().getLeftChild())) {
            currentNode = rotateRight(currentNode);
            currentNode.swapColors(currentNode.getRightChild());
        }

        if (isNodeRed(currentNode.getLeftChild()) && isNodeRed(currentNode.getRightChild())) {
            currentNode.invertColor();

            currentNode.getLeftChild().makeBlack();
            currentNode.getRightChild().makeBlack();
        }

        return currentNode;
    }

    public V findKey(K key, Node<K, V> currentNode) {
        if (currentNode == null) throw new KeyNotFound();
        else if (key.compareTo(currentNode.getKey()) == 0) return currentNode.getValue();
        else if (key.compareTo(currentNode.getKey()) < 0) return findKey(key, currentNode.getLeftChild());
        else return findKey(key, currentNode.getRightChild());
    }

    private Node<K, V> rotateRight(Node<K, V> Q) {
        Node<K, V> P = Q.getLeftChild();
        Q.setLeftChild(P.getRightChild());
        P.setRightChild(Q);
        return P;
    }

    private Node<K, V> rotateLeft(Node<K, V> P) {
        Node<K, V> Q = P.getRightChild();
        P.setRightChild(Q.getLeftChild());
        Q.setLeftChild(P);
        return Q;
    }

    private boolean isNodeRed(Node<K, V> currentNode) {
        if (currentNode == null) return false;
        else return currentNode.isRed();
    }

    private boolean isNodeBlack(Node<K, V> currentNode) {
        if (currentNode == null) return true;
        else return !currentNode.isRed();
    }
}
