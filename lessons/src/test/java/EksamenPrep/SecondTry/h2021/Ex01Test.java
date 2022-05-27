package EksamenPrep.SecondTry.h2021;

import eksamenPrep.SecondTry.h2021.Ex01;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex01Test {

    @Test
    public void test1(){
        Ex01 ex01 = new Ex01();

        String myString = ex01.regexA();

        assertTrue("pg4200_12345.zip".matches(myString));
        assertTrue("pg4200_00000.zip".matches(myString));


        assertFalse("pg4200_00000. zip".matches(myString));
        assertFalse("pg4201_12345.zip".matches(myString));
        assertFalse("pg4200_2322.zip".matches(myString));
        assertFalse("pg4200_12345.rar".matches(myString));
    }

    @Test
    public void test2(){
        Ex01 ex01 = new Ex01();
        String myString = ex01.regexB();



        assertTrue("algdat is bad!".matches(myString));
        assertTrue("Im thinking of doing some algdat later, but pg4200 is so hard.".matches(myString));
        assertTrue("Man idk im starting to hate algorithms!".matches(myString));
        assertTrue("algorithms!".matches(myString));


        assertFalse("This is bs!".matches(myString));
        assertFalse("This algdat is bs".matches(myString));




    }

}