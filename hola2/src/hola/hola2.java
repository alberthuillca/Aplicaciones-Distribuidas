package hola;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class hola2 {
public static void main(String[] args) {
		
		DataInputStream imput;
		BufferedInputStream bis;
		BufferedOutputStream bos;
		int in;
		byte[] byteArray;
		
		final String filename = "C:\\Users\\Albert\\Downloads\\tarjeta.pdf";
		
		try {
			final File localFile = new File(filename);
			Socket client = new Socket("localhost", 5000);
			bis = new BufferedInputStream(new FileInputStream(localFile));
			bos = new BufferedOutputStream(client.getOutputStream());
			
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			dos.writeUTF(localFile.getName());
			
			byteArray = new byte[8192];
			while ((in = bis.read(byteArray)) != -1) {
				bos.write(byteArray,0,in);
			}
			
			bis.close();
			bos.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		}
}
