package br.com.esec;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PFXReader{
  public InputStream openPFXFile(String path){
    try{
      return new FileInputStream(path);
    }catch(FileNotFoundException e){
      System.out.println("====> Excepition: " + e.getMessage());
    }

    return null;
  }
}