/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class ChatServer {

    ServerSocket serverSocket;

    public static void main(String[] args) {
        new ChatServer();
    }

    public ChatServer() {

        try {
            serverSocket = new ServerSocket(5004);
            while (true) {
                Socket socket = serverSocket.accept();
                new ChatHandler(socket);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class ChatHandler extends Thread {

    DataInputStream dis;
    PrintStream ps;
    static Vector<ChatHandler> clientsVector = new Vector<ChatHandler>();
    Socket socket;
    //boolean isloggedin;
    // Thread thread=new Thread(this);

    public ChatHandler(Socket cs) {

        try {
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());
            ChatHandler.clientsVector.add(this);
            socket = cs;
           // this.isloggedin = true;
            start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            String str = null;
            try {
                str = dis.readLine();

                System.out.println("Server" + str);
            } catch (IOException ex) {
                Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

            sendMessageToAll(str);

        }
    }

    void sendMessageToAll(String msg) {
// for(ChatHandler ch : clientsVector)
        for (int i = 0; i < clientsVector.size(); i++) {
            //  if(msg!=null){

            if (socket.isConnected()) {
                clientsVector.get(i).ps.println(msg);
                System.out.println("Server not  Stop" + clientsVector.get(i));
                System.out.println("The socket is connected: " + socket.isConnected());

            } else {

                clientsVector.remove(clientsVector.get(i));
                System.out.println("Server Stop" + clientsVector.get(i));
                System.out.println("Server Stop");

            }
           /* if( socket.isClosed()){
                clientsVector.remove(clientsVector.get(i));
            }*/
            //  }
        }
    }
    

}
