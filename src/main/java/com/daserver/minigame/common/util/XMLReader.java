package com.daserver.minigame.common.util;

import lombok.Getter;

import java.io.IOException;
import java.util.Properties;

/**
 * Gets values from the pom.xml for us to us to use
 */
public class XMLReader {
    @Getter
    private java.io.InputStream is;
    @Getter
    private java.util.Properties p;
    public XMLReader(String file) {
        is = this.getClass().getResourceAsStream(file);
        p = new Properties();
    }

    public String readString(String property) {
        return p.getProperty(property);
    }
}
