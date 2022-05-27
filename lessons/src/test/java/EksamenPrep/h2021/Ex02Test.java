package EksamenPrep.h2021;

import eksamenPrep.FirstTry.h2021.Ex02;
import org.junit.jupiter.api.Test;
import org.pg4200.les05.MyMap;
import org.pg4200.les05.MyMapTestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class Ex02Test extends MyMapTestTemplate {


    @Override
    protected <K extends Comparable<K>, V> MyMap<K, V> getInstance() {
        return new Ex02.StudentMap<>();
    }

    @Test
    public void testAddEn(){
        Ex02.StudentMap<Integer,String> map = new Ex02.StudentMap<>();

        map.put(1,"Vegard");
        map.put(2,"Marius");

        assertEquals(2,map.size());

    }

    @Test
    public void testAddEnAndRemoveOne(){
        Ex02.StudentMap<Integer,String> map = new Ex02.StudentMap<>();

        map.put(1,"Vegard");
        map.put(2,"Marius");

        assertEquals(2,map.size());

        map.delete(1);
        assertEquals(map.size(), 1);

        map.delete(2);
        assertEquals(map.size(), 0);
    }


    @Test
    public void vegardTest(){
        Ex02.StudentMap<Integer,String> studentMap = new Ex02.StudentMap<>();

        studentMap.put(3,"Vegard");

        assertEquals(1,studentMap.size());

        System.out.println(studentMap.myMap[3].get(3));

    }

    @Test
    public void vegardTest2(){
        Ex02.StudentMap<Integer,String> studentMap = new Ex02.StudentMap<>();
        studentMap.put(0,"Marius");
        studentMap.put(1,"Marius");
        studentMap.put(2,"Sander");
        studentMap.put(3,"Sander");
        studentMap.put(4,"Sander");
        studentMap.put(5,"Sander");
        studentMap.put(6,"Sander");
        studentMap.put(7,"Sander");
        //studentMap.getByName("vegard");

        System.out.println(studentMap.myMap[0].get(0));


        //System.out.println(studentMap.myMap[1]);

    }
}