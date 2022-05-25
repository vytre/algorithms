package EksamenPrep.h2020;

import eksamenPrep.h2020.Ex02;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex02Test {

    @Test
    public void test1(){
        Ex02<String> ex02 = new Ex02<>();

        ex02.add("Vegard");
        ex02.add("Vegard");
        ex02.add("Vegard");
        ex02.add("Vegard");
        ex02.add("Vegard");

        System.out.println(ex02.size());
        System.out.println(ex02.getMiddle());



    }


}