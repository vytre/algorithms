package EksamenPrep.SecondTry.v2022;

import eksamenPrep.SecondTry.v2022.Ex01s;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex01sTest {

   @Test
   public void test1(){
       Ex01s ex01s = new Ex01s();
       String myString = ex01s.regexA();
       String stringToMach = "Is this an out of season april fools joke?";


       assertTrue("Is this an out of season april fools joke?".matches(myString));
       assertTrue("Is this an out of season april fools joke!".matches(myString));

       assertFalse("Is this an out of season april fools joke.".matches(myString));

   }

    @Test
    public void test2(){
        Ex01s ex01s = new Ex01s();
        String myString = ex01s.regexB();
        String stringToMach = "Is this an out of season april fools joke?";


        //assertEquals("Is this an out of season april fools joke?",myString);
        assertTrue("Is this an out of season april fools joke?".matches(myString));
        assertTrue("iS THIS     AN oUT of sEason     APRIL FOOls joKe?".matches(myString));
        assertTrue("Is this an out of season april fools joke?".matches(myString));
        assertTrue("Is this an out of season april fools joke?".matches(myString));
        assertTrue("Is this an out of season april fools joke?".matches(myString));

        assertFalse("Is this an out of season april fools joke!".matches(myString));
        assertFalse("Is th is an out of season april fools joke?".matches(myString));
        assertFalse("i S THIS     AN oUT of sEason     APRIL FOOls joKe?".matches(myString));
    }

    @Test
    public void test3(){
       Ex01s ex01s = new Ex01s();
    }



}