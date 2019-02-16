package com.clemens.educrypt;

import com.clemens.educrypt.cipher.Cipher;
import com.clemens.educrypt.cipher.CipherKey;
import com.clemens.educrypt.cipher.ciphers.CipherAES;
import com.clemens.educrypt.cipher.ciphers.CipherDES;
import java.nio.charset.StandardCharsets;

public class Educrypt {
  private CipherKey cipherKey;
  private Mode cipherMode;
  private Cipher cipher;

  private Educrypt() {}

  private Educrypt(CipherKey cipherKey, Mode cipherMode) {
    this.cipherKey = cipherKey;
    cipherKey.init(cipherMode);
    this.cipherMode = cipherMode;
    switch (cipherMode) {
      case AES:
        this.cipher = CipherAES.create();
        break;
      case DES:
        this.cipher = CipherDES.create();
    }
  }

  public static Educrypt create(CipherKey cipherkey, Mode cipherMode) {
    return new Educrypt(cipherkey, cipherMode);
  }

  public String encrypt(String data) {
    return new String(cipher.encrypt(data.getBytes(StandardCharsets.UTF_8), cipherKey));
  }

  public String decrypt(String data) {
    return new String(cipher.decrypt(data.getBytes(StandardCharsets.UTF_8), cipherKey));
  }

  public CipherKey getCipherKey() {
    return cipherKey;
  }

  public Mode getCipherMode() {
    return cipherMode;
  }

  public Cipher getCipher() {
    return cipher;
  }

  public enum Mode { AES, DES }
}
