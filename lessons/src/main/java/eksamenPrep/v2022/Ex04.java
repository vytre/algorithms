package eksamenPrep.v2022;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Ex04 {

    public static class Student{
        String name;
        DiplomaProject diplomaProject;
        HashMap<Course,Integer> courseList;

        public String getName() {
            return name;
        }

        public DiplomaProject getDiplomaProject() {
            return diplomaProject;
        }

        public HashMap<Course, Integer> getCourseList() {
            return courseList;
        }
    }


    public static class DiplomaProject{
        String title;
        ArrayList<Student> authors;
    }


    public static class Course{
        String courseName;
        String courseId;
    }

    public ArrayList<String> myPipe(String courseId, List<DiplomaProject> diplomaProjectList){
        return diplomaProjectList.stream()
                .flatMap(diplomaProject -> diplomaProject.authors.stream())
                .filter(student -> student.courseList.entrySet().stream().anyMatch(courseIntegerEntry -> courseIntegerEntry.getKey().courseId.equals(courseId)))
                .map(student -> student.diplomaProject.title)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));

    }


}
