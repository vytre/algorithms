package eksamenPrep.SecondTry.h2021;

public class Ex01 {

    public String regexA(){
        return "pg4200_[0-9]{5}.zip"; // must contain pg4200_ then 5 numbers range 0-9 end with .zip
    }


    public String regexB(){
        return "(.)*(algorithms|algdat|pg4200)(.)*[\\.|\\?|\\!]";
        // Start with something or nothing, then algdat, then something or nothing
    }

}
