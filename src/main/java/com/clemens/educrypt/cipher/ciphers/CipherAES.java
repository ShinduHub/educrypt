package com.clemens.educrypt.cipher.ciphers;

import com.clemens.educrypt.Educrypt;
import com.clemens.educrypt.cipher.Cipher;
import com.clemens.educrypt.cipher.CipherKey;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;

public class CipherAES extends Cipher {
  private CipherAES() throws NoSuchPaddingException, NoSuchAlgorithmException {
    super(javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding"));
  }

  public static CipherAES create() {
    try {
      return new CipherAES();
    } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    throw new RuntimeException("Could not create an AES cipher!\n Please contact your teacher!");
  }

  @Override
  public byte[] encrypt(byte[] data, CipherKey cipherKey) {
    return super.crypt(CryptMode.ENCRYPT, Educrypt.Mode.AES, data, cipherKey);
  }

  @Override
  public byte[] decrypt(byte[] data, CipherKey cipherKey) {
    return super.crypt(CryptMode.DECRYPT, Educrypt.Mode.AES, data, cipherKey);
  }
}
