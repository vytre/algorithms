package pg4200_1027;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public ArrayList<String> ex04(List<Program> pro){
        return pro.stream()
                .flatMap(program -> program.courses.stream())
                .flatMap(course -> course.students.entrySet().stream())
                .filter(integerStudentEntry -> integerStudentEntry.getKey() != null)
                .map(integerStudentEntry -> integerStudentEntry.getValue().lastName)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
