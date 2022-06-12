package eksamenPrep.compression;

import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

public class CompressStringAndInteger {
    public static class CompressStringAndInt{

        /***
         * Hvis man skal compresse et tall med 2^8 = 256 bits, så lar den deg skrive 255 men IKKE 256!
         */
        public byte[] compress(String data){

            BitWriter bitWriter = new BitWriter();

            // NOR
            for (int i = 0; i < data.length(); i++) {
                bitWriter.write(data.charAt(i),8);
                bitWriter.write(data.charAt(i+1),8);
                bitWriter.write(data.charAt(i+2),8);


                // 127
                String myInt = "";
                for (int j = 3; j < data.length(); j++) {
                    char c = data.charAt(j);
                    myInt += c;
                }
                bitWriter.write(Integer.parseInt(myInt),7);
                i+=6;
            }

            return bitWriter.extract();
        }

        public String deCompress(byte[] compressedData){
            BitReader bitReader = new BitReader(compressedData);
            String result = "";
            int entries = (compressedData.length * 8)/31;

            for (int i = 0; i < entries; i++) {

                // NOR
                result += (char)bitReader.readInt(8);
                result += (char)bitReader.readInt(8);
                result += (char)bitReader.readInt(8);


                // 127
                result += bitReader.readInt(7);
            }
            return result;
        }
    }
}
