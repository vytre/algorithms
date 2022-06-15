package pg4200_1027;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex05Test {
    @Test
    public void testProgramming(){
        Ex05.CourseFeedBack courseFeedBack = new Ex05.CourseFeedBack();


        // Programming-PG4200:456987 / 2022-JUN-06. File: feedback-PG4200-456987.pdf;
        String data = "PG4200:456987 / 2022-JUN-16. File: feedback-PG4200-456987.pdf;";

        byte[] byteArray = courseFeedBack.compression(data);
        String deCompressedData = courseFeedBack.decompression(byteArray);

        System.out.println(deCompressedData);

        assertEquals(data,deCompressedData);
    }

    @Test
    public void testAi(){
        Ex05.CourseFeedBack courseFeedBack = new Ex05.CourseFeedBack();


        // ArtificialIntelligence-AI1701:987456 / 2021-AUG-13. File: feedback-AI1701-987456.pdf;
                   String data = "AI1701:987456 / 2021-AUG-13. File: feedback-AI1701-987456.pdf;";

        byte[] byteArray = courseFeedBack.compression(data);
        String deCompressedData = courseFeedBack.decompression(byteArray);

        System.out.println(deCompressedData);


        assertEquals(data,deCompressedData);
    }

    @Test
    public void testFrontend(){
        Ex05.CourseFeedBack courseFeedBack = new Ex05.CourseFeedBack();



        // FrontendProgramming-FP1453:963258 / 2022-OCT-30. File: feedback-FP1453-963258.pdf;
                String data = "FP1453:963258 / 2022-OCT-30. File: feedback-FP1453-963258.pdf;";

        byte[] byteArray = courseFeedBack.compression(data);
        String deCompressedData = courseFeedBack.decompression(byteArray);

        System.out.println(deCompressedData);


        assertEquals(data,deCompressedData);
    }

    @Test
    public void testCyber(){
        Ex05.CourseFeedBack courseFeedBack = new Ex05.CourseFeedBack();



        // Cybersecurity-SC1007:741654 / 2022-JAN-05. File: feedback-SC1007-741654.pdf
          String data = "SC1007:741654 / 2022-JAN-15. File: feedback-SC1007-741654.pdf;";

        byte[] byteArray = courseFeedBack.compression(data);
        String deCompressedData = courseFeedBack.decompression(byteArray);

        System.out.println(deCompressedData);

        assertEquals(data,deCompressedData);
    }

    @Test
    public void testDataScience(){
        Ex05.CourseFeedBack courseFeedBack = new Ex05.CourseFeedBack();



        // DataScience-DS0112:159753 / 2020-MAR-08. File: feedback-DS0112-159753.pdf;
        String data = "DS1112:159753 / 2020-MAR-18. File: feedback-DS1112-159753.pdf;";

        byte[] byteArray = courseFeedBack.compression(data);
        String deCompressedData = courseFeedBack.decompression(byteArray);

        System.out.println(deCompressedData);

        assertEquals(data,deCompressedData);
    }
}