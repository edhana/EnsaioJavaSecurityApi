package br.com.esec.estudo;

import java.security.*;

public class TextSignee {
  private KeyPair keyPair;

  public TextSignee(){
    this.keyPair = createKeyPair();
  }

  public TextSignee(KeyPair keyPair){

  }

  public KeyPair createKeyPair(){
    KeyPair kp = null;
    try{
      KeyPairGenerator generator = KeyPairGenerator.getInstance("DSA");
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

  public KeyPair getKeyPair(){
    return this.keyPair;
  }
}