package br.com.esec.test;

import org.junit.*;
import static org.junit.Assert.*;
import br.com.esec.estudo.TextSignee;

public class TextSigneeTest{
  public TextSignee signee;
  public String textToSign;
  
  @Before
  public void setUp(){
    signee = new TextSignee();
    textToSign = "So vejo bachareis a minha volta.";
  }

  @Test
  public void test_shouldCreateDefaultTextSignee(){
    System.out.println("Should create the default text signee ...");
    assertNotNull(signee);
  }

  @Test
  public void test_shouldCreateKeyPain(){
    System.out.println("Should create a keyPair ...");
    assertNotNull(signee.createKeyPair());
  }

  @Test
  public void test_shouldCreateAKeyPairInDefaultConstructor(){
    System.out.println("Should create a keyPair object when using the default constructor ...");
    assertNotNull(signee.getKeyPair()); 
  }

  @Test
  public void test_shouldSignAText(){
    System.out.println("Should sign a random text ...");
    assertNotNull(signee.sign(textToSign));
  }

  @Test
  public void test_shouldValidateASignedText(){
    System.out.println("Should validate a sign on a random text ...");
    assertTrue(signee.verify(textToSign, signee.sign(textToSign)));
  }
  
}