import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class Client {

	public static void main(String[] args) throws Exception,IOException {
		Socket s = new Socket("127.0.0.1", 8050);
		
//		KeyGenerator keygen = KeyGenerator.getInstance("AES");
//		SecretKey sessionKey = keygen.generateKey();
//		String sk = sessionKey.toString();
//        Cipher cipher = Cipher.getInstance("AES");
//        cipher.init(Cipher.ENCRYPT_MODE, sessionKey);
		OutputStream to = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(to);
//		byte[] finalKey = sk.getBytes();
//		finalKey = Base64.getEncoder().encode(finalKey);
//		dos.write(finalKey);
		
		File fileName = new File("C:\\Users\\SONY\\Downloads\\barc.txt");
		File efileName = new File("C:\\Users\\SONY\\Downloads\\barc.enc");
        
        byte[] b = new byte[(int) efileName.length()];
        String key = "Mary has one cat";
        CUtil.encrypt(key, fileName, efileName);
        FileInputStream fis = new FileInputStream(efileName);
        fis.read(b, 0, b.length);
        
//        byte[] res = cipher.doFinal(b);
//        dos.write(Base64.getMimeEncoder().encode(res));
        dos.write(b);
        
        dos.close();
        to.close();

        fis.close();
		
		s.close();
		

	}

}
