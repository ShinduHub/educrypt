package com.clemens.educrypt_test;

import com.clemens.educrypt.Educrypt;
import com.clemens.educrypt.cipher.CipherKey;
import junit.framework.TestCase;

public class EducryptTest extends TestCase {

    public void test() {

        Educrypt educrypt_instance = Educrypt.create(CipherKey.create("s"),
                Educrypt.Mode.DES);
        assertEquals("hello", educrypt_instance.encrypt("hello"));

    }

}
