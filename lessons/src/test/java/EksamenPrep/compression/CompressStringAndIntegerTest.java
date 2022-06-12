package EksamenPrep.compression;

import eksamenPrep.compression.CompressStringAndInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompressStringAndIntegerTest {

    @Test
    public void vegardTest(){
        CompressStringAndInteger.CompressStringAndInt compressStringAndInt = new CompressStringAndInteger.CompressStringAndInt();
        String data = "NOR127";

        byte[] compressedData = compressStringAndInt.compress(data);
        String deCompressedData = compressStringAndInt.deCompress(compressedData);

        System.out.println(data);
        assertEquals(data,deCompressedData);


    }

}