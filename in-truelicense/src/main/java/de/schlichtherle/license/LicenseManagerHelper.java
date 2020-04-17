package de.schlichtherle.license;

import de.schlichtherle.license.param.LicenseParam;

public enum LicenseManagerHelper {

    instance;

    public LicenseManager getLicenseManager(LicenseParam licenseParams) {
        return new LicenseManager(licenseParams);
    }
}
