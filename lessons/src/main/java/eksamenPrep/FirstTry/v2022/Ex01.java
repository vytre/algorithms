package eksamenPrep.FirstTry.v2022;

public class Ex01 {
    public String regExA(){
        return "Exercise [0-9]{1,2}:\nFile: Ex[0-9]{2}.(java|txt)";
    }

    public String regExB(){
        return "@Bogdan: " + // Bogdan:
                ".*" + // Something or nothing
                "[?]"; // Ends with ?
    }
}
