package br.com.esec.estudo;

import java.security.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class TextSignee {
  private static final String SIGNATURE_KEY = "DSA";
  private KeyPair keyPair;

  public TextSignee(){
    // Configura o provider usado
    Security.addProvider(new BouncyCastleProvider());

    this.keyPair = createKeyPair();
  }

  public KeyPair createKeyPair(){
    KeyPair kp = null;
    try{
      KeyPairGenerator generator = KeyPairGenerator.getInstance(SIGNATURE_KEY);
      SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
      random.setSeed(System.currentTimeMillis());
      generator.initialize(1024, random);
      kp = generator.generateKeyPair();
    }catch(NoSuchAlgorithmException e){
      System.out.println("====> Excepition: " + e.getMessage());
    }catch(NoSuchProviderException e){
      System.out.println("====> Excepition: " + e.getMessage());
    }

    return kp;
  }

  public byte[] sign(String textToSign){
    byte signedText[] = null;

    try{
      Signature signature = Signature.getInstance(SIGNATURE_KEY);
      signature.initSign(this.keyPair.getPrivate());
      signature.update(textToSign.getBytes());
      signedText = signature.sign();
    }catch(NoSuchAlgorithmException e){
      System.out.println("====> Excepition: " + e.getMessage());
    }catch(InvalidKeyException e){
      System.out.println("====> Excepition: " + e.getMessage());
    }catch(SignatureException e){
      System.out.println("====> Excepition: " + e.getMessage());
    }

    return signedText;
  }

  public boolean verify(String originalText, byte [] signedText){
    try{
      Signature signature = Signature.getInstance(SIGNATURE_KEY);
      signature.initVerify(this.keyPair.getPublic());
      signature.update(originalText.getBytes());
      return signature.verify(signedText);      
    }catch(NoSuchAlgorithmException e){
      System.out.println("====> Excepition: " + e.getMessage());
    }catch(InvalidKeyException e){
      System.out.println("====> Excepition: " + e.getMessage());
    }catch(SignatureException e){
      System.out.println("====> Excepition: " + e.getMessage());
    }


    return false;
  }

  public KeyPair getKeyPair(){
    return this.keyPair;
  }
}