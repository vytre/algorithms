package EksamenPrep.SecondTry.h2020;

import eksamenPrep.secondTry.h2020.Ex01;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex01Test {

    @Test
    public void test1(){
        Ex01 ex01 = new Ex01();

        String regexString = ex01.regexA();

        assertEquals("Is this an out of season april fools joke?",regexString);
        assertTrue("Is this an out of season april fools joke?".matches(regexString));
    }

}