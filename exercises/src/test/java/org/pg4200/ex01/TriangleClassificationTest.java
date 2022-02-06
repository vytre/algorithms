package org.pg4200.ex01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.pg4200.ex01.TriangleClassification.Classification.*; // Imorterer alle ENUMs
import static org.pg4200.ex01.TriangleClassification.classify; // Importerer metode classify

public class TriangleClassificationTest {

    @Test
    public void testNegativeValue() {
        TriangleClassification.Classification notTriangle = classify(-2, 4, 4);
        assertEquals(NOT_A_TRIANGLE, notTriangle);
    }

    @Test
    public void toLongEdgeA() {
        TriangleClassification.Classification notTriangle = classify(200, 4, 4);
        assertEquals(NOT_A_TRIANGLE, notTriangle);
    }

    @Test
    public void testEquilateral(){
        TriangleClassification.Classification equilateral = classify(4,4,4);
        assertEquals(EQUILATERAL, equilateral);
    }

    @Test
    public void testIsosceles(){
        TriangleClassification.Classification isosceles = classify(3,4,4);
        assertEquals(ISOSCELES, isosceles);
    }

    @Test
    public void testScalene(){
        TriangleClassification.Classification scalene = classify(3,4,5);
        assertEquals(SCALENE, scalene);
    }
}
