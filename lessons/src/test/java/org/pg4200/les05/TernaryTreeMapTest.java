package org.pg4200.les05;

public class TernaryTreeMapTest extends MyMapTestTemplate{
    @Override
    protected <K extends Comparable<K>, V> MyMap<K, V> getInstance() {
        return new TernaryTreeMap<>();
    }
}
