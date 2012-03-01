package br.com.esec.estudo.hashes;

import java.security.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class HashGenerator 
{

  public static final int ALGO_MD5 = 0;
  public static final int ALGO_SHA = 1;
  public static final int ALGO_SHA1 = 2;
  public static final int ALGO_TIGER = 3;

  public String generateHash(String input, int algorithm){
    String algo = null;

    switch(algorithm){
      case ALGO_MD5:
        algo = "MD5";
        break;
      case ALGO_SHA:
        algo = "SHA";
        break;
      case ALGO_SHA1:
        algo = "SHA1";
        break;
      case ALGO_TIGER:
        algo = "TIGER";
        break;
      default:
        algo = "MD5";
        break;
    }   

    return generateHash(input.getBytes(), algo);
  }

  public String generateHash(byte input[], String algorithm){
    MessageDigest md = null;
    Security.addProvider(new BouncyCastleProvider());

    try{
      md = MessageDigest.getInstance(algorithm);
    }catch(NoSuchAlgorithmException nse){
      System.out.println("[ERROR] - NoSuchAlgorithmException");
    }catch(Exception e){
      System.out.println("[ERROR] - Exception");
    }

    byte digest[] = md.digest(input);
    String hash = new String(org.bouncycastle.util.encoders.Base64.encode(digest));
    return hash; 
  }



  public static void main( String[] args )
  {
    System.out.println( "Teste Geração de Chaves Hash no Java" );
    HashGenerator hash = new HashGenerator();
    System.out.println(hash.generateHash("Teste", HashGenerator.ALGO_MD5));
  }
}
