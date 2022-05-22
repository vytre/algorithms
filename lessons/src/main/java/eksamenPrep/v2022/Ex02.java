package eksamenPrep.v2022;

import org.pg4200.les05.MyMap;

import java.util.ArrayList;
import java.util.Objects;

public class Ex02 {
    public static class InitiativeHandler<K extends Comparable<K>,V> implements InitiativeTemplate, MyMap<K,V> {



        myTree<K,V> slowTree = new myTree<>();
        myTree<K,V> mediumTree = new myTree<>();
        myTree<K,V> fastTree = new myTree<>();

        // Interface Methods
        @Override
        public void addCharacter(Character character) {
            Initiative initiativeRating = character.initiativeRating;
            switch (initiativeRating){
                case FAST:
                    
                    break;
                case MEDIUM:
                    break;
                case SLOW:
                    break;
                default:
                    System.out.println("Rating not found");
                    break;
            }
        }

        @Override
        public boolean removeCharacter(int characterInitiative) {
            return false;
        }

        @Override
        public ArrayList<Character> getInitiativeOrder() {
            return null;
        }


        // MyMap Methods
        @Override
        public void put(K key, V value) {

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
            return 0;
        }


        // Character Class
        public static class Character {
            private Initiative initiativeRating;
            private int id;
            private int initiativeRoll;

            public int getInitiativeRoll() {
                return initiativeRoll;
            }

            public int rollInitiative() {
                int roll = (int) Math.floor(Math.random() * 20 + 1);
                initiativeRoll = roll * 10000 + id;
                return initiativeRoll;
            }

        }


        // Enum
        enum Initiative {
            FAST, MEDIUM, SLOW
        }


        // Binary Tree

        public static class myTree<K extends Comparable<K>, V> {
            protected class Node {
                public K key;
                public V value;

                public Node right;
                public Node left;
            }

            private Node root;
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
