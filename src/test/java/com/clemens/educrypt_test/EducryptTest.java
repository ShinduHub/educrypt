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
    for (int i = 0; i < 100; i++) {
      SecureRandom secureRandom = new SecureRandom();

      byte[] randomByteKey = new byte[512];
      secureRandom.nextBytes(randomByteKey);
      String randomKey = new String(randomByteKey);

      byte[] randomByteString = new byte[2048];
      secureRandom.nextBytes(randomByteString);
      String input = new String(randomByteString);

      Educrypt educryptInstanceAes =
          Educrypt.create(CipherKey.create(randomKey), Educrypt.CipherAlgorithm.AES);
      String encryptedAes = educryptInstanceAes.encrypt(input);
      String outAes = educryptInstanceAes.decrypt(encryptedAes);
      assertEquals(input, outAes);

      Educrypt educryptInstanceDes =
          Educrypt.create(CipherKey.create(randomKey), Educrypt.CipherAlgorithm.DES);
      String encryptedDes = educryptInstanceDes.encrypt(input);
      String outDes = educryptInstanceDes.decrypt(encryptedDes);
      assertEquals(input, outDes);
    }
  }
}
