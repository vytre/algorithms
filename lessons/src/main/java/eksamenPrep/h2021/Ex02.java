package eksamenPrep.h2021;

import org.pg4200.les05.MyMap;
import org.pg4200.les05.MyMapBinarySearchTree;

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
            Objects.requireNonNull(key);
            root = delete(key, root);

        }

        protected Node delete(K key, Node root){
            if (root == null) {
                return null;
            }

            int cmp = key.compareTo(root.key);

            if (cmp < 0) {
                root.left = delete(key, root.left);
                return root;
            }

            if (cmp > 0) {
                root.right = delete(key, root.right);
                return root;
            }


            assert cmp == 0;

            size--;

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            assert root.left != null && root.right != null;

            Node tmp = root;
            root = min(tmp.right);
            root.right = deleteMin(tmp.right);
            root.left = tmp.left;

            return root;
        }

        private Node min(Node root) {
            if (root.left == null) {
                return root;
            }
            return min(root.left);
        }

        private Node deleteMin(Node root) {

            if (root.left == null) {
                return root.right;
            }

            root.left = deleteMin(root.left);

            return root;
        }


        @Override
        public V get(K key) {
            Objects.requireNonNull(key);
            return get(key, root);
        }

        private V get(K key, Node root) {

            if (root == null) {
                return null;
            }

            int cmp = key.compareTo(root.key);

            if (cmp == 0) {
                return root.value;
            } else if (cmp > 0) {
                //look at greater values in the right subtree
                return get(key, root.right);
            } else if (cmp < 0) {
                //look at smaller values in the left subtree
                return get(key, root.left);
            }

            return null;
        }

        @Override
        public int size() {
            return size;
        }

    }
}
