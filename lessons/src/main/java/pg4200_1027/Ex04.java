package pg4200_1027;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex04 {

    public static class Program{
        public String programName;
        public ArrayList<Course> courses;

        public ArrayList<Course> getCourses() {
            return courses;
        }

        public Program(String programName, ArrayList<Course> courses) {
            this.programName = programName;
            this.courses = courses;
        }
    }

    public static class Course{
        public String courseName;
        public String courseCode;
        public HashMap<Integer,Student> students;

        public Course(String courseName, String courseCode, HashMap<Integer, Student> students) {
            this.courseName = courseName;
            this.courseCode = courseCode;
            this.students = students;
        }
    }

    public static class Student{
        public String firstName;
        public String lastName;
        public Integer studentId;

        public Student(String firstName, String lastName, Integer studentId) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.studentId = studentId;
        }
    }

    // I tried to find out how to create Strings from streams but couldn't find out, I struggled to filter on one distinct value
    // but at the same time map on another. I found help on Stackoverflow.
    // The method DistinctByKey uses a map to checks if a value has been "seen" before.

    // DistinctByKey found on StackOverflow "Java 8 Distinct by property"
    // https://stackoverflow.com/questions/23699371/java-8-distinct-by-property

    // ex04 returns an ArrayList<Strings> of last names
    // Same last names can occur, but the Student which the last names comes from is distinct, since they are filtered by StudentId

    // Preferably I would have the method return email-addresses, but I tried several different solutions with joining, but to no avail.

    public ArrayList<String> ex04(Program program){
        return program.courses.stream()
                .flatMap(course -> course.students.values().stream())
                .filter(distinctByKey(student -> student.studentId))
                .map(student -> student.lastName)
                .collect(Collectors.toCollection(ArrayList::new));
    }



    public  <T> Predicate<T> distinctByKey(
            Function<? super T, ?> keyExtractor) {

        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
