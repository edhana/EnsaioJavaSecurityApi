package br.com.esec.estudo.hashes;

import org.junit.*;
import static org.junit.Assert.*;


public class HashTestMainTest 
{
    @Test
    public void test_shouldGenerateAMD5Hash()
    {
        System.out.println("Should Generate a hash using MD5 ...");
        HashTestMain mainHash = new HashTestMain();
        String response = mainHahs.getMD5Hash();
        assertNotNull(mainHash);
    }

    // @Test
    // public void test_shouldFail(){
    //     System.out.println("Should fail the teste ...");
    //     assertTrue(false);
    // }
}
