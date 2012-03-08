package br.com.esec.test;

import org.junit.*;
import static org.junit.Assert.*;
import br.com.esec.PFXReader;

public class PFXReaderTest{

  @Test 
  public void test_shouldOpenThePFXFile(){
    System.out.println("Should open the project pfx file ... ");
    PFXReader reader = new PFXReader();
    assertNotNull(reader.openPFXFile("openssl/mycert.pfx"));
  }

}