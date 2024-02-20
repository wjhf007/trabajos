package co.edu.uptc.demo2.controllers;

import java.io.IOException;

import co.edu.uptc.demo2.models.MyFile;
import co.edu.uptc.demo2.services.FileUtil;
import co.edu.uptc.demo2.services.Persistence;

public class FileController {
    

    public void showNameFiles(String path) {
        FileUtil fileUtil;
        fileUtil = new FileUtil();
        String files[] = fileUtil.getNameFiles(path);

        for (String file : files) {
            System.out.println(file);
        }
    }

    public void showInfoFiles(String path) {
        FileUtil fileUtil;
        fileUtil = new FileUtil();
        MyFile files[] = fileUtil.getInfoFiles(path);

        for (MyFile file : files) {
            System.out.println(file.toString());
        }
    }

    public void showFilePath(){
        FileUtil utilFIle = new FileUtil();
        System.out.println("123" + utilFIle.getAbsolutePath("C:\\tmp\\prog2-2024-file1\\src\\co\\edu\\uptc\\demo2\\models/MyFile.java"));
    }

    public void apendString(String cad){
        FileUtil utilFile = new FileUtil();
        utilFile.fileWrite(readData() +cad);
    }

    public String readData(){
        FileUtil file = new FileUtil();
        String data = file.readFile();
        return data;
    }

    public void showData(){
        FileUtil file= new FileUtil();
        System.out.println(file.readFile());
    }

    public void showByteData() throws IOException{
        Persistence pr = new Persistence("archivo.txt");
        //pr.readFileByteToByte();
        pr.readFileByteToByte();
    }


}