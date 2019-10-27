public class LeftLeaningRBTree<K extends Comparable<K>, V> {
    private Node<K, V> root = null;

    public Node<K, V> insert(K key, V value, Node<K, V> currentNode) {

        if (currentNode == null) return new Node<>(key, value);
        else if (key.compareTo(currentNode.getKey()) < 0) insert(key, value, currentNode.getLeftChild());
        else if (key.compareTo(currentNode.getKey()) > 0) insert(key, value, currentNode.getRightChild());
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

    public V findKey(K key, Node<K, V> startPoint) {
        if (startPoint == null) throw new KeyNotFound();
        else if (key.compareTo(startPoint.getKey()) == 0) return startPoint.getValue();
        else if (key.compareTo(startPoint.getKey()) < 0) findKey(key, startPoint.getLeftChild());
        else if (key.compareTo(startPoint.getKey()) > 0) findKey(key, startPoint.getLeftChild());
        return null;
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
