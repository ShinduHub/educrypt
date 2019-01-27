package com.clemens.educrypt.cipher.ciphers;

import com.clemens.educrypt.cipher.Cipher;
import com.clemens.educrypt.cipher.CipherKey;

public class CipherDES extends Cipher {

    @Override
    public byte[] encrypt(byte[] data, CipherKey cipherKey) {
        return data;
    }

    @Override
    public byte[] decrypt(byte[] data, CipherKey cipherKey) {
        return data;
    }
}
