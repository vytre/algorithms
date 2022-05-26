package eksamenPrep.SecondTry.h2021;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex04 {

    public Double pipe1(String course,List<Student> students){

        return students.stream()
                .flatMap(student -> student.getExamPoints().entrySet().stream())
                .filter(stringDoubleEntry -> course.equals(stringDoubleEntry.getKey()))
                .map(Map.Entry::getValue)
                .collect(Collectors.averagingDouble(value -> value));

    }

    public List<Student> pipe2(List<Course> courses){
        return courses.stream()
                .filter(course -> course.getEvaluation() != null)
                .filter(course -> course.toipics.contains("programming"))
                .flatMap(course -> course.getPoints().keySet().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public static class Student{
        public int student_id;
        public String name;
        public Map<String,Double> examPoints;

        public int getStudent_id() {
            return student_id;
        }

        public String getName() {
            return name;
        }

        public Map<String, Double> getExamPoints() {
            return examPoints;
        }
    }

    public static class Course{
        public String course_code;
        public String toipics;
        public String evaluation;
        public Map<Student,Integer> points;

        public String getCourse_code() {
            return course_code;
        }

        public String getToipics() {
            return toipics;
        }

        public String getEvaluation() {
            return evaluation;
        }

        public Map<Student, Integer> getPoints() {
            return points;
        }
    }

}
