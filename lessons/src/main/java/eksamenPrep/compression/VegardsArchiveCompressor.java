package eksamenPrep.compression;

import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

public class VegardsArchiveCompressor {

    public static class archiveCompressor{

        /**
         * ArchiveCode - NOR
         * Building - 15
         * RoomNumber - 15
         * Shelf - 1023
         * */
        public byte[] compress(String data){
            BitWriter bitWriter = new BitWriter();
            // NOR 13 13 1020

            // Code E.G NOR
            for (int i = 0; i < data.length(); i++) {
                bitWriter.write(data.charAt(i),8);
                bitWriter.write(data.charAt(i+1),8);
                bitWriter.write(data.charAt(i+2),8);

                // Building
                String buildingNr = "";
                for (int j = 3; j < 5; j++) {
                    char c = data.charAt(j);
                    buildingNr += c;
                }
                bitWriter.write(Integer.parseInt(buildingNr),4);

                // RoomNr
                String RoomNr = "";
                for (int j = 5; j < 7; j++) {
                    char c = data.charAt(j);
                    RoomNr += c;
                }
                bitWriter.write(Integer.parseInt(RoomNr),4);

                // ShelfNr
                String shelfNr = "";
                for (int j = 7; j < 11; j++) {
                    char c = data.charAt(j);
                    shelfNr += c;
                }
                bitWriter.write(Integer.parseInt(shelfNr),10);

                i+=11;
            }
            return bitWriter.extract();
        }

        public String deCompress(byte[] data){
            BitReader bitReader = new BitReader(data);
            String result = "";

            int entries = (data.length * 8)/42;

            for (int i = 0; i < entries; i++) {

                // ArchiveCode
                result += (char) bitReader.readInt(8);
                result += (char) bitReader.readInt(8);
                result += (char) bitReader.readInt(8);

                // Building
                result += bitReader.readInt(4);

                // RoomNr
                result += bitReader.readInt(4);

                // ShelfNr
                result += bitReader.readInt(10);

            }
            return result;
        }
    }
}
