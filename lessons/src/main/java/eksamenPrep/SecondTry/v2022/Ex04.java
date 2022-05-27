package eksamenPrep.SecondTry.v2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex04 {

    public ArrayList<String> pipe1(List<DiplomaProject> project,String courseId){
        return project.stream()
                .flatMap(diplomaProject -> diplomaProject.getAuthors().stream())
                .filter(student -> student.getCourseList().entrySet().stream())








    }

    public static class DiplomaProject{
        String title;
        ArrayList<Student> authors;

        public String getTitle() {
            return title;
        }

        public ArrayList<Student> getAuthors() {
            return authors;
        }
    }

    public static class Student{
        String name;
        HashMap<Course,Integer> courseList;
        DiplomaProject diplomaProject;

        public String getName() {
            return name;
        }

        public HashMap<Course, Integer> getCourseList() {
            return courseList;
        }

        public DiplomaProject getDiplomaProject() {
            return diplomaProject;
        }
    }

    public static class Course{
        String courseName;
        String courseId;

        public String getCourseName() {
            return courseName;
        }

        public String getCourseId() {
            return courseId;
        }
    }
}
