package com.clemens.educrypt_test;

import com.clemens.educrypt.Educrypt;
import com.clemens.educrypt.cipher.CipherKey;
import java.security.SecureRandom;
import junit.framework.TestCase;

/**
 * Class which tests the library.
 */

public class EducryptTest extends TestCase {
  /**
   * Tests the library.
   */
  public void test() {
    SecureRandom secureRandom = new SecureRandom();
    byte[] randomByteKey = new byte[16];
    secureRandom.nextBytes(randomByteKey);
    String randomKey = new String(randomByteKey);

    Educrypt educryptInstanceAes =
        Educrypt.create(CipherKey.create(randomKey), Educrypt.CipherAlgorithm.AES);

    String input = "hello";
    String encryptedAes = educryptInstanceAes.encrypt(input);
    String outAes = educryptInstanceAes.decrypt(encryptedAes);

    System.out.println(encryptedAes);
    System.out.println(outAes);
    assertEquals(input, outAes);

    Educrypt educryptInstanceDes =
        Educrypt.create(CipherKey.create(randomKey), Educrypt.CipherAlgorithm.DES);

    String encryptedDes = educryptInstanceDes.encrypt(input);
    String outDes = educryptInstanceDes.decrypt(encryptedDes);

    System.out.println(encryptedDes);
    System.out.println(outDes);
    assertEquals(input, outDes);
  }
}
