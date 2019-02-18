package com.clemens.educrypt;

import com.clemens.educrypt.cipher.Cipher;
import com.clemens.educrypt.cipher.CipherKey;
import com.clemens.educrypt.cipher.ciphers.CipherAES;
import com.clemens.educrypt.cipher.ciphers.CipherDES;
import java.nio.charset.StandardCharsets;

/**
 * Main Class and Wrapper around the library.
 */
public class Educrypt {
  /**
   * CipherKey used.
   */
  private CipherKey cipherKey;

  /**
   * Cryptographic algorithm used.
   */
  private CipherAlgorithm cipherAlgorithm;

  /**
   * Cipher used.
   */
  private Cipher cipher;

  /**
   * Constructor accepts the key and algorithm used.
   *
   * @param cipherKey       Used for encryption and decryption.
   * @param cipherAlgorithm Cryptographic algorithm used.
   */
  private Educrypt(CipherKey cipherKey, CipherAlgorithm cipherAlgorithm) {
    this.cipherKey = cipherKey;
    cipherKey.init(cipherAlgorithm);
    this.cipherAlgorithm = cipherAlgorithm;
    switch (cipherAlgorithm) {
      case AES:
        this.cipher = CipherAES.create();
        break;
      case DES:
        this.cipher = CipherDES.create();
    }
  }

  /**
   * Creates and returns a new CipherKey object.
   *
   * @param cipherKey       Cipher Key used.
   * @param cipherAlgorithm Cryptographic Algorithm used.
   * @return The Educrypt Object.
   */
  public static Educrypt create(CipherKey cipherKey, CipherAlgorithm cipherAlgorithm) {
    return new Educrypt(cipherKey, cipherAlgorithm);
  }

  /**
   * Encrypt a String.
   *
   * @param inputString String which will be encrypted.
   * @return Encrypted String.
   */
  public String encrypt(String inputString) {
    return new String(cipher.encrypt(inputString.getBytes(StandardCharsets.UTF_8), cipherKey));
  }

  /**
   * Decrypt a String.
   *
   * @param inputString String which will be decrypted.
   * @return Decrypted String.
   */
  public String decrypt(String inputString) {
    return new String(cipher.decrypt(inputString.getBytes(StandardCharsets.UTF_8), cipherKey));
  }

  /**
   * Getter for the CipherKey.
   *
   * @return CipherKey object used.
   */
  public CipherKey getCipherKey() {
    return cipherKey;
  }

  /**
   * Getter for the CipherAlgorithm.
   *
   * @return CipherAlgorithm used.
   */
  public CipherAlgorithm getCipherAlgorithm() {
    return cipherAlgorithm;
  }

  /**
   * Getter for the Cipher.
   *
   * @return Cipher object.
   */
  public Cipher getCipher() {
    return cipher;
  }

  /**
   * Enum which represents the cryptographic algorithm.
   */
  public enum CipherAlgorithm {
    /**
     * AES block cipher.
     */
    AES,
    /**
     * DES block cipher.
     */
    DES
  }
}
