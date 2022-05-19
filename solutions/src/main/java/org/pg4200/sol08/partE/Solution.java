package org.pg4200.sol08.partE;

import org.pg4200.ex08.partE.Course;
import org.pg4200.ex08.partE.DiplomaProject;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Solution {
    public ArrayList<String> relevantTitles(ArrayList<DiplomaProject> projects, Course course){
        return projects.stream()
                .filter(d -> d.authors.stream()
                        .filter(s -> s.courseList.containsKey(course))
                        .filter(s -> s.courseList.get(course) >= 2)
                        .count() > 0
                )
                .map(d -> d.title)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> relevantTitlesV2(ArrayList<DiplomaProject> projects, String courseN){
        return projects.stream()
                .flatMap(p -> p.authors.stream())
                .filter(s -> s.courseList.entrySet().stream()
                        .anyMatch(c -> c.getKey().courseId.equals(courseN)
                                && c.getValue() >= 2))
                .map(s -> s.diplomaProject.title)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));
    }


}
