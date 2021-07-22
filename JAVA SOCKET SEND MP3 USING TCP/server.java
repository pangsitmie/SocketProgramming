import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(4333);
        System.out.println("server started");
        
        File file = new File("art.wav");
        int fileLength = (int) file.length();
        System.out.println("FILE LENGTH: "+ fileLength);
        
        Socket s=ss.accept();
        
        
        FileInputStream fr = new FileInputStream(file);
        OutputStream os = s.getOutputStream();
        
        byte buff[]  = new byte[65536];
        int len;
        while ((len = fr.read(buff)) != -1) {
            os.write(buff, 0, len);
        }
        
        /*
        fr.read(buff,0,buff.length);
        os.write(buff);
        */
        
        System.out.println("upload successfull");
        

        
        
    }

}


/*
 FileInputStream fr = new FileInputStream("C:\\Users\\jerie\\OneDrive\\Desktop\\MP3 TCP\\test.txt");
        byte buff[]  = new byte[2048];
        fr.read(buff,0,buff.length);

        OutputStream os = s.getOutputStream();
        os.write(buff,0,buff.length);

------------------
BufferedInputStream bufIn=new BufferedInputStream(s.getInputStream());
        File file=new File("music.mp3");
        PrintStream ps=new PrintStream(new FileOutputStream(file),true);
        
        byte[]buff=new byte[1024];
        int len=-1;
        while((len=bufIn.read(buff))!=-1) {
                ps.write(buff, 0, len);
        }
        
        PrintStream psout=new PrintStream(s.getOutputStream(),true);
        psout.println("upload successfull");

        ss.close();
        s.close();
        ps.close();
*/