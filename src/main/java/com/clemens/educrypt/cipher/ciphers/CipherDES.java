package com.clemens.educrypt.cipher.ciphers;

import com.clemens.educrypt.Educrypt;
import com.clemens.educrypt.cipher.Cipher;
import com.clemens.educrypt.cipher.CipherKey;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;

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
    throw new RuntimeException("Could not create an AES cipher!\n Please contact your teacher!");
  }

  private void initCipher() {}

  @Override
  public byte[] encrypt(byte[] data, CipherKey cipherKey) {
    return super.crypt(CryptMode.ENCRYPT, Educrypt.Mode.DES, data, cipherKey);
  }

  @Override
  public byte[] decrypt(byte[] data, CipherKey cipherKey) {
    return super.crypt(CryptMode.DECRYPT, Educrypt.Mode.DES, data, cipherKey);
  }
}
