package com.clemens.educrypt.cipher;

public abstract class Cipher {



    public abstract byte[] encrypt(byte[] data, CipherKey cipherKey);
    public abstract byte[] decrypt(byte[] data, CipherKey cipherKey);

}
