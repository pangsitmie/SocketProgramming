/*
import java.io.*;
import java.net.*;


public class client {
    // initialize socket and input output streams 
    public static void main(String[] args) throws IOException{
        
        System.out.println("Client start");
        DatagramSocket ds = new DatagramSocket();

        int i=8;
        byte[] b = String.valueOf(i).getBytes();
        
        InetAddress ia = InetAddress.getLocalHost();
        DatagramPacket dp = new DatagramPacket(b,b.length,ia,9999);//need 4 parameter
        ds.send(dp);


        //receive
        byte[] b1 = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(b1, b1.length);
        ds.receive(dp1);

        String str = new String(dp1.getData(),0,dp1.getLength());
        System.out.println("result is :"+str);


    }
    
    
}*/

// Java program to illustrate Client side
// Implementation using DatagramSocket
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
 
public class client
{
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
 
        // Step 1:Create the socket object for
        // carrying the data.
        DatagramSocket ds = new DatagramSocket();
 
        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;
 
        // loop while user not enters "bye"
        while (true)
        {
            String inp = sc.nextLine();
 
            // convert the String input into the byte array.
            buf = inp.getBytes();
 
            // Step 2 : Create the datagramPacket for sending
            // the data.
            DatagramPacket DpSend =
                  new DatagramPacket(buf, buf.length, ip, 1234);
 
            // Step 3 : invoke the send call to actually send
            // the data.
            ds.send(DpSend);
 
            // break the loop if user enters "bye"
            if (inp.equals("bye"))
                break;
        }
    }
}