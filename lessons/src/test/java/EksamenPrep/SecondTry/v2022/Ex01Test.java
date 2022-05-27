package EksamenPrep.SecondTry.v2022;

import eksamenPrep.SecondTry.v2022.Ex01;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex01Test {

    @Test
    public void test1(){
        Ex01 ex01 = new Ex01();

        String myString = ex01.regexA();


        assertTrue("Exercise 5:\nFile: Ex05.txt".matches(myString));
        assertTrue("Exercise 03:\nFile: Ex03.java".matches(myString));
        assertTrue("Exercise 15:\nFile: Ex13.java".matches(myString));
        assertTrue("Exercise 15:\nFile: Ex13.java".matches(myString));





        assertFalse("Exercise no5:\nFile: Ex05.txt".matches(myString));
        assertFalse("Exercise 5: File: Ex05.txt".matches(myString));
        assertFalse("Exercise no5:\nFile: Ex05.txt".matches(myString));
        assertFalse("Exercise 5:\nFile: Ex05.pdf".matches(myString));
        assertFalse("Exercise 5:\nFile: Ex05".matches(myString));
        assertFalse("Exercise 5:\nFile: Ex_something05.txt".matches(myString));



    }
    @Test
    public void TestTask2(){
        eksamenPrep.FirstTry.h2021.Ex01 task2 = new eksamenPrep.FirstTry.h2021.Ex01();

        String stringTaskB = task2.RegexB();


        assertFalse("".matches(stringTaskB));
        assertFalse("@Sven: Why do we need the exercises?".matches(stringTaskB));
        assertFalse("@Bogdan: Exercises will be useful in understanding the topic better.".matches(stringTaskB));
        assertFalse("@Bogdan - advises that you do all the exercises".matches(stringTaskB));
        assertFalse("@Sven: Have you asked @Bogdan about this?".matches(stringTaskB));

        assertTrue("@Bogdan: Has everyone completed all algdat exercises??".matches(stringTaskB));
        assertTrue("@Bogdan: Are there any additional algorithms questions!".matches(stringTaskB));
        assertTrue("@Bogdan: Where can I find the solutions for this pg4200 exercise.".matches(stringTaskB));
    }
}