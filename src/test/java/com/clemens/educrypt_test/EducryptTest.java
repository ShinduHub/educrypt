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

    Educrypt educrypt_instance_aes =
        Educrypt.create(CipherKey.create(randomKey), Educrypt.CipherAlgorithm.AES);

    String input = "hello";
    String encrypted_aes = educrypt_instance_aes.encrypt(input);
    String out_aes = educrypt_instance_aes.decrypt(encrypted_aes);

    System.out.println(encrypted_aes);
    System.out.println(out_aes);
    assertEquals(input, out_aes);

    Educrypt educrypt_instance =
        Educrypt.create(CipherKey.create(randomKey), Educrypt.CipherAlgorithm.DES);

    String encrypted_des = educrypt_instance.encrypt(input);
    String out_des = educrypt_instance.decrypt(encrypted_des);

    System.out.println(encrypted_des);
    System.out.println(out_des);
    assertEquals(input, out_des);
  }
}
