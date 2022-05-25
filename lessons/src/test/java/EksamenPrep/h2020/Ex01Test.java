package EksamenPrep.h2020;

import eksamenPrep.h2020.Ex01;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex01Test {

    @Test
    public void test1(){
        Ex01 ex01 = new Ex01();
        assertEquals("is this an out of season april fools joke",ex01.regEx());
    }

    @Test
    public void testSpace(){
        Ex01 ex01 = new Ex01();
        assertEquals("test",ex01.regEx());
    }


    @Test
    public void test2(){
        Ex01 ex01 = new Ex01();
        assertEquals("is",ex01.regEx());
    }
}