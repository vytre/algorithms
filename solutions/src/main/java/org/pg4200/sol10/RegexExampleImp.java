package org.pg4200.sol10;

import org.pg4200.ex10.RegexExample;

public class RegexExampleImp implements RegexExample {
    @Override
    public String solutionA() {
        return "Exercise [0-9]{1,2}:\nFile: Ex[0-9]{1,2}.(java|txt)";
    }

    @Override
    public String solutionB() {
        return "@Bogdan: " +
                ".*" +
                "(( )*" +
                "((A|a)lgdat)|" +
                "((A|a)lgorithms)|" +
                "((A|a)lgorithm)|" +
                "((P|p)g4200)" +
                ")+" +
                ".*" +
                " ?";
    }
}
