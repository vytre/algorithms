package org.pg4200.les05;

public class Main {
    public static void main(String[] args){
        BinaryTreeLeftMaxDelete<Integer, String> tree = new BinaryTreeLeftMaxDelete<>();

        tree.put(5,"a");
        tree.put(4,"a");
        tree.put(1,"a");
        tree.put(8,"a");
        tree.put(6,"a");
        tree.put(15,"a");

        tree.delete(5);


    }
}
