package org.pg4200.ex10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class RegexTestTemplate {
    protected abstract RegexExample getNewInstance();

    @Test
    public void rubricDTest() {
        String rub = getNewInstance().solutionA();
        exerciseA(rub);
    }

    @Test
    public void rubricETest() {
        String rub = getNewInstance().solutionB();
        rubricB(rub);
    }


    public void exerciseA(String regex){
        assertFalse("".matches(regex));
        assertFalse("Exercise no5:\nFile: Ex05.txt".matches(regex));
        assertFalse("Exercise 5: File: Ex05.txt".matches(regex));
        assertFalse("Exercise 5:\nFile: Ex05.pdf".matches(regex));
        assertFalse("Exercise 5:\nFile: Ex05".matches(regex));
        assertFalse("Exercise 5:\nFile: Ex_something05.txt".matches(regex));
        assertFalse("Blorpblo 5:\nHunh: Ex05.java".matches(regex));

        assertTrue("Exercise 5:\nFile: Ex05.txt".matches(regex));
        assertTrue("Exercise 3:\nFile: Ex03.java".matches(regex));
        assertTrue("Exercise 13:\nFile: Ex13.java".matches(regex));
        assertTrue("Exercise 42:\nFile: Ex42.txt".matches(regex));
    }

    public void rubricB(String regex){
        assertFalse("".matches(regex));
        assertFalse("@Sven: Why do we need the exercises?".matches(regex));
        assertFalse("@Bogdan: Exercises will be useful in understanding the topic better.".matches(regex));
        assertFalse("@Bogdan - advises that you do all the exercises".matches(regex));
        assertFalse("@Sven: Have you asked @Bogdan about this?".matches(regex));

        assertTrue("@Bogdan: Has everyone completed all 12 pg4200 exercises?".matches(regex));
        assertTrue("@Bogdan: Are there any additional questions about algdat?".matches(regex));
        assertTrue("@Bogdan: Where can I find the solutions for this algorithms exercise?".matches(regex));
        assertTrue("@Bogdan: Did you understand the algorithm well enough to write the code?".matches(regex));
    }
}
