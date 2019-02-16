package com.clemens.educrypt.cipher;

import com.clemens.educrypt.Educrypt;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.spec.SecretKeySpec;

public class CipherKey {
  private String stringKey;
  private SecretKeySpec cipherKey;
  private Educrypt.Mode cipherMode;

  private CipherKey() {}

  private CipherKey(String stringKey) {
    this.stringKey = stringKey;
  }

  public static CipherKey create(String cipherKey) {
    return new CipherKey(cipherKey);
  }

  public void init(Educrypt.Mode cipherMode) {
    this.cipherMode = cipherMode;
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
      byte[] subCipherKey = new byte[cipherMode == Educrypt.Mode.AES ? 16 : 8];
      System.arraycopy(messageDigest.digest(stringKey.getBytes(StandardCharsets.UTF_8)), 0,
          subCipherKey, 0, (cipherMode == Educrypt.Mode.AES) ? 16 : 8);
      cipherKey = new SecretKeySpec(subCipherKey, cipherMode.toString());
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }

  public String getStringKey() {
    return stringKey;
  }

  SecretKeySpec getCipherKey() {
    return cipherKey;
  }
}
