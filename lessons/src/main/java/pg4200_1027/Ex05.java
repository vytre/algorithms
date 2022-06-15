package pg4200_1027;

import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

public class Ex05 {








    public static class CourseFeedBack { // PG 4200 456987 2022 JUN 06

        public byte[] compression(String feedBackList){
            BitWriter bitWriter = new BitWriter();

            // Program Eg PG
            for (int i = 0; i < feedBackList.length(); i++) {
                bitWriter.write(feedBackList.charAt(i),8);
                bitWriter.write(feedBackList.charAt(i+1),8);

                // CourseId Eg 4200
                String courseNr = "";
                for (int j = 2; j < 6; j++) {
                    char c = feedBackList.charAt(j);
                    courseNr += c;
                }
                bitWriter.write(Integer.parseInt(courseNr),17);

                // UniqueId Eg 456987
                String uniqueId = "";
                for (int j = 7; j < 13; j++) {
                    char c = feedBackList.charAt(j);
                    uniqueId += c;
                }
                bitWriter.write(Integer.parseInt(uniqueId),20);

                // Year Eg 2022
                String year = "";
                for (int j = 16; j < 20; j++) {
                    char c = feedBackList.charAt(j);
                    year += c;
                }
                bitWriter.write(Integer.parseInt(year),12);

                // Month
                for (int j = 21; j < 24; j++) {
                    bitWriter.write(feedBackList.charAt(j),8);
                    bitWriter.write(feedBackList.charAt(j+1),8);
                    bitWriter.write(feedBackList.charAt(j+2),8);
                    j = 25;
                }

                // Day
                String day = "";
                for (int j = 25; j < 27; j++) {
                    char c = feedBackList.charAt(j);
                    day += c;
                }
                bitWriter.write(Integer.parseInt(day),5);

                // File
                for (int j = 29; j < 33; j++) {
                    bitWriter.write(feedBackList.charAt(j),8);
                    bitWriter.write(feedBackList.charAt(j+1),8);
                    bitWriter.write(feedBackList.charAt(j+2),8);
                    bitWriter.write(feedBackList.charAt(j+3),8);
                    j = 33;
                }

                // Feedback
                for (int j = 35; j < 43; j++) {
                    bitWriter.write(feedBackList.charAt(j),8); // f
                    bitWriter.write(feedBackList.charAt(j+1),8); // e
                    bitWriter.write(feedBackList.charAt(j+2),8); // e
                    bitWriter.write(feedBackList.charAt(j+3),8); // d
                    bitWriter.write(feedBackList.charAt(j+4),8); // b
                    bitWriter.write(feedBackList.charAt(j+5),8); // a
                    bitWriter.write(feedBackList.charAt(j+6),8); // c
                    bitWriter.write(feedBackList.charAt(j+7),8); // c
                    j = 43;
                }

                bitWriter.write(feedBackList.charAt(i),8);
                bitWriter.write(feedBackList.charAt(i+1),8);

                // CourseId Eg 4200
                bitWriter.write(Integer.parseInt(courseNr),17);

                // Uni
                bitWriter.write(Integer.parseInt(uniqueId),20);

                i+= 62;
            }
            return bitWriter.extract();
        }



        public String decompression(byte[] compressedData){
            BitReader bitReader = new BitReader(compressedData);
            String deCompressedData = "";

            int entries = (compressedData.length*8)/223;

            for (int i = 0; i < entries; i++) {

                // Program
                deCompressedData += (char) bitReader.readInt(8);
                deCompressedData += (char) bitReader.readInt(8);

                // CourseId Eg 4200
                deCompressedData += bitReader.readInt(17);

                deCompressedData += (":");

                // UniqueId
                deCompressedData += bitReader.readInt(20);

                deCompressedData += (" / ");

                // Year
                deCompressedData += bitReader.readInt(12);

                deCompressedData += ("-");

                // Month
                deCompressedData += (char) bitReader.readInt(8);
                deCompressedData += (char) bitReader.readInt(8);
                deCompressedData += (char) bitReader.readInt(8);

                deCompressedData += ("-");

                // Day
                deCompressedData += bitReader.readInt(5);

                deCompressedData += (". ");

                // File
                deCompressedData += (char) bitReader.readInt(8);
                deCompressedData += (char) bitReader.readInt(8);
                deCompressedData += (char) bitReader.readInt(8);
                deCompressedData += (char) bitReader.readInt(8);

                deCompressedData += (": ");

                // Feedback
                deCompressedData += (char) bitReader.readInt(8); // f
                deCompressedData += (char) bitReader.readInt(8); // e
                deCompressedData += (char) bitReader.readInt(8); // e
                deCompressedData += (char) bitReader.readInt(8); // d
                deCompressedData += (char) bitReader.readInt(8); // b
                deCompressedData += (char) bitReader.readInt(8); // a
                deCompressedData += (char) bitReader.readInt(8); // c
                deCompressedData += (char) bitReader.readInt(8); // c

                deCompressedData += ("-");


                // Program
                deCompressedData += (char) bitReader.readInt(8);
                deCompressedData += (char) bitReader.readInt(8);

                // CourseId Eg 4200
                deCompressedData += bitReader.readInt(17);

                deCompressedData += ("-");

                // UniqueId
                deCompressedData += bitReader.readInt(20);
                deCompressedData += (".pdf;");


            }
            return deCompressedData;
        }
    }
}
