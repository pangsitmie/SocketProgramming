
import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;

public class client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket ss = new Socket("192.168.56.1", 4333);

        InputStream is = ss.getInputStream();
        FileOutputStream fr = new FileOutputStream("C:\\java_buffer\\newart.wav");

        byte buff[] = new byte[65536];
        int len;
        while ((len = is.read(buff)) != -1) {
            fr.write(buff, 0, len);
        }
        

        System.out.println("Download successfull...");
    }

}

/*
 byte b[] = new byte[10000000];
        Socket ss = new Socket("192.168.56.1", 4333);
        InputStream is = ss.getInputStream();
        FileOutputStream fr = new FileOutputStream("C:\\java_buffer\\music.mp3");
        is.read(b,0,b.length);
        fr.write(b,0,b.length);
        
        System.out.println("Download successfull...");
 */
