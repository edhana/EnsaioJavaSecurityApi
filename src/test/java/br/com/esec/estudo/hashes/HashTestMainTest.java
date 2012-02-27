package br.com.esec.estudo.hashes;

import org.junit.*;
import static org.junit.Assert.*;


public class HashTestMainTest 
{
    @Test
    public void test_generateAMD5Hash()
    {
        HashTestMain mainHash = new HashTestMain();
        System.out.println("Testando um teste simples no junit 4 ...");
        assertNotNull(mainHash);

    }
}
