package org.pg4200.sol08.partE;

import org.junit.jupiter.api.Test;
import org.pg4200.ex08.partE.Course;
import org.pg4200.ex08.partE.DiplomaProject;
import org.pg4200.ex08.partE.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PartETest {

    public ArrayList<Course> generateCourses(int n){
        ArrayList<Course> result = new ArrayList<>();

        Course pg4200 = new Course();
        pg4200.courseName = "AlgDat";
        pg4200.courseId = "pg4200";

        result.add(pg4200);

        for (int i = 1; i < n; i++){
            Course c = new Course();
            int cid = 4220 + i;
            c.courseId = "pg" + cid;
            c.courseName = "Course " + cid;

            result.add(c);
        }
        return result;
    }

    public ArrayList<Student> generateStudents(int n, ArrayList<Course> courses){
        ArrayList<Student> result = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i< n; i++){
            Student s = new Student();
            s.name = "Student " + i;
            HashMap<Course, Integer> cou = new HashMap<>();

            for(int j= 0; j< courses.size() - 3; j++){
                int ra = random.nextInt(2);
                int grade = random.nextInt(5);
                cou.put(courses.get(j + ra), grade);
            }

            int pg = random.nextInt(5);
            if(pg > 0){
                cou.put(courses.get(0), pg);
            }

            s.courseList = cou;

            result.add(s);
        }

        return result;
    }

    public ArrayList<DiplomaProject> generateDiplomaProjs(int n, ArrayList<Student> studentsIn){
        ArrayList<DiplomaProject> result = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        students.addAll(studentsIn);
        Random rand = new Random();

        for(int i = 0; i < n && students.size() > 0; i++){
            DiplomaProject d = new DiplomaProject();
            d.title = "Project " + i;
            d.authors = new ArrayList<>();
            int s = 1 + rand.nextInt(2);
            for (int j = 0; j < s && students.size() > 0 ; j++){
                int rs = rand.nextInt(students.size());
                Student st = students.get(rs);
                d.authors.add(st);
                st.diplomaProject = d;
                students.remove(rs);
            }

            result.add(d);
        }

        return result;
    }

    @Test
    public void testStudents(){
        ArrayList<Course> courses = generateCourses(20);
        ArrayList<Student> students = generateStudents(150, courses);
        ArrayList<DiplomaProject> diplomaProjects = generateDiplomaProjs(70, students);

        assertTrue(diplomaProjects.size() >= 0);

        Course course = courses.get(0);

        ArrayList<String> titles = diplomaProjects.stream()
                        .filter(d -> d.authors.stream()
                                .filter(s -> s.courseList.containsKey(course))
                                .filter(s -> s.courseList.get(course) >= 2)
                                .count() > 0
                        )
                                .map(d -> d.title)
                                        .collect(Collectors.toCollection(ArrayList::new));


        assertTrue(titles.size() >= 0);
    }

    @Test
    public void testStudents2(){
        ArrayList<Course> courses = generateCourses(20);
        ArrayList<Student> students = generateStudents(150, courses);
        ArrayList<DiplomaProject> diplomaProjects = generateDiplomaProjs(70, students);

        assertTrue(diplomaProjects.size() >= 0);

        String courseN = "pg4200";
        Course course = courses.get(0);

        ArrayList<String> titles = diplomaProjects.stream()
                .filter(d -> d.authors.stream()
                        .filter(s -> s.courseList.keySet().stream().anyMatch(c -> c.courseName.contains(courseN)))
                        .filter(s -> s.courseList.get(course) >= 2)
                        .count() > 0
                )
                .map(d -> d.title)
                .collect(Collectors.toCollection(ArrayList::new));


        assertTrue(titles.size() >= 0);
    }

    @Test
    public void testStudents3(){
        ArrayList<Course> courses = generateCourses(20);
        ArrayList<Student> students = generateStudents(150, courses);
        ArrayList<DiplomaProject> diplomaProjects = generateDiplomaProjs(70, students);

        assertTrue(diplomaProjects.size() >= 0);

        String courseN = "pg4200";
        Course course = courses.get(0);

        ArrayList<String> titles = diplomaProjects.stream()
                .flatMap(p -> p.authors.stream())
                .filter(s -> s.courseList.entrySet().stream()
                        .anyMatch(c -> c.getKey().courseId.equals(courseN)
                                && c.getValue() >= 2))
                .map(s -> s.diplomaProject.title)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));


        assertTrue(titles.size() >= 0);
    }

    @Test
    public void testStudents5(){
        ArrayList<Course> courses = generateCourses(20);
        ArrayList<Student> students = generateStudents(150, courses);
        ArrayList<DiplomaProject> diplomaProjects = generateDiplomaProjs(70, students);

        assertTrue(diplomaProjects.size() >= 0);

        String courseN = "pg4200";
        Course course = courses.get(0);

        ArrayList<String> titles = diplomaProjects.stream()
                .filter(dp -> dp.authors.stream()
                        .filter(s -> s.courseList.entrySet().stream()
                                .filter(sc -> sc.getKey().courseId.equals("pg4200") && sc.getValue() >= 2).toArray().length > 0)
                        .toArray().length > 0)
                .map(dp -> dp.title)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));


        assertTrue(titles.size() >= 0);
    }

    @Test
    public void testStudents6(){
        ArrayList<Course> coursesI = generateCourses(20);
        ArrayList<Student> students = generateStudents(150, coursesI);
        ArrayList<DiplomaProject> diplomaProjects = generateDiplomaProjs(70, students);

        assertTrue(diplomaProjects.size() >= 0);

        String courseN = "pg4200";
        String courseId = "pg4200";
        Course course = coursesI.get(0);

        ArrayList<String> titlesRubric = rubric(diplomaProjects, course);


        ArrayList<String> titlesStudent = diplomaProjects.stream()
                .flatMap(diplomaProject -> diplomaProject.authors.stream())
                .filter(student -> {
                    var pg4200 = student.courseList.entrySet()
                            .stream()
                            .filter(courseIntegerEntry -> courseIntegerEntry.getKey().courseId.equals("pg4200"))
                            .findFirst();
                    if (pg4200.isPresent()) {
                        return pg4200.get().getValue() >= 2;
                    } else {
                        return false;
                    }
                })
                .map(student -> student.diplomaProject.title)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));




        assertEquals(titlesRubric.size(), titlesStudent.size());
    }

    @Test
    public void testStudentsEv(){

        // This test is a generic view of how code might be tested

        ArrayList<Course> coursesI = generateCourses(20);
        ArrayList<Student> students = generateStudents(150, coursesI);
        ArrayList<DiplomaProject> diplomaProjects = generateDiplomaProjs(70, students);

        assertTrue(diplomaProjects.size() >= 0);

        Solution s1 = new Solution();

        String courseN = "pg4200";
        String courseId = "pg4200";
        Course course = coursesI.get(0);

        // This defines the "expected result". In this case, the implementation I developed as a rubric.
        ArrayList<String> titlesRubric = rubric(diplomaProjects, course);


        // First example solution
        ArrayList<String> titlesV1 = s1.relevantTitles(diplomaProjects, course);
        // Assess that the "solutions" have the same size
        assertEquals(titlesRubric.size(), titlesV1.size());
        // and contain the same strings as the rubric
        assertTrue(titlesRubric.containsAll(titlesV1));
        assertTrue(titlesV1.containsAll(titlesRubric));

        // Second example solution
        ArrayList<String> titlesV2 = s1.relevantTitlesV2(diplomaProjects, courseN);
        assertEquals(titlesRubric.size(), titlesV2.size());
        assertTrue(titlesRubric.containsAll(titlesV2));
        assertTrue(titlesV2.containsAll(titlesRubric));

    }

    public ArrayList<String> rubric(ArrayList<DiplomaProject> diplomaProjects, Course course){
        return diplomaProjects.stream()
                .filter(d -> d.authors.stream()
                        .filter(s -> s.courseList.containsKey(course))
                        .anyMatch(s -> s.courseList.get(course) >= 2)
                )
                .map(d -> d.title)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
