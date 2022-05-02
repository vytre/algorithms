package org.pg4200.sol11;

public abstract class GenericCompressor {
    public abstract byte[] compress(String input);
    public abstract String decompress(byte[] input);
}
