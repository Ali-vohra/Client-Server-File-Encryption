import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Server{
	
	public static void main(String[] args) throws Exception,IOException
	{
		ServerSocket ss = new ServerSocket(8050);
		Socket s = ss.accept();
		InputStream from = s.getInputStream();
		DataInputStream dis = new DataInputStream(from);
//		byte[] key = new byte[16];
//		dis.read(key, 0, key.length);
//		
//		key = Base64.getDecoder().decode(key);
//		SecretKey sessionKey = new SecretKeySpec(Arrays.copyOf(key, 16),"AES");
		
		File fileName = new File("E:\\Encryption\\server.txt");
		File efileName = new File("E:\\Encryption\\server.enc");
        byte[] b = dis.readAllBytes();
        
//        b = Base64.getMimeDecoder().decode(b);
        FileOutputStream fos = new FileOutputStream(efileName);
//        Cipher cipher = Cipher.getInstance("AES");
//        cipher.init(Cipher.DECRYPT_MODE, sessionKey);
//        byte[] res = cipher.doFinal(b);
//        res = Base64.getMimeDecoder().decode(res);
        fos.write(b, 0, b.length);
        fos.flush();
        fos.close();
        
        String key = "Mary has one cat";
        CUtil.decrypt(key, efileName, fileName);
        
		
		ss.close();
	}
}