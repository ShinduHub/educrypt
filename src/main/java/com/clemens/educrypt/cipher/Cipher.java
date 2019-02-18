package com.clemens.educrypt.cipher;

import com.clemens.educrypt.Educrypt;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;

/**
 * Abstract Cipher class
 */

public abstract class Cipher {
  /**
   * Java Cipher
   */
  private javax.crypto.Cipher cipher;

  /**
   * Constructor accepts the java Cipher.
   *
   * @param cipher Java Cipher.
   */
  protected Cipher(javax.crypto.Cipher cipher) {
    this.cipher = cipher;
  }

  /**
   * Encrypt the given input bytes with the given CipherKey.
   *
   * @param inputBytes Bytes, which will be encrypted.
   * @param cipherKey  Key, used for encryption.
   * @return The encrypted bytes.
   */
  public abstract byte[] encrypt(byte[] inputBytes, CipherKey cipherKey);

  /**
   * Decrypt the given input bytes with the given CipherKey.
   *
   * @param inputBytes Bytes, which will be decrypted.
   * @param cipherKey  Key, used for decryption.
   * @return The decrypted bytes.
   */
  public abstract byte[] decrypt(byte[] inputBytes, CipherKey cipherKey);

  /**
   * Implements encryption and decryption for all cipher algorithms.
   *
   * @param cryptMode       Crypt cipherAlgorithm, either ENCRYPTION or DECRYPTION.
   * @param cipherAlgorithm CipherAlgorithm, either AES or DES.
   * @param data            Data in raw Bytes, which will be encrypted or decrypted.
   * @param cipherKey       CipherKey used for encryption or decryption.
   * @return The bytes encrypted or decrypted.
   */
  protected byte[] crypt(CryptMode cryptMode, Educrypt.CipherAlgorithm cipherAlgorithm, byte[] data,
      CipherKey cipherKey) {
    try {
      cipher.init(cryptMode == CryptMode.ENCRYPT ? javax.crypto.Cipher.ENCRYPT_MODE
                                                 : javax.crypto.Cipher.DECRYPT_MODE,
          cipherKey.getCipherKey(),
          new IvParameterSpec(new byte[cipherAlgorithm == Educrypt.CipherAlgorithm.AES ? 16 : 8]));
      switch (cryptMode) {
        case ENCRYPT:
          return Base64.getEncoder().encode(cipher.doFinal(data));
        case DECRYPT:
          return cipher.doFinal(Base64.getDecoder().decode(data));
      }
    } catch (IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException
        | InvalidKeyException e) {
      e.printStackTrace();
    }
    throw new RuntimeException("could not ".concat(cryptMode.toString())
                                   .concat(" the given string: ")
                                   .concat(Arrays.toString(data))
                                   .concat("\nPlease contact your teacher!"));
  }

  /**
   * Enum which represents the two cryptographic modes.
   */
  protected enum CryptMode {
    /**
     * Encryption mode.
     */
    ENCRYPT,
    /**
     * Decryption mode.
     */
    DECRYPT
  }
}
