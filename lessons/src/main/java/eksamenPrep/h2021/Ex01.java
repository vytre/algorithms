package eksamenPrep.h2021;

public class Ex01 {
    public String RegexA(){
        return "pg4200_[0-9]{5}.zip";
    }

    public String RegexB(){
        return "(.)*"+"(algdat|algorithms|pg4200)"+ "(.)*" +"[\\!\\?\\.]";
    }
}
