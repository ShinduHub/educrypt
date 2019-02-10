package com.clemens.educrypt.cipher;

public class CipherKey {

    private String cipherKey;
    private Length cipherKeyLength;

    public enum Length {DES_56, AES_128, AES_192, AES_256}

    private CipherKey() {}
    private CipherKey(String cipherKey, Length cipherKeyLength) {
        this.cipherKey = cipherKey;
        this.cipherKeyLength = cipherKeyLength;
    }

    public static CipherKey create(String cipherKey, Length cipherKeyLength) {
        return new CipherKey(cipherKey, cipherKeyLength);
    }

    public String getKey() {
        return cipherKey;
    }

    public Length getKeyLength() {
        return cipherKeyLength;
    }
}
