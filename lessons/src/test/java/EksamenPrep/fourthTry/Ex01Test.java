package EksamenPrep.fourthTry;

import eksamenPrep.fourthTry.Ex01;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex01Test {

    @Test
    public void vegardTestA(){
        Ex01 ex01 = new Ex01();
        String regexStringMethodA = ex01.regexA();

        assertTrue("pg4200_00000.zip".matches(regexStringMethodA));
        assertTrue("pg4200_12345.zip".matches(regexStringMethodA));

        assertFalse("pg4201_00000.zip".matches(regexStringMethodA));
        assertFalse("pg4200_ab000.zip".matches(regexStringMethodA));
        assertFalse("pg4201_00000.rar".matches(regexStringMethodA));
        assertFalse("pg4200_ab000zip".matches(regexStringMethodA));
    }

    @Test
    public void vegardTestB(){
        Ex01 ex01 = new Ex01();
        String regexStringMethodB = ex01.regexB();

        assertTrue("I hate algdat man.".matches(regexStringMethodB));
        assertTrue("pg4200 is just so lame!".matches(regexStringMethodB));
        assertTrue("ALGDAT sucks, cant wait to be done with algorithms.".matches(regexStringMethodB));
        assertTrue("I hate ALGDAT MAN!".matches(regexStringMethodB));

        assertFalse("algdat sucks, cant wait to be done with algorithms".matches(regexStringMethodB));



    }

}