package eksamenPrep.SecondTry.v2022;

public class Ex01s {

    public String regexA(){ // Riktig
        return "[Ii][Ss](\\s)+[Tt][Hh][Ii][Ss](\\s)+[Aa][Nn](\\s)+[Oo][Uu][Tt]( )+[Oo][Ff]( )+[Ss][Ee][Aa][Ss][Oo][Nn]( )+[Aa][Pp][Rr][Ii][Ll]( )+[Ff][Oo][Oo][Ll][Ss]( )+[Jj][Oo][Kk][Ee][\\?]";
    }

    public String regexB(){
        return "(?i)is(\\s)+this(\\s)+an(\\s)+out(\\s)+of(\\s)+season(\\s)+april(\\s)+fools(\\s)+joke[\\?]";
    }


}
