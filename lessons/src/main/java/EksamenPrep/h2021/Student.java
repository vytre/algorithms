package EksamenPrep.h2021;

import java.util.Map;

public class Student {

    private int student_id;
    private String name;
    private Map<String,Double> examPoints;

    public Student() {
    }

    public Student(int student_id, String name, Map<String, Double> examPoints) {
        this.student_id = student_id;
        this.name = name;
        this.examPoints = examPoints;
    }

    public int getStudent_id() {
        return student_id;
    }

    public String getName() {
        return name;
    }

    public Map<String, Double> getExamPoints() {
        return examPoints;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExamPoints(Map<String, Double> examPoints) {
        this.examPoints = examPoints;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", name='" + name + '\'' +
                ", examPoints=" + examPoints +
                '}';
    }
}
