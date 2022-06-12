package EksamenPrep.compression;

import eksamenPrep.compression.CompressInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompressStringIntTest {

    @Test
    public void vegardTest(){
        CompressInteger.Archive compressStringInt = new CompressInteger.Archive();
        String data = "254";

        // Compressed Byte Array
        byte[] compressed = compressStringInt.compress(data);

        // DeCompressed Byte Array To String
        String deCompressed = compressStringInt.deCompress(compressed);

        System.out.println(deCompressed);
        assertEquals(data,deCompressed);
    }

}