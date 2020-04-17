
package com.ijson.license;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.prefs.Preferences;
import javax.security.auth.x500.X500Principal;

import de.schlichtherle.license.LicenseManagerHelper;
import de.schlichtherle.license.param.CipherParam;
import de.schlichtherle.license.param.impl.DefaultCipherParam;
import de.schlichtherle.license.param.impl.DefaultKeyStoreParam;
import de.schlichtherle.license.param.impl.DefaultLicenseParam;
import de.schlichtherle.license.param.KeyStoreParam;
import de.schlichtherle.license.LicenseContent;
import de.schlichtherle.license.param.LicenseParam;
import de.schlichtherle.license.LicenseManager;
import de.schlichtherle.util.ObfuscatedString;

/**
 * 创建license  生成license文件
 */
public class GenerateLicenseFile {
    //common param
    private static String PRIVATEALIAS = "";
    private static String KEYPWD = "";
    private static String STOREPWD = "";
    private static String SUBJECT = "";
    private static String licPath = "";
    private static String priPath = "";
    //license content
    private static String issuedTime = "";
    private static String notBefore = "";
    private static String notAfter = "";
    private static String consumerType = "";
    private static int consumerAmount = 0;
    private static String info = "";
    private static String mac = "";
    private static String maxUserCount = "";
    // 为了方便直接用的API里的例子
    // X500Princal是一个证书文件的固有格式，详见API
    //CN=CYX, OU=IJSON, O=IJSON, L=BEIJING, ST=BEIJING, C=CN
    private final static X500Principal DEFAULTHOLDERANDISSUER = new X500Principal(
        new ObfuscatedString(new long[]{
            0x1B55B8233A244A1DL, 0x86FF93C70C9EE57AL, 0x70B875DFD514851AL,
            0xD44CDA89CD853D28L, 0x839F5F278950CD8CL, 0xB064A46637EC25A5L,
            0xACED883BED47DADBL, 0x5EE12BD2C135D5AAL}).toString());

    public void setParam(String propertiesPath) {
        // 获取参数
        Properties prop = new Properties();
        InputStream in = null;
        try {
            in = getClass().getResource("/" + propertiesPath).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            prop.load(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PRIVATEALIAS = prop.getProperty("PRIVATEALIAS");
        KEYPWD = prop.getProperty("KEYPWD");
        STOREPWD = prop.getProperty("STOREPWD");
        SUBJECT = prop.getProperty("SUBJECT");
        KEYPWD = prop.getProperty("KEYPWD");
        licPath = prop.getProperty("licPath");
        priPath = prop.getProperty("priPath");
        //license content
        issuedTime = prop.getProperty("issuedTime");
        notBefore = prop.getProperty("notBefore");
        notAfter = prop.getProperty("notAfter");
        consumerType = prop.getProperty("consumerType");
        consumerAmount = Integer.valueOf(prop.getProperty("consumerAmount"));
        mac = prop.getProperty("mac");
        maxUserCount = prop.getProperty("maxUserCount");
        info = prop.getProperty("info");

    }

    public void create() {
        try {
            LicenseManager licenseManager = LicenseManagerHelper.instance.getLicenseManager(initLicenseParams0());
            licenseManager.store((createLicenseContent()), new File(licPath));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("客户端证书生成失败!");
            return;
        }
        System.out.println("服务器端生成证书成功!");
    }

    // 返回生成证书时需要的参数
    private static LicenseParam initLicenseParams0() {
        Preferences preference = Preferences
            .userNodeForPackage(GenerateLicenseFile.class);
        // 设置对证书内容加密的对称密码
        CipherParam cipherParam = new DefaultCipherParam(STOREPWD);
        // 参数1,2从哪个Class.getResource()获得密钥库;参数3密钥库的别名;参数4密钥库存储密码;参数5密钥库密码
        KeyStoreParam privateStoreParam = new DefaultKeyStoreParam(
            GenerateLicenseFile.class, priPath, PRIVATEALIAS, STOREPWD, KEYPWD);
        LicenseParam licenseParams = new DefaultLicenseParam(SUBJECT,
            preference, privateStoreParam, cipherParam);
        return licenseParams;
    }

    // 从外部表单拿到证书的内容
    private static LicenseContent createLicenseContent() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        LicenseContent content = null;
        content = new LicenseContent();
        content.setSubject(SUBJECT);
        content.setHolder(DEFAULTHOLDERANDISSUER);
        content.setIssuer(DEFAULTHOLDERANDISSUER);
        try {
            content.setIssued(format.parse(issuedTime));
            content.setNotBefore(format.parse(notBefore));
            content.setNotAfter(format.parse(notAfter));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        content.setConsumerType(consumerType);
        content.setConsumerAmount(consumerAmount);
        content.setInfo(info);
        // 扩展 ,此处可增加mac地址，ip的校验 对象可以是一个map
        Map<String, String> extraMap = new HashMap<>();
        extraMap.put("mac", mac);
        extraMap.put("maxUserCount", maxUserCount);
        content.setExtra(extraMap);
        return content;
    }
}
