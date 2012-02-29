package br.com.esec.estudo.hashes;

import java.security.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class HashTestMain 
{
  public String getMD5Hash(byte input[]){
    MessageDigest md = null;
    Security.addProvider(new BouncyCastleProvider());

    try{
      md = MessageDigest.getInstance("MD5", "SUN");
    }catch(NoSuchAlgorithmException nse){
      System.out.println("[ERRO] - NoSuchAlgorithmException");
    }catch(Exception e){
      System.out.println("[ERRO] - Exception");
    }

    byte digest[] = md.digest(input);
    String hash = new String(org.bouncycastle.util.encoders.Base64.encode(digest));
    return hash;
  }

  public String getMD5Hash(String input){
    return this.getMD5Hash(input.getBytes());
  }

  public String getSHAHash(byte input[]){
    MessageDigest md = null;
    Security.addProvider(new BouncyCastleProvider());

    try{
      md = MessageDigest.getInstance("SHA", "SUN");
    }catch(NoSuchAlgorithmException nse){
      System.out.println("[ERRO] - NoSuchAlgorithmException: " + nse.getMessage());
    }catch(Exception e){
      System.out.println("[ERRO] - Exception: " + e.getMessage());
    }

    byte digest[] = md.digest(input);
    String hash = new String(org.bouncycastle.util.encoders.Base64.encode(digest));
    return hash;
  }

  public String getSHAHash(String input){
    return this.getSHAHash(input.getBytes());
  }

  public static void main( String[] args )
  {
    System.out.println( "Teste Geração de Chaves Hash no Java" );
    HashTestMain hash = new HashTestMain();
    System.out.println(hash.getMD5Hash("Teste".getBytes()));
  }
}
