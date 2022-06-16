package pg4200_1027;

import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

public class Ex05 {
    public static class CourseFeedBack { // PG 4200 456987 2022 JUN 06


        // I tried using a hashmap to get the full Program Name, but that caused more harm than good.
        // I thought it would be better to submit something that works, rather than something that was more correct, but doesn't work.
        // I will submit my testFiles for this Exercise to show you what I managed to compress



        /**
         * Strings I compressed in my Tests
         * PG4200:456987 / 2022-JUN-16. File: feedback-PG4200-456987.pdf;
         * AI1701:987456 / 2021-AUG-13. File: feedback-AI1701-987456.pdf;
         * FP1453:963258 / 2022-OCT-30. File: feedback-FP1453-963258.pdf;
         * SC1007:741654 / 2022-JAN-15. File: feedback-SC1007-741654.pdf;
         * DS1112:159753 / 2020-MAR-18. File: feedback-DS1112-159753.pdf;
         * **/

        public byte[] compression(String feedBackList){
            BitWriter bitWriter = new BitWriter();

            // Program
            for (int i = 0; i < feedBackList.length(); i++) {
                bitWriter.write(feedBackList.charAt(i),8);
                bitWriter.write(feedBackList.charAt(i+1),8);

                // CourseId
                String courseNr = "";
                for (int j = 2; j < 6; j++) {
                    char c = feedBackList.charAt(j);
                    courseNr += c;
                }
                bitWriter.write(Integer.parseInt(courseNr),17);

                // UniqueId
                String uniqueId = "";
                for (int j = 7; j < 13; j++) {
                    char c = feedBackList.charAt(j);
                    uniqueId += c;
                }
                bitWriter.write(Integer.parseInt(uniqueId),20);

                // Year
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

                // Program
                bitWriter.write(feedBackList.charAt(i),8);
                bitWriter.write(feedBackList.charAt(i+1),8);

                // CourseId
                bitWriter.write(Integer.parseInt(courseNr),17);

                // UniqueId
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
