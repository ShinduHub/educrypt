package com.clemens.educrypt_test;

import com.clemens.educrypt.Educrypt;
import com.clemens.educrypt.cipher.CipherKey;
import com.clemens.educrypt.cipher.CipherKeyLength;
import com.clemens.educrypt.cipher.CipherMode;
import junit.framework.TestCase;

public class EducryptTest extends TestCase {

    public void test()
    {

        Educrypt educrypt_instance = Educrypt.create(CipherKey.createKey("s", CipherKeyLength.DES_56), CipherMode.DES);
        assertEquals("hello", educrypt_instance.encrypt("hello"));

    }

}
