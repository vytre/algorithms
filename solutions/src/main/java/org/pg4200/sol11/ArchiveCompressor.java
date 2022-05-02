package org.pg4200.sol11;

import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

import java.util.HashMap;
import java.util.Map;

public class ArchiveCompressor extends GenericCompressor{
    HashMap<Integer, String> months = new HashMap<>();
    HashMap<Integer, String> archives = new HashMap<>();
    HashMap<Integer, String> archivesLong = new HashMap<>();

    public ArchiveCompressor(){
        initMonths();
        initArchives();
    }

    public void initMonths(){
        months.put(1, "JAN");
        months.put(2, "FEB");
        months.put(3, "MAR");
        months.put(4, "APR");
        months.put(5, "MAY");
        months.put(6, "JUN");
        months.put(7, "JUL");
        months.put(8, "AUG");
        months.put(9, "SEP");
        months.put(10, "OCT");
        months.put(11, "NOV");
        months.put(12, "DEC");
    }
    public void initArchives(){
        archives.put(1, "NAT");
        archivesLong.put(1, "NationalArchive");

        archives.put(2, "OSL");
        archivesLong.put(2, "OsloArchive");

        archives.put(3, "BER");
        archivesLong.put(3, "BergenArchive");

        archives.put(4, "KRS");
        archivesLong.put(4, "KristiansandArchive");

        archives.put(5, "TRO");
        archivesLong.put(5, "TrondheimArchive");

        archives.put(6, "TRM");
        archivesLong.put(6, "TromsoArchive");

        archives.put(7, "MAR");
        archivesLong.put(7, "MaritimeArchive");
    }
    public int month(String mon){
        int result = -1;
        for (Map.Entry<Integer, String> e : months.entrySet()){
            if(e.getValue().equalsIgnoreCase(mon)){
                result = e.getKey();
            }
        }
        return result;
    }
    public String month(int i){
        return months.get(i);
    }

    public int archive(String arch){
        int result = -1;
        for (Map.Entry<Integer, String> e : archives.entrySet()){
            if(e.getValue().equalsIgnoreCase(arch)){
                result = e.getKey();
            }
        }
        return result;
    }
    public String archive(int i){
        return archivesLong.get(i) + "; " + archives.get(i) + "; ";
    }

    public byte[] compressRub(String data) {
        BitWriter writer = new BitWriter();


        for (int i=0; i<data.length(); i++){
            String yr = "";
            for (int j = 0; j < 4; j++){
                yr += data.charAt(i + j);
            }
            //year
            writer.write(Integer.parseInt(yr), 12);
            i+=5;

            String mon = "";
            for (int j = 0; j < 3; j++){
                mon += data.charAt(i + j);
            }
            // month
            writer.write(month(mon), 4);
            i+=4;

            String dy = "";
            for (int j = 0; j < 2; j++){
                dy += data.charAt(i + j);
            }
            //day
            writer.write(Integer.parseInt(dy), 5);
            i+=3;

            char c = data.charAt(i);
            String archive = "";
            while(c != ';'){
                archive += c;
                i++;
                c = data.charAt(i);
            }

            i+= 2;

            String arch = "";
            for (int j = 0; j < 3; j++){
                arch += data.charAt(i + j);
            }
            i+=3;
            // archive
            writer.write(archive(arch), 3);

            i+=2;

            // Building
            String building = "";
            building += data.charAt(i);
            building += data.charAt(i+1);
            i+=4;
            writer.write(Integer.parseInt(building), 4);

            // Room
            String room = "";
            room += data.charAt(i);
            room += data.charAt(i+1);
            room += data.charAt(i+2);
            i+=5;
            writer.write(Integer.parseInt(room), 10);

            // Shelf
            String shelf = "";
            shelf += data.charAt(i);
            shelf += data.charAt(i+1);
            shelf += data.charAt(i+2);
            shelf += data.charAt(i+3);
            i+=5;
            writer.write(Integer.parseInt(shelf), 11);
        }
        return writer.extract();
    }

    public String decompressRub(byte[] data) {
        BitReader reader = new BitReader(data);
        String result = "";

        int entries = (data.length * 8) / 49;

        for(int i = 0; i < entries; i++){
            // year
            result += reader.readInt(12);
            result += "-";

            int mnth = reader.readInt(4);
            result += month(mnth);
            result += "-";

            //result += reader.readInt(5);
            result += String.format("%1$" + 2 + "s", reader.readInt(5)).replace(' ', '0');

            result += "; ";

            // archive
            int arch = reader.readInt(3);
            result += archive(arch);

            //result += String.format("%dd",reader.readInt(4));
            result += String.format("%1$" + 2 + "s", reader.readInt(4)).replace(' ', '0');
            result += "; ";

            //result += reader.readInt(10);
            result += String.format("%1$" + 3 + "s", reader.readInt(10)).replace(' ', '0');
            result += "; ";

            //result += reader.readInt(11);
            result += String.format("%1$" + 4 + "s", reader.readInt(11)).replace(' ', '0');

            result += ";";

            result += "\n";
        }

        return result;
    }

    /*
    This class is used for evaluation. The compress/decompress methods normally call student code for
    evaluation purposes. Here I just call the other methods in this class.
     */
    public byte[] compress(String data) {
        // Student code normally goes here for evaluation :)
        return this.compressRub(data);
    }

    public String decompress(byte[] data){
        // Student code normally goes here for evaluation :)
        return this.decompressRub(data);
    }
}
