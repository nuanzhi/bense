package com.lsege.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/18
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
public class CreateSecrteKey {

    public class Keys {

    }

    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    public static final String PUBLIC_KEY = "RSAPublicKey";
    public static final String PRIVATE_KEY = "RSAPrivateKey";

    //获得公钥
    public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
        //获得map中的公钥对象 转为key对象
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        //byte[] publicKey = key.getEncoded();
        //编码返回字符串
        return encryptBASE64(key.getEncoded());
    }

    //获得私钥
    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
        //获得map中的私钥对象 转为key对象
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        //byte[] privateKey = key.getEncoded();
        //编码返回字符串
        return encryptBASE64(key.getEncoded());
    }

    public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }


    //解码返回byte
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    //编码返回字符串
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    //map对象中存放公私钥
    public static Map<String, Object> initKey() throws Exception {
        //获得对象 KeyPairGenerator 参数 RSA 1024个字节
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        //通过对象 KeyPairGenerator 获取对象KeyPair
        KeyPair keyPair = keyPairGen.generateKeyPair();

        //通过对象 KeyPair 获取RSA公私钥对象RSAPublicKey RSAPrivateKey
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        //公私钥对象存入map中
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }


    /*MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCq4khj05gQO6FJM4GCF/wbCFKni6gPNWq+pMfs
    HDJx7mZmy+VUz/9R4BPB2jKpumx/TWaWXMXihK3QCjMLrD0lZz3kBOkOLzQ1tdCbWqk12TrJyYJy
            Eo95DOE9iyYEJyYKufsoaNxh8vbf4uWrpfmhiPI3L6XRzOgZxV7LtP8ghwIDAQAB

    MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKB9FZl20UY3Jw6vSp5cKuPwpTZS
    qzxwq6yHTbR4neBO3mxMJOum+Aj1tyNhoa455eUIaTLJqvs/n2tOh7YAlsGkEgQ8EAw2yjPXnmm8
    RrW76kSbhMRXQTgg6ny+7FWvSy9InOIxoX321WygWdwitFsCdgA/VWeopZsGT+9RulPvAgMBAAEC
    gYBYI1nxZieYgEGa9vnr7oI/nLGfG9ee4eHmZohuTK+nuKi+oTLFmHUvtoJVlBDPNkzjc7MSiV61
    jUNoE0DE253u5t9Vjk6qW/EtrLFg9CQl5CBj/rojS1p+GB4MeULN9IzMdF4GfrcZcdlOnhenBG6q
    fSeASMeT4K64OtNvnFxHwQJBAPvKELPQ/ob0rtuq27u4JCXNzwpFntOQ9YqUZQqSvcribSwPTFCd
    Gf/h6YDlbC9SPhCnsZUydq3DMxVXTDZq5fUCQQCjLCbfyakuIVuTM9AyQKfyXFvaqbVvrMdgelz1
    ZMBpJBIp6EQieJUQXdub6Sm0hgaOGanDD3KoIY9rgtVoub/TAkEA4ROISrWQUWN4y7S4J947se+A
    HFaP29/BHtf4WrNCJZKytKgYOBe3nh18dlSfmM2T3Z+KByzNGhdcGr+myR5V4QJAQzOY4wvbyGrm
    my54rWmhgZh2IA1K8y5Wgq6CgHI5KFQ5wtas0QGWasItAv45NecI5hc9ql8/Wm1P8vhUSihODwJA
            GKTJfD40SUNXKhzcpFkXaJjIhhX5w6UPmUZ0VlYKSA1MzkUngTxY42HGGQD3rfjPpPWuDW9ULNt0
5+dNoKq2mg==*/

    public static void main(String[] args) {

        //(/main/*)
        String rex = "(/main//*)[\\s\\S]*";

        String key = "/main";

        System.out.println(key.matches(rex));
       /* Map<String, Object> keyMap;
        try {
            keyMap = initKey();

            System.out.println(getPublicKey(initKey()));
            //System.out.println(getPrivateKey(initKey()));

            //Key p = getPrivateKey(getPrivateKey(initKey()));

            PrivateKey a = (PrivateKey) keyMap.get(PRIVATE_KEY);

            System.out.println(1);
            String input = "xuzhongyao";
            Cipher cipher = Cipher.getInstance("RSA");
            //System.out.println(getPublicKey(keyMap));
            cipher.init(Cipher.ENCRYPT_MODE, (Key) keyMap.get(PUBLIC_KEY));
            byte[] cipherText = cipher.doFinal(input.getBytes());
            //加密后的东西
            System.out.println("cipher: " + encryptBASE64(cipherText));

            //开始解密
            cipher.init(Cipher.DECRYPT_MODE, a);
            byte[] plainText = cipher.doFinal(cipherText);
            System.out.println("plain : " + new String(plainText));




        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

}
