package org.pg4200.sol01;

import org.pg4200.ex01.ArrayUtils;
import org.pg4200.ex01.ArrayUtilsTestTemplate;
import org.pg4200.sol02.sol01.ArrayUtilsImp;

public class ArrayUtilsImpTest extends ArrayUtilsTestTemplate {

    @Override
    protected ArrayUtils getNewInstance() {
        return new ArrayUtilsImp();
    }
}
