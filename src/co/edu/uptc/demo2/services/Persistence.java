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

	 public String getBinary(int num){
		int x = num;
		StringBuilder auxByte = new StringBuilder("00000000");
		int lastPosition = auxByte.length() - 1;
		while(x>=1){
			int res = x%2;
			auxByte.setCharAt(lastPosition, ((res == 1)?'1':'0'));
			x = x/2;
			lastPosition--;
		}
		
		return auxByte.toString();
	 }

	 public void readFileByteToByte() throws IOException{
		File filePath = new File(f.getAbsolutePath());
		FileInputStream fis = new FileInputStream(filePath);
		byte[] byte_array = new byte[(int) filePath.length()];
		int contador = 0;
		int byteLeido;
		int lastChar = 92;
		String cad = "";
		while((byteLeido =fis.read()) != -1){
			if(byteLeido == 92 && lastChar != 92){
					contador++;
				cad += ' ' + "C: " + contador;	
			}else if(contador == 4){
				cad += getBinary(byteLeido);
			}else if(contador == 5){
				cad += getBinary(byteLeido);
				contador = 0;
			}else{
				cad += (char) byteLeido;
			}
			lastChar = byteLeido;
		}
		System.out.print((contador%5 == 0)?(cad+"\n"):cad);
		fis.close();
	 }
}
