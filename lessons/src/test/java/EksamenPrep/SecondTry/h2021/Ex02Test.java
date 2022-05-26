package EksamenPrep.SecondTry.h2021;

import eksamenPrep.SecondTry.h2021.Ex02;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex02Test {


    @Test
    public void test1(){

        Ex02.StudentMap<Integer,String> myMap = new Ex02.StudentMap<>();


        myMap.put(2,"neg");
        myMap.put(3,"neg");
        myMap.put(4,"vegard123");
        myMap.put(5,"neg");

        assertEquals(4,myMap.size());
        String s = myMap.get(4);
        assertTrue(s.matches("vegard123"));



    }

}