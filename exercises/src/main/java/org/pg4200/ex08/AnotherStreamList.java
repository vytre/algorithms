package org.pg4200.ex08;

import org.pg4200.les08.iterator.MyIterableLinkedList;

public class AnotherStreamList<T> extends MyIterableLinkedList {
    public AnotherStream<T> stream(){
        return AnotherStreamSupport.createStream(this);
    }
}
