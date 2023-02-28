package databaseapp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import java.time.LocalDate;
import java.util.concurrent.locks.Condition;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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


public  class FXMLDocumentBase extends BorderPane {

    protected final Label labelPersonDetails;
    protected final HBox hBox;
    protected final Button newBut;
    protected final Button updateBut;
    protected final Button deleteBut;
    protected final Button firstBut;
    protected final Button priveiousButt;
    protected final Button nextButt;
    protected final Button lastButt;
    protected final VBox vBox;
    protected final HBox hBox0;
    protected final Label id;
    protected final TextField idTextFild;
    protected final HBox hBox1;
    protected final Label firstName;
    protected final TextField firstNameTextFild;
    protected final HBox hBox2;
    protected final Label middleName;
    protected final TextField middleNameTextFild;
    protected final HBox hBox3;
    protected final Label lastName;
    protected final TextField lastNameTextFiled;
    protected final HBox hBox4;
    protected final Label Email;
    protected final TextField emailTextFild;
    protected final HBox hBox5;
    protected final Label phone;
    protected final TextField phoneTextFild;

    public FXMLDocumentBase(Connection con)  {
        
      

        labelPersonDetails = new Label();
        hBox = new HBox();
        newBut = new Button();
        updateBut = new Button();
        deleteBut = new Button();
        firstBut = new Button();
        priveiousButt = new Button();
        nextButt = new Button();
        lastButt = new Button();
        vBox = new VBox();
        hBox0 = new HBox();
        id = new Label();
        idTextFild = new TextField();
        hBox1 = new HBox();
        firstName = new Label();
        firstNameTextFild = new TextField();
        hBox2 = new HBox();
        middleName = new Label();
        middleNameTextFild = new TextField();
        hBox3 = new HBox();
        lastName = new Label();
        lastNameTextFiled = new TextField();
        hBox4 = new HBox();
        Email = new Label();
        emailTextFild = new TextField();
        hBox5 = new HBox();
        phone = new Label();
        phoneTextFild = new TextField();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(labelPersonDetails, javafx.geometry.Pos.CENTER);
        labelPersonDetails.setText("Person Details");
        labelPersonDetails.setFont(new Font("System Bold Italic", 20.0));
        labelPersonDetails.setOpaqueInsets(new Insets(0.0));
        BorderPane.setMargin(labelPersonDetails, new Insets(10.0, 400.0, 0.0, 0.0));
        setTop(labelPersonDetails);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(46.0);
        hBox.setPrefWidth(600.0);

        newBut.setMnemonicParsing(false);
        newBut.setPrefHeight(31.0);
        newBut.setPrefWidth(61.0);
        newBut.setText("New");
        HBox.setMargin(newBut, new Insets(0.0, 20.0, 10.0, 10.0));
        
       
        
        newBut.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
        
                public void handle(ActionEvent e){
                    
    
                       try {
                       
                        String qury="insert into employee(IDEmp,firstNameEmp,middleNameEmp,lastNameEmp,emailEmp,phoneEmp)"
                            +"values(?,?,?,?,?,?)";
                        
                        PreparedStatement pst = con.prepareStatement(qury);
                        pst.setString(1, idTextFild.getText());
                        pst.setString(2, firstName.getText());
                        pst.executeUpdate();
                        System.out.println("save data");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        System.out.println("Got an exception!");
                    }
 
                }
        });
        

        updateBut.setMnemonicParsing(false);
        updateBut.setPrefHeight(31.0);
        updateBut.setPrefWidth(73.0);
        updateBut.setText("update");
        HBox.setMargin(updateBut, new Insets(0.0, 20.0, 0.0, 0.0));

        deleteBut.setMnemonicParsing(false);
        deleteBut.setPrefHeight(31.0);
        deleteBut.setPrefWidth(71.0);
        deleteBut.setText("Delete");
        HBox.setMargin(deleteBut, new Insets(0.0, 20.0, 0.0, 0.0));

        firstBut.setMnemonicParsing(false);
        firstBut.setPrefHeight(31.0);
        firstBut.setPrefWidth(68.0);
        firstBut.setText("First");
        HBox.setMargin(firstBut, new Insets(0.0, 20.0, 0.0, 0.0));
        
        

        priveiousButt.setMnemonicParsing(false);
        priveiousButt.setPrefHeight(31.0);
        priveiousButt.setPrefWidth(88.0);
        priveiousButt.setText("Priveious");
        HBox.setMargin(priveiousButt, new Insets(0.0, 20.0, 0.0, 0.0));

        nextButt.setMnemonicParsing(false);
        nextButt.setPrefHeight(31.0);
        nextButt.setPrefWidth(63.0);
        nextButt.setText("Next");
        HBox.setMargin(nextButt, new Insets(0.0, 20.0, 0.0, 0.0));

        lastButt.setMnemonicParsing(false);
        lastButt.setPrefHeight(31.0);
        lastButt.setPrefWidth(66.0);
        lastButt.setText("Last");
        HBox.setMargin(lastButt, new Insets(0.0, 20.0, 0.0, 0.0));
        setBottom(hBox);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);

        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(200.0);

        id.setText("ID");
        HBox.setMargin(id, new Insets(20.0, 50.0, 15.0, 65.0));

        idTextFild.setPrefHeight(31.0);
        idTextFild.setPrefWidth(303.0);
        idTextFild.setPromptText("Enter id");
        HBox.setMargin(idTextFild, new Insets(15.0, 50.0, 0.0, 80.0));

        hBox1.setPrefHeight(100.0);
        hBox1.setPrefWidth(200.0);

        firstName.setText("First Name");
        HBox.setMargin(firstName, new Insets(0.0, 50.0, 15.0, 65.0));

        firstNameTextFild.setPrefHeight(31.0);
        firstNameTextFild.setPrefWidth(301.0);
        firstNameTextFild.setPromptText("Enter first Name");
        HBox.setMargin(firstNameTextFild, new Insets(0.0, 50.0, 0.0, 25.0));

        hBox2.setPrefHeight(100.0);
        hBox2.setPrefWidth(200.0);

        middleName.setText("Middle Name");
        HBox.setMargin(middleName, new Insets(0.0, 50.0, 15.0, 65.0));

        middleNameTextFild.setPrefHeight(31.0);
        middleNameTextFild.setPrefWidth(300.0);
        middleNameTextFild.setPromptText("Enter middle name");
        HBox.setMargin(middleNameTextFild, new Insets(0.0, 50.0, 0.0, 8.0));

        hBox3.setPrefHeight(100.0);
        hBox3.setPrefWidth(200.0);

        lastName.setText("Last Name");
        HBox.setMargin(lastName, new Insets(0.0, 50.0, 15.0, 65.0));

        lastNameTextFiled.setPrefHeight(31.0);
        lastNameTextFiled.setPrefWidth(299.0);
        lastNameTextFiled.setPromptText("Enter last name");
        HBox.setMargin(lastNameTextFiled, new Insets(0.0, 0.0, 0.0, 30.0));

        hBox4.setPrefHeight(100.0);
        hBox4.setPrefWidth(200.0);

        Email.setText("Email");
        HBox.setMargin(Email, new Insets(0.0, 50.0, 15.0, 65.0));

        emailTextFild.setPrefHeight(31.0);
        emailTextFild.setPrefWidth(297.0);
        emailTextFild.setPromptText("Enter email");
        HBox.setMargin(emailTextFild, new Insets(0.0, 0.0, 0.0, 65.0));

        hBox5.setPrefHeight(100.0);
        hBox5.setPrefWidth(200.0);

        phone.setText("Phone");
        HBox.setMargin(phone, new Insets(0.0, 50.0, 15.0, 65.0));

        phoneTextFild.setPrefHeight(31.0);
        phoneTextFild.setPrefWidth(295.0);
        phoneTextFild.setPromptText("Enter phone");
        HBox.setMargin(phoneTextFild, new Insets(0.0, 0.0, 0.0, 60.0));
        setCenter(vBox);

        hBox.getChildren().add(newBut);
        hBox.getChildren().add(updateBut);
        hBox.getChildren().add(deleteBut);
        hBox.getChildren().add(firstBut);
        hBox.getChildren().add(priveiousButt);
        hBox.getChildren().add(nextButt);
        hBox.getChildren().add(lastButt);
        hBox0.getChildren().add(id);
        hBox0.getChildren().add(idTextFild);
        vBox.getChildren().add(hBox0);
        hBox1.getChildren().add(firstName);
        hBox1.getChildren().add(firstNameTextFild);
        vBox.getChildren().add(hBox1);
        hBox2.getChildren().add(middleName);
        hBox2.getChildren().add(middleNameTextFild);
        vBox.getChildren().add(hBox2);
        hBox3.getChildren().add(lastName);
        hBox3.getChildren().add(lastNameTextFiled);
        vBox.getChildren().add(hBox3);
        hBox4.getChildren().add(Email);
        hBox4.getChildren().add(emailTextFild);
        vBox.getChildren().add(hBox4);
        hBox5.getChildren().add(phone);
        hBox5.getChildren().add(phoneTextFild);
        vBox.getChildren().add(hBox5);

    }
}
