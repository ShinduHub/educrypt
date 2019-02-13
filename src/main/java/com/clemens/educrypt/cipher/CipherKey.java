package com.clemens.educrypt.cipher;

import com.clemens.educrypt.Educrypt;

import javax.crypto.spec.SecretKeySpec;

public class CipherKey {

    private String rawCipherKey;
    private SecretKeySpec cipherKey;
    private Educrypt.Mode cipherMode;

    private CipherKey() {
    }

    private CipherKey(String rawCipherKey) {
        this.rawCipherKey = rawCipherKey;
    }

    public static CipherKey create(String cipherKey) {
        return new CipherKey(cipherKey);
    }

    public void init(Educrypt.Mode cipherMode) {
        this.cipherMode = cipherMode;
        cipherKey = new SecretKeySpec(rawCipherKey.getBytes(), cipherMode.toString());
    }

    public String getKey() {
        return rawCipherKey;
    }
}
