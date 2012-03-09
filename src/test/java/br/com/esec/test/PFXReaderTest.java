package br.com.esec.test;

import org.junit.*;
import static org.junit.Assert.*;
import br.com.esec.PFXReader;

import java.io.FileNotFoundException;

public class PFXReaderTest{

  private PFXReader reader;

  @Before
  public void setUp(){
    reader = new PFXReader();
  }
  
  @Test 
  public void test_shouldOpenThePFXFile(){
    System.out.println("Should open the project pfx file ... ");
    assertNotNull(reader.openPFXFile("openssl/mycert.pfx"));
  }

  @Test
  public void test_shouldRetrieveTheKeyStoreFromFile(){
    System.out.println("Should retrieve KeyStore from pfx file ... ");

    // Retrieve KeyEntry Object
    try{
      assertNotNull(reader.getKeyStore(reader.openPFXFile("openssl/mycert.pfx")));      
    }catch(FileNotFoundException e){
      fail();
    }
  }

}