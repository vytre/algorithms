package pg4200_1027;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex01Test {

    @Test
    public void testRegexA(){
        Ex01 ex01 = new Ex01();
        String myString = ex01.regexPartA();


        assertTrue("/pg4200algorithms/lessons/src/test/java/org/pg4200/les12/regex/MatcherTest.java".matches(myString));
        assertTrue("/lessons/src/test/java/org/pg4200/les09/UndirectedGraphTest.java".matches(myString));
        assertTrue("/solutions/src/test/java/org/pg4200/sol10/regex/RegexExampleImpTest.java".matches(myString));


        assertFalse("/pg4200algorithms/lessons/src/main/java/org/pg4200/les10/regex/MatcherTest.java".matches(myString)); // Not in test folder
        assertFalse("/lessons/src/test/java/org/pg4200/les09/UndirectedGraph.java".matches(myString)); // Har ikke Test i slutten av klassen
        assertFalse("/solutions/src/test/java/org/pg4200/sol10/regex/RegexExampleImpTest.html".matches(myString)); // ender på .html
    }

    @Test
    public void testC(){
        Ex01 ex01 = new Ex01();
        String myString = ex01.regexPartC();
        assertTrue("/lessons/src/test/java/org/pg4200/les09/UndirectedGraphTest.java".matches(myString));
        assertTrue("/solutions/src/test/java/org/pg4200/sol10/regex/RegexExampleImpTest.java".matches(myString));
        assertTrue("/pg4200algorithms/lessons/src/test/java/org/pg4200/les12/regex/MatcherTest.java".matches(myString));


    }

    @Test
    public void testB(){
        Ex01 ex01 = new Ex01();
        String myString = ex01.regexPartB();


    }


}