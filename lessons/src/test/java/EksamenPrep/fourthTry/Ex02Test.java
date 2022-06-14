package EksamenPrep.fourthTry;

import eksamenPrep.fourthTry.Ex02;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex02Test {
    @Test
    public void test1(){
        Ex02.StudentMap<Integer,String> studentMap = new Ex02.StudentMap<>();
        studentMap.put(1335,"vegard");
    }

}