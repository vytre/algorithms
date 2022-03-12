package org.pg4200.les02.generic;

import java.awt.*;

/**
 * The name chosen for the generic types does not really matter, but T (for "Type")
 * is a common choice.
 *
 * Here, the class is associated with a generic type T that I can use for
 * all of the methods
 *
 * Created by arcuri82 on 07-Jun-18.
 */
// Polymorphism uses those methods to perform different tasks. This allows us to perform a single action in different ways
public class GenericExample<T> {

    public Object identityObject(Object x){
        return x;
    }

    public T identityGeneric(T x){
        return x;
    }

    public static void main(String[] args) {

        // identityGeneric
        GenericExample <String> stringObjectExample = new GenericExample<>();
        String fooString = "foo";
        Object x = stringObjectExample.identityObject(fooString);
        System.out.println(x);
        String y = (String) stringObjectExample.identityObject(fooString);
        System.out.println(y);

        GenericExample <Integer> integerGenericExample = new GenericExample<>();
        Integer wrappedFoo = 4;
        int normalFoo = integerGenericExample.identityGeneric(wrappedFoo);
        System.out.println(normalFoo);

        GenericExample <String> stringGenericExample = new GenericExample<>();
        String stringFoo = "fooString";
        String normal = stringGenericExample.identityGeneric(stringFoo);
        System.out.println(normal);

        // identityGenericOnMethod



        boolean d = integerGenericExample.identityGenericOnMethod(2,false);
        System.out.println(d);



    }

    /*
        Besides declaring a generic type for the whole class, we can also have it
        explicitly on the methods.
        This is done by declaring them (eg, "<Z>") between the access-right keyword (eg, "public")
        and the return type of the function (eg, "Z").
     */
    public <Z> Z identityGenericOnMethod(T t, Z z){ // Dette er typisk remove and return value removed kanskje? eg. return the string at t index that has the String z, litt dumbt eksempel...
        return z;
    }

    /*
        Can define more than one generic type on same class
     */
    public static class MyPair<X,Y>{
        public final X x;
        public final Y y;

        public MyPair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }

    /*
        Here we create a MyPair object, where the element x
        has to have the same type bound to the generic in the
        class GenericExample, whereas y could be anything
     */
    public <Z> MyPair<T,Z> createPair(T t, Z z){

        //on right-side, I can use <> instead of repeating <T, Z>
        MyPair<T, Z> pair = new MyPair<>(t, z);

        return pair;
    }

    /*
        Interface Comparable is part of the JDK API, and it is used
        to specify if an object is smaller, equal or greater than
        another one.
        Many class in the JDK API do implement this interface.
     */
    public Comparable max(Comparable x, Comparable y){

        if(x.compareTo(y) > 0){ // Hvis X sammenlignet med Y er Større en 0, returner X
            return x;
        } else {
            return y; // Hvis X sammenlignet med Y er Mindre en 0, returner Y
        }
    }

    /*
        Returning a type Comparable is a problem, as we lose info of
        the original type (eg String).
        So, here we define a generic Z that does extend Comparable<Z>.
        This allows us to call compareTo() on Z objects, and then return
        Z as result (and not the interface Comparable)
     */
    public <Z extends Comparable<Z>>  Z  maxWithGenerics(Z x, Z y){

        if(x.compareTo(y) > 0){
            return x;
        } else {
            return y;
        }
    }

}
