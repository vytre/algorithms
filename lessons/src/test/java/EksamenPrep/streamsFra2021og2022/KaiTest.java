package EksamenPrep.streamsFra2021og2022;

import eksamenPrep.streamsFra2021og2022.Kai;
import org.junit.jupiter.api.BeforeAll;
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
        myList.add(teacher);
        myList.add(teacher1);
        myList.add(teacher2);
        myList.add(teacher3);


        Kai kai = new Kai();
        List<String> myListOfNames = kai.pipe1(myList);
        System.out.println(myListOfNames.size()); // 4
    }

    @Test
    public void testPipe2(){
        // ArrayLists
        // Student List
        ArrayList<Kai.Student> studentsObjectOriented = new ArrayList<>(); // Vegard, Marius, Sander
        ArrayList<Kai.Student> algo = new ArrayList<>(); // Siver, Håvard
        ArrayList<Kai.Student> placeHolderStudents = new ArrayList<>();

        // CourseList
        ArrayList<Kai.Course> courses1 = new ArrayList<>(); // PGR112, Tk2100
        ArrayList<Kai.Course> courses2 = new ArrayList<>(); // PGR112, PG4200
        ArrayList<Kai.Course> placeHolderCourses = new ArrayList<>();



        // Teachers
        Kai.Teacher teacher = new Kai.Teacher("Kai",24);
        Kai.Teacher teacher1 = new Kai.Teacher("Bogdan",37);
        Kai.Teacher teacher2 = new Kai.Teacher("Per",45);
        Kai.Teacher teacher3 = new Kai.Teacher("Bengt",40);


        // Courses
        Kai.Course course1 = new Kai.Course("PGR112",teacher1,placeHolderStudents);
        Kai.Course course2 = new Kai.Course("TK2100",teacher3,placeHolderStudents);
        Kai.Course course3 = new Kai.Course("PG4200",teacher,placeHolderStudents);

        // Students
        Kai.Student student1 = new Kai.Student("Vegard",23,"Orange", placeHolderCourses);
        Kai.Student student2 = new Kai.Student("Marius",23,"Red", placeHolderCourses);
        Kai.Student student3 = new Kai.Student("Sivert",24,"Blue", placeHolderCourses);
        Kai.Student student4 = new Kai.Student("Håvard",23,"Yellow", placeHolderCourses);
        Kai.Student student5 = new Kai.Student("Sander",24,"Black", placeHolderCourses);


        studentsObjectOriented.add(student1);
        studentsObjectOriented.add(student2);
        studentsObjectOriented.add(student3);
        studentsObjectOriented.add(student4);
        studentsObjectOriented.add(student5);

        // Final Touch
        course1.setStudents(studentsObjectOriented);
        course2.setStudents(studentsObjectOriented);
        course3.setStudents(algo);

        student1.setCourses(courses1);
        student2.setCourses(courses1);
        student3.setCourses(courses2);
        student4.setCourses(courses2);
        student5.setCourses(courses1);


        algo.add(student3);
        algo.add(student4);

        courses1.add(course1);
        courses1.add(course1);
        courses1.add(course1);
        courses1.add(course1);
        courses1.add(course1);

        courses1.add(course2);
        courses2.add(course3);


        // Filling ArrayLists

        //System.out.println(student1.toString());


        Kai kai = new Kai();
        List<String> myList;
        myList = kai.pipe2(studentsObjectOriented);
        //System.out.println(myList.size());

        long myLong = kai.pipe4(courses1);
        System.out.println(myLong);
    }









    @Test
    public void testPipe3(){
        Kai kai = new Kai();

        Kai.Teacher teacher = new Kai.Teacher("Vegard",55);

        Kai.Student student = new Kai.Student();
        Kai.Student student1 = new Kai.Student();
        Kai.Student student2 = new Kai.Student();

        Kai.Course course = new Kai.Course();
        Kai.Course course1 = new Kai.Course();
        Kai.Course course2 = new Kai.Course();

        ArrayList<Kai.Course> courses = new ArrayList<>();


    }

}