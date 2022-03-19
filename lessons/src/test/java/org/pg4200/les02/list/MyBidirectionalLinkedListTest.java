package org.pg4200.les02.list;

public class MyBidirectionalLinkedListTest extends MyListTestTemplate{
    @Override
    protected <T> MyList<T> getNewInstance(Class<T> klass) {
        return new MyBidirectionalLinkedList<>();
    }
}
