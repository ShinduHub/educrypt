package com.clemens.educrypt;

import com.clemens.educrypt.cipher.Cipher;
import com.clemens.educrypt.cipher.CipherKey;
import com.clemens.educrypt.cipher.ciphers.CipherAES;
import com.clemens.educrypt.cipher.ciphers.CipherDES;

public class Educrypt {

    private CipherKey cipherKey;
    private Mode cipherMode;
    private Cipher cipher;

    public enum Mode {AES, DES}

    private Educrypt() {
    }

    private Educrypt(CipherKey cipherKey, Mode cipherMode) {
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

    public static Educrypt create(CipherKey cipherkey, Mode cipherMode) {
        return new Educrypt(cipherkey, cipherMode);
    }

    public String encrypt(String data) {
        return new String(cipher.encrypt(data.getBytes(), cipherKey));
    }

    public String decrypt(String data) {
        return new String(cipher.encrypt(data.getBytes(), cipherKey));
    }

    public CipherKey getCipherKey() {
        return cipherKey;
    }

    public Mode getCipherMode() {
        return cipherMode;
    }

    public Cipher getCipher() {
        return cipher;
    }
}
