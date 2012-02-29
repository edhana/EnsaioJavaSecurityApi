package br.com.esec.estudo.hashes;

import org.junit.*;
import static org.junit.Assert.*;


public class HashTestMainTest 
{
  @Test
  public void test_shouldGenerateMD5Hash(){
      System.out.println("Should Generate a hash using MD5 ...");
      HashTestMain mainHash = new HashTestMain();
      String strTest = "Teste de string";
      String response = mainHash.getMD5Hash(strTest);
      assertNotNull(response);
      assertTrue(response.length() == 24);
  }

  @Test
  public void test_shouldGenerateSHAHash(){
    System.out.println("Should Generate Hash Using SHA ...");
    HashTestMain mainHash = new HashTestMain();
    String strTest = "Teste de String";
    String response = mainHash.getSHAHash(strTest);
    assertNotNull(response);
  }

  // @Test
  // public void test_shouldFail(){
  //     System.out.println("Should fail the teste ...");
  //     assertTrue(false);
  // }
}
