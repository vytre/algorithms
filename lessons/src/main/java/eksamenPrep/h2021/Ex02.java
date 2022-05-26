package eksamenPrep.h2021;

import org.pg4200.les05.MyMap;
import org.pg4200.les05.MyMapBinarySearchTree;

import java.util.Locale;
import java.util.Objects;

public class Ex02 {
    public static class StudentMap<K extends Comparable<K>, V> implements MyMap<K, V> {

        // Her starter Oppgaven basicly

        public StudentTree<K, V>[] myMap = new StudentTree[10];

        public StudentMap() {
            for (int i = 0; i < 10; i++) {
                myMap[i] = new StudentTree<>();
            }
        }

        /*public String getByName(String search_name){
            for (int i = 0; i < myMap.length; i++) {
               int myMapDepth = myMap[i].size;

               for (int j = 0; j < myMapDepth; j++) {
                    if (myMap[i].get(j).equals(search_name)){
                        System.out.println("Found " + search_name + "at Tree Nr: " + i);
                        return search_name;
                    }
                }
            }
            return null;
        }*/

        


        @Override
        public void put(K key, V value) {
            String keyString = key.toString();
            int keyInteger = Integer.parseInt(keyString);

            myMap[keyInteger].put(key,value);
        }


        @Override
        public void delete(K key) {
            String keyString = key.toString();
            int keyInteger = Integer.parseInt(keyString);

            myMap[keyInteger].delete(key);
        }


        @Override
        public V get(K key) {
            String keyString = key.toString();
            int keyInteger = Integer.parseInt(keyString);

            return myMap[keyInteger].get(key);
        }


        @Override
        public int size() {
            int mySize = 0;
            for (StudentTree<K,V> tree:
                 myMap) {
                mySize+= tree.size;
            }
            return mySize;
        }

        public static class StudentTree<K extends Comparable<K>, V> {

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


            private void delete(K key) {
                Objects.requireNonNull(key);
                root = delete(key, root);
            }

            protected Node delete(K key, Node root) {
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
        }
    }
}
