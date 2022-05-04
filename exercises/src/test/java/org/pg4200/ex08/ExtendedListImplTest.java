package org.pg4200.ex08;

public class ExtendedListImplTest extends ExtendedListTestTemplate{
    @Override
    protected <T> ExtendedList<T> getInstance(Class<T> klass) {
        return new ExtendedListImpl<>();
    }
}
