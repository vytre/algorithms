package eksamenPrep.SecondTry.h2021;


import org.pg4200.les05.MyMap;
import org.pg4200.les05.MyMapBinarySearchTree;

import java.util.Objects;

public class Ex02 {


    public static class StudentMap<K extends Comparable<K>, V> implements MyMap<K, V> {


        public MyTree<K,V>[] myTree = new MyTree[10];

        public StudentMap() {
            for (int i = 0; i < 10; i++) {
                myTree[i] = new MyTree<>();
            }
        }


        @Override
        public void put(K key, V value) {
            String myString = key.toString();
            int myInt = Integer.parseInt(myString);


            myTree[myInt].put(key,value);
        }


        @Override
        public void delete(K key) {
            String myString = key.toString();
            int myInt = Integer.parseInt(myString);
            myTree[myInt].delete(key);
        }

        @Override
        public V get(K key) {
            String myString = key.toString();
            int myInt = Integer.parseInt(myString);
           return myTree[myInt].get(key);
        }

        @Override
        public int size() {
            return 22;
        }


        public static class MyTree<K extends Comparable<K>, V> {


            protected class Node {
                public K key;
                public V value;
                public Node left;
                public Node right;
            }
            protected Node root;
            protected int size;

            public void put(K key, V value) {
                Objects.requireNonNull(key);
                root = put(key, value, root);
            }

            private Node put(K key, V value, Node node) {
                if (node == null) {
                    Node newNode = new Node();
                    newNode.key = key;
                    newNode.value = value;
                    size++;
                    return newNode;
                }

                int cmp = key.compareTo(node.key);

                if (cmp < 0) {
                    node.left = put(key, value, node.left);
                    return node;
                }

                if (cmp > 0) {
                    node.right = put(key, value, node.right);
                    return node;
                }

                assert cmp == 0;
                node.value = value;

                return node;
            }


            private void delete(K key){
                Objects.requireNonNull(key);
                root = delete(key, root);
            }

            protected Node delete(K key, Node node) {

                if (node == null) {

                    return null;
                }

                int cmp = key.compareTo(node.key);

                if (cmp < 0) {
                    node.left = delete(key, node.left);
                    return node;
                }

                if (cmp > 0) {
                    node.right = delete(key, node.right);
                    return node;
                }


                assert cmp == 0;

                size--;


                if (node.left == null) {
                    return node.right;
                }

                if (node.right == null) {
                    return node.left;
                }

        /*
            Both children are present
         */
                assert node.left != null && node.right != null;

                Node tmp = node;
                node = min(tmp.right);
                node.right = deleteMin(tmp.right);
                node.left = tmp.left;

                return node;
            }

            private Node min(Node subtreeRoot) {
                if (subtreeRoot.left == null) {
                    return subtreeRoot;
                }
                return min(subtreeRoot.left);
            }

            private Node deleteMin(Node subtreeRoot) {

                if (subtreeRoot.left == null) {
                    return subtreeRoot.right;
                }

                subtreeRoot.left = deleteMin(subtreeRoot.left);

                return subtreeRoot;
            }


            private V get(K key){
                Objects.requireNonNull(key);
                return get(key, root);
            }
            private V get(K key, Node subtreeRoot) {

                if (subtreeRoot == null) {
                    return null;
                }

                int cmp = key.compareTo(subtreeRoot.key);

                if (cmp == 0) {
                    return subtreeRoot.value;
                } else if (cmp > 0) {
                    //look at greater values in the right subtree
                    return get(key, subtreeRoot.right);
                } else if (cmp < 0) {
                    //look at smaller values in the left subtree
                    return get(key, subtreeRoot.left);
                }
                return null;
            }
        }
    }
}
