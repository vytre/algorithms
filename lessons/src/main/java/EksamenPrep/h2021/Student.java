package EksamenPrep.h2021;

import java.util.Map;

public class Student {
    public int student_id;
    public String name;
    public Map<String,Integer> examPoints;


    public Student() {
    }

    public Student(int student_id, String name, Map<String, Integer> examPoints) {
        this.student_id = student_id;
        this.name = name;
        this.examPoints = examPoints;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getExamPoints() {
        return examPoints;
    }

    public void setExamPoints(Map<String, Integer> examPoints) {
        this.examPoints = examPoints;
    }
}
