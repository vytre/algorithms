package eksamenPrep.h2021;

import org.pg4200.les05.MyMap;

import java.util.Objects;

public class Ex02 {
    public static class StudentMap<K extends Comparable<K>, V> implements MyMap<K, V> {

        protected class Node {
            public K key;
            public V value;

            public Node left;
            public Node right;
        }

        protected Node root;
        protected int size;


        @Override
        public void put(K key, V value) {
            Objects.requireNonNull(key);
            root = put(key, value, root);

        }

        private Node put(K key, V value, Node subtree) {

            if (subtree == null) {
                Node node = new Node();
                node.key = key;
                node.value = value;
                size++;
                return node;
            }

            int cmp = key.compareTo(subtree.key);

            if (cmp < 0) {
                subtree.left = put(key, value, subtree.left);
                return subtree;
            }

            if (cmp > 0) {
                subtree.right = put(key, value, subtree.right);
                return subtree;
            }

            assert cmp == 0;
            subtree.value = value;

            return subtree;
        }

        @Override
        public void delete(K key) {

        }

        @Override
        public V get(K key) {
            return null;
        }

        @Override
        public int size() {
            return size;
        }

    }
}
