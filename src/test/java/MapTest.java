import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @org.junit.jupiter.api.Test
    void setValue() {
        Map<Integer, Integer> map = new Map<>();

        // Check if nodes are distributed correctly [according to the algorithm]
        map.setValue(1, 7);
        map.setValue(2, 45);
        map.setValue(3, 97);
        map.setValue(4, 5);
        map.setValue(5, 34);

        Node root = map.getRoot();
        Node key2 = root.getLeftChild();
        Node key5 = root.getRightChild();
        Node key1 = key2.getLeftChild();
        Node key3 = key2.getRightChild();

        assertEquals(4, root.getKey());
        assertEquals(5, root.getValue());
        assertFalse(root.isRed());

        assertEquals(2, key2.getKey());
        assertEquals(45, key2.getValue());
        assertTrue(key2.isRed());

        assertEquals(5, key5.getKey());
        assertEquals(34, key5.getValue());
        assertFalse(key5.isRed());

        assertEquals(1, key1.getKey());
        assertEquals(7, key1.getValue());
        assertFalse(key1.isRed());

        assertEquals(3, key3.getKey());
        assertEquals(97, key3.getValue());
        assertFalse(key3.isRed());

        // Check if values change without further changes to the map structure
        map.setValue(3, 18);

        Node newKey3 = root.getLeftChild().getRightChild();
        assertEquals(3, newKey3.getKey());
        assertEquals(18, newKey3.getValue());
        assertFalse(newKey3.isRed());
    }

    @org.junit.jupiter.api.Test
    void getValue() {
        // Create a correct tree
        Node<Integer, Integer> root = new Node<>(4, 12, false);
        Node<Integer, Integer> key2 = new Node<>(2, 65, true);
        Node<Integer, Integer> key5 = new Node<>(5, 35, false);
        Node<Integer, Integer> key1 = new Node<>(1, 7, false);
        Node<Integer, Integer> key3 = new Node<>(3, 4, false);

        key2.setLeftChild(key1);
        key2.setRightChild(key3);
        root.setLeftChild(key2);
        root.setRightChild(key5);

        Map<Integer, Integer> map = new Map<>();
        map.setRoot(root);

        // Check if the data is retrieved correctly
        int val1 = map.getValue(1);
        int val2 = map.getValue(2);
        int val3 = map.getValue(3);
        int val4 = map.getValue(4);
        int val5 = map.getValue(5);

        assertEquals(7, val1);
        assertEquals(65, val2);
        assertEquals(4, val3);
        assertEquals(12, val4);
        assertEquals(35, val5);
    }
}