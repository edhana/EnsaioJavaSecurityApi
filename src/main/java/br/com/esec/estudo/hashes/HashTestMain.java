package br.com.esec.estudo.hashes;

import java.security.*;

public class HashTestMain 
{
    public static void main( String[] args )
    {
        System.out.println( "Teste Geração de Chaves Hash no Java" );

        try{
          MessageDigest digest = MessageDigest.getInstance("MD5", "SUN");
        }catch(NoSuchAlgorithmException nse){
          System.out.println("[ERRO] - NoSuchAlgorithmException");
        }catch(Exception e){
          System.out.println("[ERRO] - Exception");
        }
        
    }
}
