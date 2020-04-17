package com.ijson.license;

import org.junit.Test;

public class GenerateLicenseFileTest {

    @Test
    public void generate() {
        GenerateLicenseFile cLicense = new GenerateLicenseFile();
        cLicense.setParam("param.properties");
        cLicense.create();
    }
}
