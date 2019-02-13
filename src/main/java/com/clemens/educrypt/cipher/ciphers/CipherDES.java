package com.clemens.educrypt.cipher.ciphers;

import com.clemens.educrypt.cipher.Cipher;
import com.clemens.educrypt.cipher.CipherKey;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class CipherDES extends Cipher {

    private CipherDES() throws NoSuchPaddingException, NoSuchAlgorithmException {
        super(javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding"));
        initCipher();
    }

    public static CipherDES create() {
        try {
            return new CipherDES();
        } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Could not create a AES cipher!\n Please contact your teacher!");
    }

    private void initCipher() {

    }

    @Override
    public byte[] encrypt(byte[] data, CipherKey cipherKey) {
        return data;
    }

    @Override
    public byte[] decrypt(byte[] data, CipherKey cipherKey) {
        return data;
    }
}
