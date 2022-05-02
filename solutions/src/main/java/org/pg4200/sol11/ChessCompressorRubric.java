package org.pg4200.sol11;

import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

public class ChessCompressorRubric extends GenericCompressor{
    @Override
    public byte[] compress(String moves){
        BitWriter writer = new BitWriter();
        String move = "";

        for(int i=0; i<moves.length(); i++){
            char c = moves.charAt(i);
            if(c >= '0' && c <= '9'){
                move += c;
            }
            else if(c >= 'A' && c <= 'z'){
                writer.write(Integer.parseInt(move), 9);
                move = "";

                //Piece - Always one character. Full ascii for less stress (though improvements can be made).
                writer.write(c-'A', 8); //say full ascii for less stress

                // Origin - letter + number. Letters always between A-H and numbers 1-8.
                writer.write(moves.charAt(i+1) - 'a', 3);
                writer.write(moves.charAt(i+2)-1, 3);

                //Destination - same type as origin.
                writer.write(moves.charAt(i+3) - 'a', 3);
                writer.write(moves.charAt(i+4)-1, 3);
                i += 4;

                if(i+1 == moves.length()){
                    writer.write(0, 1);
                }
                else {
                    char ch = moves.charAt(i+1);
                    if(ch == '!'){
                        writer.write(1, 1);
                    }
                    else{
                        writer.write(0, 1);
                    }
                }

            }
        }

        return writer.extract();

    }

    @Override
    public String decompress(byte[] data){

        BitReader reader = new BitReader(data);
        String result = "";
        int entries = (data.length * 8) / 30;

        for(int i=0; i<entries; i++){
            //number
            result += reader.readInt(9);

            //piece
            result += (char)('A' + reader.readInt(8));

            //origin
            result += (char)('a' + reader.readInt(3));
            result += ( reader.readInt(3) + 1);

            //destination
            result += (char)('a' + reader.readInt(3));
            result += (reader.readInt(3) + 1);

            //check
            boolean check = reader.readBoolean();
            if (check){
                result += "!";
            }
        }
        return result;
    }
}
