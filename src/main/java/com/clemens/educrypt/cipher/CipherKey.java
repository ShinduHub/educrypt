package com.clemens.educrypt.cipher;

import com.clemens.educrypt.Educrypt;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.spec.SecretKeySpec;

/**
 * Abstract Cipher. One implementation per cryptographic algorithm.
 */
public class CipherKey {
  /**
   * Raw key used.
   */
  private String stringKey;

  /**
   * Representation of an cryptographic key in Java.
   */
  private SecretKeySpec cipherKey;

  /**
   * Cipher algorithm used.
   */
  private Educrypt.CipherAlgorithm cipherAlgorithm;

  /**
   * Constructor accepts the key as String.
   *
   * @param stringKey Key which will be used for encryption.
   */
  private CipherKey(String stringKey) {
    this.stringKey = stringKey;
  }

  /**
   * Creates and returns a new CipherKey object.
   *
   * @param cipherKey Key which will be used for encryption.
   * @return The CipherKey object.
   */
  public static CipherKey create(String cipherKey) {
    return new CipherKey(cipherKey);
  }

  /**
   * Initializes the SecretKeySpec (javas representation of an key used for encryption).
   *
   * @param cipherAlgorithm The key creation depends on the encryption algorithm used.
   */
  public void init(Educrypt.CipherAlgorithm cipherAlgorithm) {
    this.cipherAlgorithm = cipherAlgorithm;
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
      byte[] subCipherKey = new byte[cipherAlgorithm == Educrypt.CipherAlgorithm.AES ? 16 : 8];
      System.arraycopy(messageDigest.digest(stringKey.getBytes(StandardCharsets.UTF_8)), 0,
          subCipherKey, 0, (cipherAlgorithm == Educrypt.CipherAlgorithm.AES) ? 16 : 8);
      cipherKey = new SecretKeySpec(subCipherKey, cipherAlgorithm.toString());
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }

  /**
   * Getter for the key as String
   *
   * @return The key as String
   */
  public String getStringKey() {
    return stringKey;
  }

  /**
   * Getter for the SecretKeySpec
   *
   * @return The SecretKeySpec
   */
  SecretKeySpec getCipherKey() {
    return cipherKey;
  }
}
