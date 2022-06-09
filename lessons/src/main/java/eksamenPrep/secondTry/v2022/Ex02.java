package eksamenPrep.secondTry.v2022;

import java.util.ArrayList;
import java.util.Objects;

public class Ex02 {

    public static class InitiativeHandler implements InitiativeTemplate{


        public binaryTree<Integer,Character>[] myTree = new binaryTree[3];

        public InitiativeHandler() {
            for (int i = 0; i < 3; i++) {
                myTree[i] = new binaryTree<>();
            }
        }

        @Override
        public void addCharacter(Character character) {
            int myInt = character.getInitiativeRoll();

            switch (character.initiativeRating){
                case FAST:
                    myTree[0].put(myInt,character);
                    break;
                case MEDIUM:
                    myTree[1].put(myInt,character);
                    break;
                case SLOW:
                    myTree[2].put(myInt,character);
                    break;
                default:
                    System.out.println("Error");
            }
        }

        @Override
        public boolean removeCharacter(int characterInitiative) {

            for (binaryTree<Integer, Character> tree :
                    myTree) {
                tree.delete(characterInitiative);
            }
            // Should return true if delete false if not
            return true;
        }

        @Override
        public ArrayList<Character> getInitiativeOrder() {
            ArrayList<Character> characters = new ArrayList<>();

            for (binaryTree<Integer, Character> tree:
                 myTree) {
                int myInt = tree.size;
                for (int i = 0; i < myInt; i++) {
                    Character myChar = tree.get(i);
                    characters.add(myChar);
                }
            }
            return characters;
        }
    }




    public enum Initiative{
        FAST, MEDIUM, SLOW
    }

    public static class Character{
        private Initiative initiativeRating;
        private int id;
        private int initiativeRoll;

        public Character(Initiative initiativeRating, int id, int initiativeRoll) {
            this.initiativeRating = initiativeRating;
            this.id = id;
            this.initiativeRoll = initiativeRoll;
        }

        public int getInitiativeRoll() {
            return initiativeRoll;
        }
    }

    public static class binaryTree<K extends Comparable<K>, V> {

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
