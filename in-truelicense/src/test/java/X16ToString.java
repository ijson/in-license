import de.schlichtherle.util.ObfuscatedString;
import org.junit.Test;

import java.util.ResourceBundle;

/**
 * desc:
 * version: 6.6
 * Created by cuiyongxu on 2019/4/30 9:59 PM
 */
public class X16ToString {

    @Test
    public void x16ToString() {

        String CLASS_NAME = new ObfuscatedString(new long[]{
            0x54087D071FCE4840L, 0x50F993D8A5287E71L, 0x3B4F078A163B6812L,
            0xE97B3E32094E2DB9L, 0x5C18E921228781ECL, 0xDF350057733EC2A7L
        }).toString();

        System.out.println(CLASS_NAME);

//        String obfuscatedString = new ObfuscatedString(new long[]{
//            0xF3BE4EA2CCDD7EADL, 0x5B6A9F59A1183108L
//        }).toString();
//        System.out.println(obfuscatedString);
//
//        Resources.getString("user");
//        String CN_USER = Resources.getString(
//        );
//        System.out.println(CN_USER);

    }

    @Test
    public void genObfuscatedString() {
        //Algorithm SHA1withDSA/SHA256withRSA not available in case i ...
        System.out.println(ObfuscatedString.obfuscate("CN=CYX, OU=IJSON, O=IJSON, L=BEIJING, ST=BEIJING, C=CN"));
    }

    @Test
    public void setResourceBundle() {
        ResourceBundle resources = ResourceBundle.getBundle("Resources");
    }
}
