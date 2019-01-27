package com.clemens.educrypt;

import com.clemens.educrypt.cipher.Cipher;
import com.clemens.educrypt.cipher.CipherKey;
import com.clemens.educrypt.cipher.CipherMode;
import com.clemens.educrypt.cipher.ciphers.CipherAES;
import com.clemens.educrypt.cipher.ciphers.CipherDES;

import java.util.Arrays;

public class Educrypt {

    private CipherKey cipherKey;
    private CipherMode cipherMode;
    private Cipher cipher;

    private Educrypt() {}

    private Educrypt(CipherKey cipherKey, CipherMode cipherMode) {
        this.cipherKey = cipherKey;
        this.cipherMode = cipherMode;
        switch (cipherMode) {
            case AES:
                this.cipher = new CipherAES();
                break;
            case DES:
                this.cipher = new CipherDES();
        }
    }

    public static Educrypt create(CipherKey cipherkey, CipherMode cipherMode) {
        return new Educrypt(cipherkey, cipherMode);
    }

    public String encrypt(String data) {
        return new String(cipher.encrypt(data.getBytes(), cipherKey));
    }

    public String decrypt(String data) {
        return new String(cipher.encrypt(data.getBytes(), cipherKey));
    }
}
