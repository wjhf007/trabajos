package co.edu.uptc.demo2.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Persistence {

	File f;
	FileWriter fw;
	FileReader fr;
	BufferedWriter bw = null;
	BufferedReader br = null;
	
	public Persistence(String nameFile) {
		f = new File(nameFile);
		//System.setProperty("file.encoding", StandardCharsets.UTF_8.name());
	}
	
public void open(char modo)	{
	try {
		//modo escritura "w" crea el archivo
		if (modo=='w'){
		 fw = new FileWriter(f);
		 bw = new BufferedWriter(fw);
		}
		else{
		//modo lectura "r" abre el archivo
		  fr = new FileReader(f, StandardCharsets.UTF_8);
		  br = new BufferedReader(fr);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}

//Almacena la cadena ingresada por parametro
	public void save(String cad){
		if (bw!=null){
			try {
				bw.write(cad);
				bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 }
// Lee una linea del archivo
	 public String read(){		  
		 String cad="";	
			try {
				cad= br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return cad;		   
	   }
// cierra archivo modo R/W	 
	 public void close(){
			try {
				 if (br!=null)
				    br.close();
				 if (bw!=null)
					    bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 public int binaryParse(int num){
		int x = num;
		StringBuilder result = new StringBuilder("00000000");
		int lastPosition = result.length() - 1;
		while(x>=1){
		  int j = x%2;
		  result.setCharAt(lastPosition, (char)j);
		  x = x/2;
		  lastPosition--;
		}
		return Integer.parseInt(result.toString());
	  }
	  
	 public void readFileByteToByte() throws IOException{
		File filePath = new File(f.getAbsolutePath());
		FileInputStream fis = new FileInputStream(filePath);
		byte[] byte_array = new byte[(int) filePath.length()];
		int contador = 0;
		int byteLeido;
		while((byteLeido =fis.read()) != -1){	
			System.out.print(Integer.toHexString(byteLeido) + " " + binaryParse(byteLeido));	
			byte_array[contador] = (byte) byteLeido;
			contador++;
			//if(contador % 12 == 0){
				System.out.println();
				System.out.println();
			
			
		}
		fis.close();
	 }

	 public char convertByte(int byteLeido){
		char output;
		if(byteLeido == 92){
			output = (char)00;
		}else if (byteLeido >= 0 && byteLeido <= 9) {
			output = (char) (byteLeido + 48);
		}else{
			output = (char) byteLeido;
		}
		return output;
	 }

//public String concatString(){
//	
//}
}
