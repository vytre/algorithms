package EksamenPrep.compression;

import eksamenPrep.compression.VegardsArchiveCompressor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VegardsArchiveCompressorTest {
    @Test
    public void testVegard(){

        VegardsArchiveCompressor.archiveCompressor vc = new VegardsArchiveCompressor.archiveCompressor();
        String data = "NOR13131020";

        byte[] myByteArray = vc.compress(data);

        String myData = vc.deCompress(myByteArray);

        System.out.println(myData);

        assertEquals(data,myData);
    }

}