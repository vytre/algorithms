package EksamenPrep.h2021;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class Ex04 {


    public List<String> myStream(List<Student> students){
        return students.stream().flatMap(student -> student.getExamPoints())
    }
}
