package com.clemens.educrypt.cipher;

public class CipherKey {

    private String cipherKey;
    private CipherKeyLength cipherKeyLength;

    private CipherKey() {}
    private CipherKey(String cipherKey, CipherKeyLength cipherKeyLength) {
        this.cipherKey = cipherKey;
        this.cipherKeyLength = cipherKeyLength;
    }

    public static CipherKey createKey(String cipherKey, CipherKeyLength cipherKeyLength) {
        return new CipherKey(cipherKey, cipherKeyLength);
    }

    public String getKey() {
        return cipherKey;
    }

    public CipherKeyLength getKeyLength() {
        return cipherKeyLength;
    }
}
