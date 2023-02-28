/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author HP
 */
public class HelloWorld extends Application {

    @Override
    public void init() throws Exception {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("init() "+Thread.currentThread().getName());
    }
    
    
    @Override
    public void start(Stage primaryStage) {
       
        System.out.println("start() "+Thread.currentThread().getName());
        
        //Reflection
        Reflection reflection = new Reflection();
        reflection.setFraction(0.7);
        
        Text text=new Text();
        
        text.setX(10.0);
        text.setY(50.0);
        
        text.setCache(true);
        text.setText("Hello World.");
        text.setFill(Color.RED);
        text.setFont(Font.font(null, FontWeight.BOLD, 40));
        text.setEffect(reflection);
 
        
        StackPane root = new StackPane();
        
        
        //LinearGradient
        Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(0.5, Color.WHITE), new Stop(1, Color.BLACK)};
        LinearGradient lg1 = new LinearGradient(1, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops);
        Rectangle r1 = new Rectangle(0, 0, 600, 600);
        r1.setFill(lg1);
      //  r1.setEffect(new DropShadow());
        root.getChildren().add(r1);
        
        root.getChildren().add(text);
    
      
        Scene scene = new Scene(root, 600, 600);
        
        primaryStage.setTitle("Hello JFX");
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
