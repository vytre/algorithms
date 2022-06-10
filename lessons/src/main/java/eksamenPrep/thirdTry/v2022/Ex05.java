package eksamenPrep.thirdTry.v2022;

import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

public class Ex05 {
    public static class Archive { // 234

        public byte[] compress(String moves){
            BitWriter bitWriter = new BitWriter();
            String move = "";

            for (int i = 0; i < moves.length(); i++) {
                char c = moves.charAt(i);
                move += c;
            }
            bitWriter.write(Integer.parseInt(move),8);
            return bitWriter.extract();
        }

        public String deCompress(byte[] data) {
            BitReader bitReader = new BitReader(data);
            String result = "";
            int entries = (data.length * 8) / 8;

            for (int i = 0; i < entries; i++) {
                result += bitReader.readInt(8);
            }
            return result;
        }
    }
}
