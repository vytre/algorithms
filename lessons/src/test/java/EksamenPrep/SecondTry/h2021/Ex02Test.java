package EksamenPrep.SecondTry.h2021;

import eksamenPrep.SecondTry.h2021.Ex02;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex02Test {


    @Test
    public void test1(){

        Ex02.StudentMap<Integer,String> myMap = new Ex02.StudentMap<>();




        myMap.put(1,"Vegard");
        myMap.put(2,"Marius");
        myMap.put(3,"Sander");
        myMap.put(43321,"Fredrik");

        assertEquals(4,myMap.size());
        String s = myMap.get(3);
        assertTrue(s.matches("Sander"));

    }

}