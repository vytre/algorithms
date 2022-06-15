package pg4200_1027;

public class Ex01 {
    /**
     * Since the task text doesn't include exercise (from the pg4200 github repo) I assume this task was only gonna cover lesson and solutions, or else I would have included "exercise" as an option
     * (/pg4200algorithms)? Occur 0 or 1 time
     * Followed by /lessons OR solutions/src/test/java/org/pg4200
     * /(les|sol)[0-9]{2} then either les or sol followed by 2 numbers ranged 0-9. Only the numbers 10 and 09 are mentioned in the task text, but I assume there can be added more lessons in the future, so i capped it to max 2 numbers
     * (/(.)*)? then followed by something or nothing. In the task text it is written /regex , but I assume there could be other topics there such as /sort or /set or /list and so on
     * /(.)*Test.java Then the java file can be called anything but must end with Test.java
     * **/

    public String regexPartA(){ // ([1-9]|1[0-2])
        return "(/pg4200algorithms)?/(lessons|solutions)/src/test/java/org/pg4200" +
                "/(les|sol)[0-9]{2}" +
                "(/(.)*)?" +
                "/(.)*Test.java";
    }

/**
 * Explanation:
 * (?i) lower or uppercase
 * @ (.)*:(.)* username followed by something or nothing
 * (PG([a-z])?{1}[0-9]{3,4}|programming|programmering) I assume the courseCode starts with PG, but can have 1 more letter followed by a numbers 0-9 3 or 4 times
 * OR contains programming or programmering
 * followed by something or nothing
 * ends with ?
 * */
    public String regexPartB(){
        return "(?i)@(.)*:(.)*(PG([a-z])?[0-9]{3,4}|programming|programmering)(.)*[\\?]";
    }




}
