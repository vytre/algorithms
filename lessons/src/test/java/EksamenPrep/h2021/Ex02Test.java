package EksamenPrep.h2021;

import eksamenPrep.h2021.Ex02;
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

    }
}