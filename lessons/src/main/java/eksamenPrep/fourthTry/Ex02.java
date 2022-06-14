package eksamenPrep.fourthTry;

import org.pg4200.les05.MyMap;
import org.pg4200.les05.MyMapTreeBased;

public class Ex02 {



    public static class StudentMap<K extends Comparable<K>,V> implements MyMap<K,V> {

        public MyTree<K,V>[] myTrees = new MyTree[10];

        public StudentMap() {
            for (int i = 0; i < 10; i++) {
                myTrees[i] = new MyTree<>();
            }
        }



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


        public static class MyTree<K extends Comparable<K>,V>{

        }

    }
}
