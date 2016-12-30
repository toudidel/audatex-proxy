package pl.coderion.util;

import com.audatex.b2b.serviceinterface_v1.B2BParameter;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class ParameterUtil {

    public static B2BParameter newParameter(String name, String value) {
        B2BParameter b2BParameter = new B2BParameter();
        b2BParameter.setName(name);
        b2BParameter.setValue(value);
        return b2BParameter;
    }
}
