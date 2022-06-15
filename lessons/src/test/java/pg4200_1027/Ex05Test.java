package pg4200_1027;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex05Test {
    @Test
    public void testCompression(){
        Ex05.CourseFeedBack courseFeedBack = new Ex05.CourseFeedBack();



        // Programming-PG4200:456987 / 2022-JUN-06. File: feedback- PG4200-456987.pdf;
        String data = "PG4200:456987 / 2022-JUN-16. File: ";

        byte[] byteArray = courseFeedBack.compression(data);
        String deCompressedData = courseFeedBack.decompression(byteArray);

        System.out.println(deCompressedData);

        //           Expected actual
        assertEquals(data,deCompressedData);


    }

}