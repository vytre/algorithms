package EksamenPrep.h2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex01Test {

    @Test
    public void TestTask1(){
    Ex01 task1 = new Ex01();

    String stringTaskA = task1.RegexA();

        assertFalse("".matches(stringTaskA));
        assertFalse("pg4201_00000.zip".matches(stringTaskA));
        assertFalse("pg4200_ab000.zip".matches(stringTaskA));
        assertFalse("pg4200_00000.rar".matches(stringTaskA));
        assertFalse("pg4200_00000zip".matches(stringTaskA));
        assertFalse("pg4200_123456.zip".matches(stringTaskA));


        assertTrue("pg4200_00000.zip".matches(stringTaskA));
        assertTrue("pg4200_12345.zip".matches(stringTaskA));
    }


    @Test
    public void TestTask2(){
        Ex01 task2 = new Ex01();

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