package br.com.esec.test;

import org.junit.*;
import static org.junit.Assert.*;
import br.com.esec.estudo.TextSignee;

public class TextSigneeTest{
  
  @Test
  public void test_shouldCreateDefaultTextSignee(){
    System.out.println("Should create the default text signee ...");
    TextSignee signee = new TextSignee();
    assertNotNull(signee);
  }

  @Test
  public void test_shouldCreateKeyPain(){
    System.out.println("Should create a keyPair ...");
    TextSignee signee = new TextSignee();
    assertNotNull(signee.createKeyPair());
  }

  @Test
  public void test_shouldCreateAKeyPairInDefaultConstructor(){
    System.out.println("Should create a keyPair object when using the default constructor ...");
    TextSignee signee = new TextSignee();
    assertNotNull(signee.getKeyPair()); 
  }
  
}