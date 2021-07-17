package com.liziczh.ddd.mesh.common.util;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * 对称加密解密
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/7/17 21:52
 */
@Slf4j
public class AESUtils {

    /**
     * AES加密
     *
     * @param data   数据
     * @param aesKey 密钥
     * @return 加密数据
     */
    public static String encrypt(String data, String aesKey) {
        String base64Str = "";
        try {
            byte[] key = aesKey.getBytes();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"));
            base64Str = Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
            log.info("加密成功{},{}", data, base64Str);
        } catch (Exception e) {
            log.error("加密异常：{}，加密数据为{}", e.getMessage(), data);
        }
        return base64Str;
    }

    /**
     * AES解密
     *
     * @param data   数据
     * @param aesKey 密钥
     * @return 解密数据
     */
    public static String decrypt(String data, String aesKey) {
        String originalString = "";
        try {
            byte[] key = aesKey.getBytes();
            byte[] encrypted1 = Base64.getDecoder().decode(data);
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] original = cipher.doFinal(encrypted1);
            originalString = new String(original);
        } catch (Exception e) {
            log.error("解密异常：{}，加密数据为{}", e.getMessage(), data);
        }
        return originalString;
    }
}
