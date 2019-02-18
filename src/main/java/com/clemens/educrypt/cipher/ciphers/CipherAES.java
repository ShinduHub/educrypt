package com.clemens.educrypt.cipher.ciphers;

import com.clemens.educrypt.Educrypt;
import com.clemens.educrypt.cipher.Cipher;
import com.clemens.educrypt.cipher.CipherKey;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;

/**
 * Implements the Cipher class for the AES algorithm.
 */

public class CipherAES extends Cipher {
  /**
   * Constructor initializes the Java Cipher with the AES algorithm.
   *
   * @throws NoSuchPaddingException   Exception thrown by the Cipher initialization.
   * @throws NoSuchAlgorithmException Exception thrown by the Cipher initialization.
   */
  private CipherAES() throws NoSuchPaddingException, NoSuchAlgorithmException {
    super(javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding"));
  }

  /**
   * Creates and returns a new CipherAES object.
   *
   * @return The CipherAES object.
   */
  public static CipherAES create() {
    try {
      return new CipherAES();
    } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    throw new RuntimeException("Could not create an AES cipher!\n Please contact your teacher!");
  }

  /**
   * Encrypt bytes with the AES algorithm.
   *
   * @param inputBytes Bytes, which will be encrypted.
   * @param cipherKey  Key, used for encryption.
   * @return The encrypted bytes.
   */
  @Override
  public byte[] encrypt(byte[] inputBytes, CipherKey cipherKey) {
    return super.crypt(CryptMode.ENCRYPT, Educrypt.CipherAlgorithm.AES, inputBytes, cipherKey);
  }

  /**
   * Decrypt bytes with the AES algorithm.
   *
   * @param inputBytes Bytes, which will be decrypted.
   * @param cipherKey  Key, used for decryption.
   * @return The decrypted bytes.
   */
  @Override
  public byte[] decrypt(byte[] inputBytes, CipherKey cipherKey) {
    return super.crypt(CryptMode.DECRYPT, Educrypt.CipherAlgorithm.AES, inputBytes, cipherKey);
  }
}
