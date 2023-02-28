package chatclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FXMLDocumentBase extends BorderPane implements Runnable{

    protected final BorderPane borderPaneTextButtn;
    protected final TextArea textArea;
    protected final Button button;
    protected final TextField textFild;
    
    Socket socket;
    DataInputStream dis;
    public PrintStream ps;
    
    String msg;
    Thread thread;
    Stage s;
    public FXMLDocumentBase() {
       // s=stage;
        thread=new Thread(this);   
        thread.start();
        try {
            socket=new Socket(InetAddress.getLocalHost(),5004);
           // dis=new DataInputStream(socket.getInputStream());
            ps=new PrintStream(socket.getOutputStream());
        } catch (UnknownHostException ex) {
            Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        borderPaneTextButtn = new BorderPane();
        textArea = new TextArea();
        button = new Button();
        textFild = new TextField();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(borderPaneTextButtn, javafx.geometry.Pos.CENTER);
        borderPaneTextButtn.setPrefHeight(387.0);
        borderPaneTextButtn.setPrefWidth(600.0);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(305.0);
        textArea.setPrefWidth(540.0);
        BorderPane.setMargin(textArea, new Insets(10.0, 10.0, 10.0, 10.0));
        borderPaneTextButtn.setTop(textArea);

        BorderPane.setAlignment(button, javafx.geometry.Pos.CENTER);
        button.setMnemonicParsing(false);
        button.setPrefHeight(30.0);
        button.setPrefWidth(89.0);
        button.setText("Send");
        button.setFont(new Font(14.0));
        BorderPane.setMargin(button, new Insets(10.0));
        borderPaneTextButtn.setRight(button);
        
        button.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
        
                public void handle(ActionEvent e){
                   new Thread(){
                       public void run(){
                          
                      try{  
                    
                        String msgout=textFild.getText();
                        System.out.println("ps"+ps);
                        ps.println(msgout);
                       
                       }
                       catch (Exception ex) {
                            ex.printStackTrace();
                       }
                           
                    }}.start();     
                }
        
        });

        BorderPane.setAlignment(textFild, javafx.geometry.Pos.CENTER);
        textFild.setPrefHeight(55.0);
        textFild.setPrefWidth(471.0);
        textFild.setPromptText("Enter message");
        BorderPane.setMargin(textFild, new Insets(20.0));
        borderPaneTextButtn.setCenter(textFild);
        setBottom(borderPaneTextButtn);
        
        
        
       
        
        
    } 
    
    
    @Override
    public void run() {
        try {
            socket=new Socket(InetAddress.getLocalHost(),5004);
            dis=new DataInputStream(socket.getInputStream());
            msg=null;
            while(true){
                
               msg=dis.readLine();
               textArea.appendText(msg+"\n");
               System.out.println("Client"+msg);
               textFild.clear();
            }
           
        } 
       
        
        catch (UnknownHostException ex) {
            Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        catch (IOException ex) {
            Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         s.setOnCloseRequest(new EventHandler<WindowEvent>() { //scene close
            @Override
            public void handle(WindowEvent t) {
               
                    try {
                        dis.close();
                        ps.close();
                        socket.close();
                       
                        Platform.exit();
                        System.out.println("Calling System.exit(0):");
                        
                        System.exit(0);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
        
            }
        });
        
       // });}
     /*   finally{
            
        
            try {
                
                ps.close();
                dis.close();
                socket.close();
                ChatClient c=new ChatClient();
                c.stop();
                
                System.out.print("stop");
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }*/
       } 
    
   
            
}
