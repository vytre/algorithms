package EksamenPrep.h2021;
import eksamenPrep.h2021.Ex04;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class Ex04Test {


    @Test
    public void vegardTest(){
        Ex04 ex04 = new Ex04();

        ArrayList<Ex04.Student> students = new ArrayList<>();

        Map<String,Double> map1 = new HashMap<>();
        map1.put("PG4200",3.0d);
        map1.put("TK2100",3.0d);
        map1.put("PGR112",3.0d);


        Map<String,Double> map2 = new HashMap<>();
        map2.put("PG4200",3.0d);
        map2.put("TK2100",3.0d);
        map2.put("PGR112",3.0d);

        Map<String,Double> map3 = new HashMap<>();
        map3.put("PG4200",3.0d);
        map3.put("TK2100",3.0d);
        map3.put("PGR112",3.0d);

        Map<String,Double> map4 = new HashMap<>();
        map4.put("PG4200",3.0d);
        map4.put("TK2100",3.0d);
        map4.put("PGR112",3.0d);

        Map<String,Double> map5 = new HashMap<>();
        map5.put("PG4200",3.0d);
        map5.put("TK2100",3.0d);
        map5.put("PGR112",3.0d);



        students.add(new Ex04.Student(12,"Vegard",map1));
        students.add(new Ex04.Student(13,"Marius",map2));
        students.add(new Ex04.Student(10,"Sander",map3));
        students.add(new Ex04.Student(3,"Håvard",map4));
        students.add(new Ex04.Student(5,"Fredrik",map5));

        Double ss = ex04.pipe(students,"TK2100");

        assertEquals(ss,3.0d);

    }
}