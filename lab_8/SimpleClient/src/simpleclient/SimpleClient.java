/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class SimpleClient {
    
    Socket socket;             
    DataInputStream dis;       
    PrintStream ps;  
    
    public static void main(String[] args) {
        new SimpleClient();
    }
    
    public SimpleClient(){
    
        try {
            socket=new Socket(InetAddress.getLocalHost(),5005);
            dis=new DataInputStream(socket.getInputStream());
            ps=new PrintStream(socket.getOutputStream());
            ps.println("Hi,i'm client");
            String msg=dis.readLine();
            System.out.println("The Server says "+msg);
        } catch (UnknownHostException ex) {
            Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        
            try {
                ps.close();
                dis.close();
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        
        }
        
    }
    
}
