package eksamenPrep.streamsFra2021og2022;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kai {

    public class Course {
        String courseName;
        Teacher teacher;
        ArrayList<Student> students;
    }

    public static class Teacher {
        String name;
        int age;

        public Teacher(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public class Student {
        String name;
        int age;
        String favouriteColor;
        ArrayList<Course> courses;
    }

    public List<String> pipe1(List<Teacher> teachers) {
        return teachers.stream()
                .filter(teacher -> teacher.name != null)
                .map(teacher -> teacher.name)
                .collect(Collectors.toList());
    }
}
