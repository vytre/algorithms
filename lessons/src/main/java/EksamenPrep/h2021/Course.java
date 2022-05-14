package EksamenPrep.h2021;

import java.util.Map;

public class Course {
    private String course_code;
    private String topics;
    private String evaluation;
    private Map<Student, Integer> points;


    public Course() {
    }

    public Course(String course_code, String topics, String evaluation, Map<Student, Integer> points) {
        this.course_code = course_code;
        this.topics = topics;
        this.evaluation = evaluation;
        this.points = points;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public Map<Student, Integer> getPoints() {
        return points;
    }

    public void setPoints(Map<Student, Integer> points) {
        this.points = points;
    }
}
