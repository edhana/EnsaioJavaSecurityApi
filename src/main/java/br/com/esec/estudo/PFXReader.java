package br.com.esec;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import java.util.Enumeration;

public class PFXReader{
  public InputStream openPFXFile(String path){
    try{
      return new FileInputStream(path);
    }catch(FileNotFoundException e){
      System.out.println("====> Excepition: " + e.getMessage());
    }

    return null;
  }

  public KeyStore getKeyStore(InputStream file) throws FileNotFoundException{
    try{
      if (file != null){
        KeyStore ks = KeyStore.getInstance("PKCS12", "BC");
        String password = "1234";
        ks.load(file, password.toCharArray());
        return ks;
      }
      else{
        // TODO: Refatorar para uma classe de exception propria
        throw new FileNotFoundException("A .pfx file must be informed in order to retrieve the KeyStore");
      }
    }catch(KeyStoreException e){
      System.out.println("====> Excepition: " + e.getMessage()); 
    }catch(NoSuchProviderException e){
      System.out.println("====> Excepition: " + e.getMessage());
    }catch(IOException e){
      System.out.println("====> Excepition: " + e.getMessage());
    }catch(NoSuchAlgorithmException e){
      System.out.println("====> Excepition: " + e.getMessage());
    }catch(CertificateException e){
      System.out.println("====> Excepition: " + e.getMessage());
    }

    return null;
  }

  /**
   * Return the unique alias of a keystore
   */
  public String getKeyEntry(KeyStore ks){
    
    try{
      Enumeration<String> en = ks.aliases();
      String alias = (String)en.nextElement();
      return alias;
    }catch(KeyStoreException e){
      System.out.println("====> Excepition: " + e.getMessage());
    }

    return null;
  }

  public X509Certificate getCertificate(KeyStore ks, String alias){
    try{
      X509Certificate cert = (X509Certificate) ks.getCertificate(alias);
      return cert;
    }catch(KeyStoreException e){
      System.out.println("====> Excepition: " + e.getMessage());
    }

    return null;
  }
}