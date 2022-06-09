package eksamenPrep.thirdTry.v2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Ex04 {

    public class DiplomaProject{
        String title;
        ArrayList<Student> authors;
    }

    public class Student{
        String name;
        HashMap<Course,Integer> courseList;
        DiplomaProject diplomaProject;
    }

    public class Course{
        String course;
        String courseId;
    }

    public ArrayList<String> myPipe(List<DiplomaProject> diplomaProjectList,String courseId){
        return diplomaProjectList.stream()
                .flatMap(diplomaProject -> diplomaProject.authors.stream())
                .filter(student -> student.courseList.entrySet().stream()
                        .anyMatch(courseIntegerEntry -> courseIntegerEntry.getKey().courseId.equals(courseId)
                                && courseIntegerEntry.getValue()>=2))
                .map(student -> student.diplomaProject.title)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
