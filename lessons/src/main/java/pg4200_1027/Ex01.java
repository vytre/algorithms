package pg4200_1027;

public class Ex01 {

    public String regexPartA(){ // ([1-9]|1[0-2])
        return "(/pg4200algorithms)?/(lessons|solutions)/src/test/java/org/pg4200" +
                "/(les|sol)(09|10)(.)*/(.)+(Test.java)";
    }


    public String regexPartB(){
        return "@(.)*:";
    }

    public String regexPartC(){
        return "(/pg4200algorithms)?/(lessons|solutions)/src/test/java/org/pg4200" +
                "/(les|sol)(09|10)" +
                "(/(.)*)?" +
                "/(.)*(Test.java)";
    }



}
