package co.edu.uptc.demo2.services;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import co.edu.uptc.demo2.models.*;

import co.edu.uptc.demo2.models.MyFile;

public class FileUtil {

  public String[] getNameFiles(String path) {
    File file;
    file = new File(path);
    String[] listaArchivos = file.list();
    return listaArchivos;
  }   

  public MyFile[] getInfoFiles(String path) {
    File file;
    file = new File(path);
    File[] listaArchivos = file.listFiles();
    MyFile[] myFiles = new MyFile[listaArchivos.length];
    int  i = 0;
    for (File file2 : listaArchivos) {
        MyFile auxMyFile = new MyFile();
               

        auxMyFile.setName(file2.getName());
        auxMyFile.setSize(file2.length());
        auxMyFile.setDir(file2.isDirectory());
        myFiles[i] = auxMyFile;
        i++;      
    }

    return myFiles;
  }

  public String getAbsolutePath(String path){
    File file = new File(path);
    String Abspath = file.getParent();
    return Abspath;
  }

  public void fileWrite(String cad){
    Persistence file = new Persistence("archivo.txt");
    file.open('w');
    file.save(cad);
    file.close();
  }

  public String readFile(){
    Persistence file = new Persistence("archivo.txt");
    file.open('r');
    String cad;
    String text = "";
    while((cad= file.read())!= null){
      String[] data = cad.split("\n");
        for(int i = 0; i < data.length; i++){
          String[] info = data[i].split("\\\\");
          
            if(info.length == 6){
              text += info[0] + "     " + info[1] + "     " + info[2] + "     " + info[3] + "     " + info[4] + "     " + info[5] + "     \n";
            }else{
              for(int j = 0; j < info.length; j++){
                text += info[j] + "     ";
              }
              cad= file.read();
              String[] newData = cad.split("\\\\");
              for(int k = 0; k < newData.length; k++){
                text += newData[k] + "     ";
              }
              text += "\n";
          
       }
          
      }
          
    }
  return text;
  }
  
  public void plusBinary(int num1, int num2, int num3){

  }

  
}
