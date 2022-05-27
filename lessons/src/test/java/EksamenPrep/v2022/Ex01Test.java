package EksamenPrep.v2022;


import eksamenPrep.FirstTry.v2022.Ex01;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex01Test {


    @Test
    public void testTaskA(){
        // En måte å gjøre det på, safe måte
        Ex01 ex01 = new Ex01();

        String myString = ex01.regExA();

        assertFalse("".matches(myString));
        assertFalse("Exercise no5:\nFile: Ex05.txt".matches(myString));
        assertFalse("Exercise 5: File: Ex05.txt".matches(myString));
        assertFalse("Exercise 5:\nFile: Ex05.pdf".matches(myString));
        assertFalse("Exercise 5:\nFile: Ex05".matches(myString));
        assertFalse("Exercise 5:\nFile: Ex_something05.txt".matches(myString));
        assertFalse("Blorpblo 5:\nHunh: Ex05.java".matches(myString));

        assertTrue("Exercise 5:\nFile: Ex5.java".matches(myString));
        assertTrue("Exercise 5:\nFile: Ex05.txt".matches(myString));
        assertTrue("Exercise 3:\nFile: Ex03.java".matches(myString));
        assertTrue("Exercise 13:\nFile: Ex13.java".matches(myString));
        assertTrue("Exercise 42:\nFile: Ex42.txt".matches(myString));

    }

    @Test
    public void testTaskB(){
        Ex01 ex01 = new Ex01();
        String myString = ex01.regExB();

        assertFalse("".matches(myString));
        assertFalse("@Sven: Why do we need the exercises?".matches(myString));
        assertFalse("@Bogdan: Exercises will be useful in understanding the topic better.".matches(myString));
        assertFalse("@Bogdan - advises that you do all the exercises".matches(myString));
        assertFalse("@Sven: Have you asked @Bogdan about this?".matches(myString));

        assertTrue("@Bogdan: Has everyone completed all exercises?".matches(myString));
        assertTrue("@Bogdan: Are there any additional questions?".matches(myString));
        assertTrue("@Bogdan: Where can I find the solutions for this exercise?".matches(myString));
    }
}