package com.ijson.license;

import de.schlichtherle.license.LicenseManager;

public class licenseVerifyTest {
    public static void main(String[] args) {
        VerifyLicense vLicense = new VerifyLicense();
        //获取参数
        vLicense.setParam("param.properties");
        //安装证书
        LicenseManager licenseManager = vLicense.install();
        //验证证书
        vLicense.verify(licenseManager);
    }
}
