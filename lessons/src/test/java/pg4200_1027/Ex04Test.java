package pg4200_1027;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Ex04Test {
    @Test
    public void streamTest(){
        Ex04 ex04 = new Ex04();
        Ex04.Student student1 = new Ex04.Student("Vegard","Ytrebø",1);
        Ex04.Student student2 = new Ex04.Student("Marius","Ytrebø",2);
        Ex04.Student student3 = new Ex04.Student("Jonas","Olsen",3);
        Ex04.Student student4 = new Ex04.Student("Syvert","Senholm",4);
        Ex04.Student student5 = new Ex04.Student("Håvard","Johansen",5);
        Ex04.Student student6 = new Ex04.Student("Fredrik","Bogstad",6);

        HashMap<Integer, Ex04.Student> myMap = new HashMap<>();
        myMap.put(1,student1);
        myMap.put(2,student2);
        myMap.put(3,student3);

        HashMap<Integer, Ex04.Student> myMap2 = new HashMap<>();
        myMap2.put(4,student4);
        myMap2.put(5,student5);
        myMap2.put(6,student6);

        Ex04.Course informasjonssikkerhet = new Ex04.Course("Informasjonssikkerhet","Tk2300",myMap);
        Ex04.Course oop = new Ex04.Course("oop","PG4200",myMap);
        Ex04.Course algo = new Ex04.Course("algo","PGR112",myMap2);

        ArrayList<Ex04.Course> courses = new ArrayList<>();

        courses.add(informasjonssikkerhet);
        courses.add(oop);

        Ex04.Program program = new Ex04.Program("Programming",courses);

        ArrayList<Ex04.Program> programs = new ArrayList<>();
        programs.add(program);


    }

    @Test
    public void vegardTest(){
        Ex04 ex04 = new Ex04();

        Ex04.Student student1 = new Ex04.Student("Vegard","Ytrebø",1);
        Ex04.Student student2 = new Ex04.Student("Marius","Ytrebø",2);
        Ex04.Student student3 = new Ex04.Student("Jonas","Olsen",3);
        Ex04.Student student4 = new Ex04.Student("Syvert","Senholm",4);
        Ex04.Student student5 = new Ex04.Student("Håvard","Johansen",5);
        Ex04.Student student6 = new Ex04.Student("Fredrik","Bogstad",6);

        HashMap<Integer, Ex04.Student> myMap13 = new HashMap<>();
        myMap13.put(1,student1);
        myMap13.put(2,student2);
        myMap13.put(3,student3);

        HashMap<Integer, Ex04.Student> myMap46 = new HashMap<>();
        myMap46.put(4,student4);
        myMap46.put(5,student5);
        myMap46.put(6,student6);

        Ex04.Course tk4200 = new Ex04.Course("Informasjonssikkerhet","Tk2300",myMap13);
        Ex04.Course oop = new Ex04.Course("oop","PG4200",myMap46);
        Ex04.Course algo = new Ex04.Course("algo","PGR112",myMap46);

        ArrayList<Ex04.Course> courses = new ArrayList<>();

        courses.add(tk4200);
        courses.add(tk4200);



        Ex04.Program program = new Ex04.Program("Programming",courses);


        ArrayList<String> myArray = ex04.ex04(program);
        System.out.println(myArray);
    }

}