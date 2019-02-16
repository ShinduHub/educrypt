package com.clemens.educrypt.cipher;

import com.clemens.educrypt.Educrypt;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;

public abstract class Cipher {
  private javax.crypto.Cipher cipher;

  protected Cipher() {}

  protected Cipher(javax.crypto.Cipher cipher) {
    this.cipher = cipher;
  }

  public abstract byte[] encrypt(byte[] data, CipherKey cipherKey);

  public abstract byte[] decrypt(byte[] data, CipherKey cipherKey);

  protected byte[] crypt(
      CryptMode cryptMode, Educrypt.Mode mode, byte[] data, CipherKey cipherKey) {
    try {
      cipher.init(cryptMode == CryptMode.ENCRYPT ? javax.crypto.Cipher.ENCRYPT_MODE
                                                 : javax.crypto.Cipher.DECRYPT_MODE,
          cipherKey.getCipherKey(),
          new IvParameterSpec(new byte[mode == Educrypt.Mode.AES ? 16 : 8]));
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

  public javax.crypto.Cipher getCipher() {
    return cipher;
  }

  protected enum CryptMode { ENCRYPT, DECRYPT }
}
