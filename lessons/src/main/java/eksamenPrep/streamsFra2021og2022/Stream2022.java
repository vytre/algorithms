package eksamenPrep.streamsFra2021og2022;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream2022 {

    public static class Student{
        public int student_id;
        public String name;
        public Map<String,Double> examPoints;

    }

    public static class Course{
        public String course_code;
        public String topics;
        public String evaluation;
        public Map<Student,Integer> points;
    }

    public Double pipeA(List<Student> myStudents,String courseId){

        return myStudents.stream()
                .flatMap(student -> student.examPoints.entrySet().stream())
                .filter(stringDoubleEntry -> stringDoubleEntry.getKey().equals(courseId))
                .map(Map.Entry::getValue)
                .collect(Collectors.averagingDouble(value -> value));
    }
    
}
