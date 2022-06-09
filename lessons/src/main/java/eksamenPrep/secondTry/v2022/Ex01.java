package eksamenPrep.secondTry.v2022;

public class Ex01 {

    public String regexA(){
        return "Exercise ([0-9]{1,2}):\n" +
                "File: Ex([0-9]{2}).(txt|java)";
    }

    public String regexB(){
        return "@Bogdan:(.)*[?]";
    }
}
