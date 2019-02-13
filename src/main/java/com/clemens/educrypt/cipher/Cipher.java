package com.clemens.educrypt.cipher;

public abstract class Cipher {

    protected javax.crypto.Cipher cipher;

    protected Cipher() {
    }

    protected Cipher(javax.crypto.Cipher cipher) {
        this.cipher = cipher;
    }

    public abstract byte[] encrypt(byte[] data, CipherKey cipherKey);

    public abstract byte[] decrypt(byte[] data, CipherKey cipherKey);

    public javax.crypto.Cipher getCipher() {
        return cipher;
    }
}
