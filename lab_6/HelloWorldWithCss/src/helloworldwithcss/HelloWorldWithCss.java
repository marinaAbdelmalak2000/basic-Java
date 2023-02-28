/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldwithcss;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class HelloWorldWithCss extends Application {
    
     @Override
    public void init() throws Exception {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("init() "+Thread.currentThread().getName());
    }
    
    @Override
    public void start(Stage primaryStage) {
        
         //Reflection
        Reflection reflection = new Reflection();
        reflection.setFraction(0.7);
        
        Text text =new Text("Hello World");
        text.setId("txt");
       
        StackPane root = new StackPane();
        text.setEffect(reflection);
      
        root.getChildren().add(text);
        
        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(getClass().getResource("Style.css").toString());
        
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
     @Override
    public void stop() throws Exception {
        super.stop(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("stop() "+Thread.currentThread().getName());
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
