package eksamenPrep.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kai {

    public static class Course {
        String courseName;
        Teacher teacher;
        ArrayList<Student> students;

        public Course(String courseName, Teacher teacher, ArrayList<Student> students) {
            this.courseName = courseName;
            this.teacher = teacher;
            this.students = students;
        }

        public Course(String courseName, Teacher teacher) {
            this.courseName = courseName;
            this.teacher = teacher;
        }

        public Course() {
        }

        public void setStudents(ArrayList<Student> students) {
            this.students = students;
        }
    }

    public static class Teacher {
        String name;
        int age;

        public Teacher(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }

    public static class Student {
        String name;
        int age;
        String favouriteColor;
        ArrayList<Course> courses;

        public Student(String name, int age, String favouriteColor, ArrayList<Course> courses) {
            this.name = name;
            this.age = age;
            this.favouriteColor = favouriteColor;
            this.courses = courses;
        }

        public Student() {
        }

        public void setCourses(ArrayList<Course> courses) {
            this.courses = courses;
        }
    }

    public List<String> pipe1(List<Teacher> teachers) {
        return teachers.stream()
                .filter(teacher -> teacher.name != null)
                .map(teacher -> teacher.name)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> pipe2(List<Student> students){
        return students.stream()
                .filter(student -> student.courses.size() >=3)
                .map(student -> student.name)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Student> pipe3(List<Course> courses){
        return courses.stream()
                .filter(course -> course.teacher.age>=50)
                .flatMap(course -> course.students.stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public long pipe4(List<Course> courses){
        return courses.stream()
                .filter(course -> course.teacher.age>=50)
                .flatMap(course -> course.students.stream())
                .distinct()
                .count();
    }



}
