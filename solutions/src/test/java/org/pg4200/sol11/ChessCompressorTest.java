package org.pg4200.sol11;

import org.junit.jupiter.api.Test;
import org.pg4200.sol11.ChessCompressor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChessCompressorTest {

    @Test
    public void testCompressOnly(){
        ChessCompressor cc = new ChessCompressor();
        //String data = "1pE2E4";
        String data = "1pe2e4";

        byte[] compressed = cc.compress(data);
        byte[] rubric = cc.compressRubric(data);

        assertTrue(compressed.length <= 30);

        //String data2 = "1pC2C32pD7D63qD1A4!4pB7B5";
        String data2 = "1pc2c32pd7d63qd1a4!4pb7b5";
        byte[] compressed2 = cc.compress(data2);
        byte[] rubric2 = cc.compressRubric(data2);

        assertTrue(compressed2.length <= 120);

        //String data3 = "1pF2F32pE7E53pG2G44qD8H4!";
        String data3 = "1pf2f32pe7e53pg2g44qd8h4!";

        byte[] compressed3 = cc.compress(data3);
        byte[] rubric3 = cc.compressRubric(data3);

        assertTrue(compressed3.length <= 120);

    }

    @Test
    public void testOne(){
        ChessCompressor cc = new ChessCompressor();

        String data = "1pe2e4";
        //String data = "1pE2E4";
        byte[] compressed = cc.compress(data);
        byte[] rubric = cc.compressRubric(data);

        //assertTrue(compressed.length <= 30);
        //assertTrue(compressed.length <= rubric.length);

        String decompressed = cc.decompress(compressed);
        String decoRubric = cc.decompressRubric(rubric);

        assertEquals(data, decompressed);
        assertEquals(decompressed, decoRubric);
    }

    @Test
    public void testOneBishop(){
        ChessCompressor cc = new ChessCompressor();

        String data = "9bf1h3";
        byte[] compressed = cc.compress(data);
        byte[] rubric = cc.compressRubric(data);

        //assertTrue(compressed.length <= 30);
        //assertTrue(compressed.length <= rubric.length);

        String decompressed = cc.decompress(compressed);
        String decoRubric = cc.decompressRubric(rubric);

        assertEquals(data, decompressed);
        assertEquals(decompressed, decoRubric);
    }

    @Test
    public void testOneRook(){
        ChessCompressor cc = new ChessCompressor();

        String data = "4rh1h3";
        //String data = "1pE2E4";
        byte[] compressed = cc.compress(data);
        byte[] rubric = cc.compressRubric(data);

        //assertTrue(compressed.length <= 30);
        //assertTrue(compressed.length <= rubric.length);

        String decompressed = cc.decompress(compressed);
        String decoRubric = cc.decompressRubric(rubric);

        assertEquals(data, decompressed);
        assertEquals(decompressed, decoRubric);
    }

    @Test
    public void testOneQueen(){
        ChessCompressor cc = new ChessCompressor();

        String data = "4qe1c3";
        //String data = "1pE2E4";
        byte[] compressed = cc.compress(data);
        byte[] rubric = cc.compressRubric(data);

        //assertTrue(compressed.length <= 30);
        //assertTrue(compressed.length <= rubric.length);

        String decompressed = cc.decompress(compressed);
        String decoRubric = cc.decompressRubric(rubric);

        assertEquals(data, decompressed);
        assertEquals(decompressed, decoRubric);
    }

    @Test
    public void testOneKing(){
        ChessCompressor cc = new ChessCompressor();

        String data = "4Kd1b1";
        //String data = "1pE2E4";
        byte[] compressed = cc.compress(data);
        byte[] rubric = cc.compressRubric(data);

        //assertTrue(compressed.length <= 30);
        //assertTrue(compressed.length <= rubric.length);

        String decompressed = cc.decompress(compressed);
        String decoRubric = cc.decompressRubric(rubric);

        assertEquals(data, decompressed);
        assertEquals(decompressed, decoRubric);
    }

    @Test
    public void testOneKnight(){
        ChessCompressor cc = new ChessCompressor();

        String data = "9kg1h3";
        //String data = "1pE2E4";
        byte[] compressed = cc.compress(data);
        byte[] rubric = cc.compressRubric(data);

        //assertTrue(compressed.length <= 30);
        //assertTrue(compressed.length <= rubric.length);

        String decompressed = cc.decompress(compressed);
        String decoRubric = cc.decompressRubric(rubric);

        assertEquals(data, decompressed);
        assertEquals(decompressed, decoRubric);
    }

    @Test
    public void testQuickMate(){
        ChessCompressor cc = new ChessCompressor();

        String data = "1pc2c32pd7d63qd1a4!4pb7b5";
        byte[] compressed = cc.compress(data);
        byte[] rubric = cc.compressRubric(data);

        //assertTrue(compressed.length <= 120);
        //assertTrue(compressed.length <= rubric.length);

        String decompressed = cc.decompress(compressed);
        String decoRubric = cc.decompressRubric(rubric);

        assertEquals(data, decompressed);
        assertEquals(decompressed, decoRubric);
    }

    @Test
    public void testQuickMate2(){
        ChessCompressor cc = new ChessCompressor();

        String data = "1pf2f32pe7e53pg2g44qd8h4!";
        byte[] compressed = cc.compress(data);
        byte[] rubric = cc.compressRubric(data);

        //assertTrue(compressed.length <= 120);
        //assertTrue(compressed.length <= rubric.length);

        String decompressed = cc.decompress(compressed);
        String decoRubric = cc.decompressRubric(rubric);

        assertEquals(data, decompressed);
        assertEquals(decompressed, decoRubric);
    }

    @Test
    public void testSmall(){
        ChessCompressor cc = new ChessCompressor();
        //String data = "1pF2F32pE7E53pG2G44qD8H4";
        //String data = "1f2f32e7e53g2g44d8h4";
        //String data = "10pe2e311bc1a3!";
        String data = "10bc1a3!";

        byte[] compressed = cc.compress(data);
        byte[] rubric = cc.compressRubric(data);

        String decompressed = cc.decompress(compressed);
        String decoRubric = cc.decompressRubric(rubric);

        assertEquals(data, decompressed);
        assertEquals(decompressed, decoRubric);
    }

    @Test
    public void testAbsurd(){
        ChessCompressor cc = new ChessCompressor();
        //String data = "1pF2F32pE7E53pG2G44qD8H4";
        //String data = "1f2f32e7e53g2g44d8h4";
        String data = "1pe2e3!";

        byte[] compressed = cc.compress(data);
        byte[] rubric = cc.compressRubric(data);

        String decompressed = cc.decompress(compressed);
        String decoRubric = cc.decompressRubric(rubric);

        assertEquals(data, decompressed);
        assertEquals(decompressed, decoRubric);
    }

    @Test
    public void testLong(){
        ChessCompressor cc = new ChessCompressor();
        //String data = "1pF2F32pE7E53pG2G44qD8H4";
        //String data = "1f2f32e7e53g2g44d8h4";
        String data = "1pe2e42pe7e53kg1f34kb8c65kb1c36kg8f67pa2a38pd7d59pe4d510kf6d5";

        //String data = "1pe2e42pe7e53kg1f34kb8c65kb1c36kg8f67pa2a38pd7d59pe4d5";


        byte[] compressed = cc.compress(data);
        byte[] rubric = cc.compressRubric(data);

        String decompressed = cc.decompress(compressed);
        String decoRubric = cc.decompressRubric(rubric);

        assertEquals(data, decompressed);
        assertEquals(decompressed, decoRubric);
    }

    @Test
    public void testRando(){
        ChessCompressor cc = new ChessCompressor();
        //String data = "1pF2F32pE7E53pG2G44qD8H4";
        String data = "1pf2f32re7e53bg2g44qd8h49kd1d2";
        //String data = "1pe2e42pe7e53kg1f34kb8c65kb1c36kg8f67pa2a38pd7d59pe4d510kf6d5";

        byte[] compressed = cc.compress(data);
        byte[] rubric = cc.compressRubric(data);

        String decompressed = cc.decompress(compressed);
        String decoRubric = cc.decompressRubric(rubric);

        assertEquals(data, decompressed);
        assertEquals(decompressed, decoRubric);
    }

    public void testWeird(){
        ChessCompressor cc = new ChessCompressor();
        //String data = "1pF2F32pE7E53pG2G44qD8H4";
        //String data = "1f2f32e7e53g2g44d8h4";
        String data = "1. Pawn from e2 to e4. \n2. Pawn from e7 to e5! \n3. Rook from e2 to e5. \n4. King from d1 to d2. \n5. Queen from e8 to e7. \n6. Knight from b1 to c3. \n7. Knight from g8 to h6. \n8. Bishop from c1 to a3. \n9. Bishop from c8 to a6.";

        byte[] compressed = cc.compress(data);
        //byte[] rubric = cc.compressRubric(data);

        String decompressed = cc.decompress(compressed);
        //String decoRubric = cc.decompressRubric(rubric);

        assertEquals(data, decompressed);
        //assertEquals(decompressed, decoRubric);
    }
}
