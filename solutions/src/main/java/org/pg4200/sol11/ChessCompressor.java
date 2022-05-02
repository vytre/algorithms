package org.pg4200.sol11;

import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Objects;

public class ChessCompressor extends GenericCompressor{

    /*
    The rubric contains the solution. The methods compress and decompress in this class
    would normally be calling student code for evaluation :)
    In this case, the methods call the rubric again.
     */
    ChessCompressorRubric rubric = new ChessCompressorRubric();
    public byte[] compressRubric(String input) {
        return rubric.compress(input);
    }

    public String decompressRubric(byte[] input) {
        return rubric.decompress(input);
    }


    @Override
    public byte[] compress(String moves) {
        return rubric.compress(moves);
    }


    @Override
    public String decompress(byte[] data) {
       return rubric.decompress(data);
    }

}
