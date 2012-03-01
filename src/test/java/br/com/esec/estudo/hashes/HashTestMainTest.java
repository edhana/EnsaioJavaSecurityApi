package br.com.esec.estudo.hashes;

import org.junit.*;
import static org.junit.Assert.*;


public class HashTestMainTest 
{
  @Test
  public void test_shouldGenerateMD5Hash(){
      System.out.println("Should Generate a hash using MD5 ...");
      HashGenerator mainHash = new HashGenerator();
      String strTest = "Teste de string";
      String response = mainHash.generateHash(strTest, HashGenerator.ALGO_MD5);
      assertNotNull(response);
      assertTrue(response.length() == 24);
  }

  @Test
  public void test_shouldGenerateSHAHash(){
    System.out.println("Should Generate Hash Using SHA ...");
    HashGenerator mainHash = new HashGenerator();
    String strTest = "Teste de String";
    String response = mainHash.generateHash(strTest, HashGenerator.ALGO_SHA);
    assertNotNull(response);
    assertTrue(response.length() == 28);
  }

  @Test
  public void test_shouldGenerateSHA1Hash(){
    System.out.println("Should Generate Hash Using SHA 1 ...");
    HashGenerator mainHash = new HashGenerator();
    String strTest = "Teste de String";
    String response = mainHash.generateHash(strTest, HashGenerator.ALGO_SHA1);
    assertNotNull(response);
    assertTrue(response.length() == 28);
  }

  @Test
  public void test_shouldGenerateTigerHash(){
    System.out.println("Should Generate Hash Using TIGER ...");
    HashGenerator mainHash = new HashGenerator();
    String strTest = "Teste de String";
    String response = mainHash.generateHash(strTest, HashGenerator.ALGO_TIGER);
    assertNotNull(response);
    assertTrue(response.length() == 32);
  }
}
