package org.pg4200.sol11;

import org.junit.jupiter.api.Test;
import org.pg4200.sol11.ArchiveCompressor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArchiveCompressorTest {

    public String initInputs(){
        return  "1805-OCT-21; MaritimeArchive; MAR; 03; 126; 1111;\n" +
                "1805-DEC-02; NationalArchive; NAT; 07; 084; 1780;\n" +
                "1805-OCT-21; MaritimeArchive; MAR; 03; 126; 1111;\n" +
                "1814-MAY-17; NationalArchive; NAT; 01; 001; 0001;\n" +
                "1905-JUN-07; NationalArchive; NAT; 02; 042; 0042;\n";
    }

    @Test
    public void testMedium(){
        String input = initInputs();
        ArchiveCompressor ar = new ArchiveCompressor();

        byte[] c1 = ar.compressRub(input);

        String decom = ar.decompressRub(c1);

        assertEquals(input.length(), decom.length());
    }

    @Test
    public void testSmall(){
        String input = "1814-MAY-17; NationalArchive; NAT; 01; 001; 0001;\n";
        ArchiveCompressor ar = new ArchiveCompressor();

        byte[] c1 = ar.compressRub(input);

        String dec = ar.decompressRub(c1);

        assertEquals(input.length(), dec.length());
    }

    @Test
    public void monthTests(){
        ArchiveCompressor ar = new ArchiveCompressor();

        for(int i = 1; i <= 12; i++){
            String m1 = ar.month(i);
            int m2 = ar.month(m1);
            String m3 = ar.month(m2);
            int m4 = ar.month(m3);

            assertEquals(m2, m4);
            assertTrue(m1.equalsIgnoreCase(m3));
        }
    }

    @Test
    public void monthArchives(){
        ArchiveCompressor ar = new ArchiveCompressor();

        for(int i = 1; i <= 7; i++){
            String m1 = ar.archive(i);
            String r1 = ar.archives.get(i);
            assertTrue(m1.contains(r1));

            int m2 = ar.archive(r1);
            String m3 = ar.archive(m2);

            assertTrue(m3.equalsIgnoreCase(m1));
            assertEquals(i, m2);

        }
    }

    @Test
    public void comparisons(){
        String input = initInputs();
        ArchiveCompressor ar = new ArchiveCompressor();

        byte[] c1 = ar.compressRub(input);
        byte[] s1 = ar.compress(input);

        String deco = ar.decompressRub(c1);
        String stu1 = ar.decompress(s1);

        assertEquals(input.length(), deco.length());
        assertEquals(input.length(), stu1.length());
    }

    @Test
    public void comparisonsSmall(){
        String input = "1814-MAY-17; NationalArchive; NAT; 01; 001; 0001;\n";
        ArchiveCompressor ar = new ArchiveCompressor();

        byte[] c1 = ar.compressRub(input);
        byte[] s1 = ar.compress(input);

        String deco = ar.decompressRub(c1);
        String stu1 = ar.decompress(s1);

        assertEquals(input.length(), deco.length());
        assertEquals(input.length(), stu1.length());
    }
}

