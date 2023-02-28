/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class SimpleServer {

    ServerSocket serverSocket; //server  "The shop owner"
    Socket socket;             //service "waiter"
    DataInputStream dis;       //it gets input "Ear"
    PrintStream ps;            //View outputs "his mouth"
    
   
    public static void main(String[] args) {
       new SimpleServer();
    }
    
    public SimpleServer(){
    
        try {
            serverSocket =new ServerSocket(5005); //port number=5005
            socket=serverSocket.accept();        //Waiting to hear
            dis=new DataInputStream(socket.getInputStream());
            ps=new PrintStream(socket.getOutputStream());
            String msg=dis.readLine();   //waiting her client
            System.out.println("The Client Says: "+msg);
            ps.println("Hi, i'm server");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        finally{
            
            try {
                ps.close();
                dis.close();
                socket.close();
                serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    
}
