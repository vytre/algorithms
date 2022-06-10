package eksamenPrep.thirdTry.h2021;

import org.pg4200.les02.generic.GenericExample;
import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

public class Ex05 {
    public static class chess { // Eks 1pe2e4
        public byte[] compress (String moves){
            BitWriter bitWriter = new BitWriter();
            String chessMove = "";

            // Her sjekker vi hvilken TrekkNr vi er på
            for (int i = 0; i < moves.length(); i++) {
                char c = moves.charAt(i);

                if (c >= '0' && c<='9'){ // Vi sjekker om c er mellom 0-9, kan være vi er på trekk 23, da vil vo gå innom her 2 ganger
                    chessMove += c;
                }
                else if(c>='A' && c <= 'z'){ // Neste char er bokstav, altså "Brikke Type", men vi må først ta oss av trekkNr... -->
                    // 1. BitWriter tar vi TrekkNr, gjør det om til int og skriver det på 9 bits.
                    bitWriter.write(Integer.parseInt(chessMove),9); // Skriver Move til bit e.g 1 til bits (1)pe2e4
                    moves = "";

                    // 2. BitWriter Skriver vi Brikke, trekker ifra A? og skriver det om til 8 bits, java bruker 16
                    bitWriter.write(c-'A',8); // 1(p)e2e4

                    // 3. Den første BitWriter tar for seg Origin bokstav og den andre Origin nummer

                    bitWriter.write(moves.charAt(i+1) - 'a' ,3); // Nå er vi på i+1 som er 1+1 som er char nr 3 1p(e)2e4
                    bitWriter.write(moves.charAt(i+2) - 1,3); // Nå er vi på i+2 som er 1+2 som er char nr 4 1pe(2)e4

                    // Grunnen til at det er 3 bits er fordi 2 bits gir oss 4 forskjellige tall, 3 gir oss 8 (Brettet går fra 1-8)


                    // 4. Den første BitWriter tar for seg Destinasjon bokstav og den andre Destinasjon nummer
                    bitWriter.write(moves.charAt(i+3)-'a',3); //1pe2(e)4
                    bitWriter.write(moves.charAt(i+4)-1,3); //1pe2e(4)
                    i +=4;

                    if (i+1 == moves.length()){
                        bitWriter.write(0,1);
                    }
                    else {
                        char ch = moves.charAt(i+1);
                        if (ch == '!') {
                            bitWriter.write(1, 1);
                        }
                        else{
                            bitWriter.write(0,1);
                        }
                    }
                }
            }
            return bitWriter.extract();
        }


        public String deCompress (byte[] data){

            BitReader reader = new BitReader(data);
            String result = "";
            int entries = (data.length * 8) / 30;

            for (int i = 0; i < entries; i++) {

                // TrekkNr
                result += reader.readInt(9);

                // Brikke
                result += (char)('A' + reader.readInt(8));

                // Origin
                result += (char)('a' + reader.readInt(3)); // Origin Bokstav
                result += (reader.readInt(3)+ 1); // Origin Bokstav

                // Destinasjon
                result += (char)('a' + reader.readInt(3)); // Destinasjon Bokstav
                result += (reader.readInt(3) + 1); // Destinasjon Nr

                //check
                boolean check = reader.readBoolean();
                if (check){
                    result += "!";
                }
            }
            return result;
        }
    }
}
