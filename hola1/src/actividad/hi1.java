package actividad;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class hi1 {
public static void main(String[] args) {
		
		ServerSocket server;
		Socket connection;
		
		DataOutputStream output;
		BufferedInputStream bis;
		BufferedOutputStream bos;
		
		byte[] receivedData;
		int in;
		String file;
		try {
			server = new ServerSocket( 5000 );
			while (true) {
				connection = server.accept();
				receivedData = new byte[1204];
				bis = new BufferedInputStream(connection.getInputStream());
				DataInputStream dis = new DataInputStream(connection.getInputStream());
				
				file = dis.readUTF();
				file= file.substring(file.indexOf('\\')+1, file.length());
				
				bos = new BufferedOutputStream(new FileOutputStream(file.intern()));
				while ((in = bis.read(receivedData)) != -1) {
					bos.write(receivedData,0,in);
				}
				bos.close();
				dis.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
}
