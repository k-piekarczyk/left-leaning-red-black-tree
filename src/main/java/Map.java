public class Map<K extends Comparable<K>, V> implements MapInterface<K, V> {

    private LeftLeaningRBTree<K, V> tree = new LeftLeaningRBTree<>();

    public void setValue(K key, V value) {

    }

    public V getValue(K key) {
        return null;
    }
}
