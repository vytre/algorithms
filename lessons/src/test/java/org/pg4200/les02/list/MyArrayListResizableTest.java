package org.pg4200.les02.list;

public class MyArrayListResizableTest extends MyListTestTemplate{

    @Override
    protected <T> MyList<T> getNewInstance(Class<T> klass) {
        return new MyArrayListResizable<>();
    }
}
