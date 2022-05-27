package eksamenPrep.FirstTry.h2021;

import java.util.*;
import java.util.stream.Collectors;

public class Ex04 {


    public static class Student{

        public Student(int student_id, String name, Map<String, Double> examPoints) {
            this.student_id = student_id;
            this.name = name;
            this.examPoints = examPoints;
        }

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

        public void setExamPoints(Map<String, Double> examPoints) {
            this.examPoints = examPoints;
        }
    }

    public Double pipe(List<Student> students,String courseId){
        return students.stream()
                .flatMap(student -> student.getExamPoints().entrySet().stream()) // La meg manipulate enten Key eller Value
                .filter(stringDoubleEntry -> courseId.equals(stringDoubleEntry.getKey()))// Sjekker om Key er lik Course, kan også skrive getValue
                .map(Map.Entry::getValue) // Henter verdier
                .collect(Collectors.averagingDouble(value -> value)); // Regner ut average kun på de som = courseId
    }


    public List<String> pipe2(Course[] courses){
        return Arrays.stream(courses)
                .filter(course -> course.getEvaluation() != null)
                .flatMap(course -> course.getPoints().keySet().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public static class Course{
        public String course_code;
        public String topics;
        public String evaluation;
        public Map<String,Integer> points;

        public String getCourse_code() {
            return course_code;
        }

        public String getTopics() {
            return topics;
        }

        public String getEvaluation() {
            return evaluation;
        }

        public Map<String, Integer> getPoints() {
            return points;
        }
    }
}
