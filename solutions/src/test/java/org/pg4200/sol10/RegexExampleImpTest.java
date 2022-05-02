package org.pg4200.sol10;

import org.pg4200.ex10.RegexExample;
import org.pg4200.ex10.RegexTestTemplate;

public class RegexExampleImpTest extends RegexTestTemplate {
    @Override
    protected RegexExample getNewInstance() {
        return new RegexExampleImp();
    }
}
