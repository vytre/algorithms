package EksamenPrep.streamsFra2021og2022;

import eksamenPrep.streamsFra2021og2022.Kai;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KaiTest {

    @Test
    public void testPipe1(){
        Kai.Teacher teacher = new Kai.Teacher("Kai",24);
        Kai.Teacher teacher1 = new Kai.Teacher("Bogdan",37);
        Kai.Teacher teacher2 = new Kai.Teacher("Per",45);
        Kai.Teacher teacher3 = new Kai.Teacher("Bengt",40);

        List<Kai.Teacher> myList = new ArrayList<>();

        Kai kai = new Kai();
        List<String> myListOfNames = kai.pipe1(myList);
        System.out.println(myListOfNames);



    }

}