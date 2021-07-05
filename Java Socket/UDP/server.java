/*
import java.io.*;
import java.net.*;

public class server {
  // initialize socket and input output streams 
  public static void main(String[] args) throws IOException{
      

      System.out.println("Server start");
    DatagramSocket ds = new DatagramSocket();

    byte[]b1 = new byte[1024];
    DatagramPacket dp = new DatagramPacket(b1,b1.length);
    ds.receive(dp);

    String str = new String(dp.getData(),0,dp.getLength());
    System.out.println("str: "+str);

    int num = Integer.parseInt(str.trim());
    System.out.println("num: "+num);
    int result = num*num;


    //return message
    byte[] b2 = String.valueOf(result).getBytes();
    InetAddress ia = InetAddress.getLocalHost();
    DatagramPacket dp1 = new DatagramPacket(b2,b2.length,ia,dp.getPort());
    ds.send(dp1);


  }
  
  
}*/



// Java program to illustrate Server side
// Implementation using DatagramSocket
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
 
public class server
{
    public static void main(String[] args) throws IOException
    {
        // Step 1 : Create a socket to listen at port 1234
        DatagramSocket ds = new DatagramSocket(1234);
        byte[] receive = new byte[65535];
 
        DatagramPacket DpReceive = null;
        while (true)
        {
 
            // Step 2 : create a DatgramPacket to receive the data.
            DpReceive = new DatagramPacket(receive, receive.length);
 
            // Step 3 : revieve the data in byte buffer.
            ds.receive(DpReceive);
 
            System.out.println("Client:-" + data(receive));
 
            // Exit the server if the client sends "bye"
            if (data(receive).toString().equals("bye"))
            {
                System.out.println("Client sent bye.....EXITING");
                break;
            }
 
            // Clear the buffer after every message.
            receive = new byte[65535];
        }
    }
 
    // A utility method to convert the byte array
    // data into a string representation.
    public static StringBuilder data(byte[] a)
    {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}

