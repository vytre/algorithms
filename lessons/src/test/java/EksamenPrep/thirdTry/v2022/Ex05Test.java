package EksamenPrep.thirdTry.v2022;

import eksamenPrep.thirdTry.v2022.Ex05;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Ex05Test {
    @Test
    public void vegardTest(){
        Ex05.Archive archive  = new Ex05.Archive();

        String data = "255";

        byte[] compressed = archive.compress(data);

        String deCompressed = archive.deCompress(compressed);
        System.out.println(deCompressed);
    }

}