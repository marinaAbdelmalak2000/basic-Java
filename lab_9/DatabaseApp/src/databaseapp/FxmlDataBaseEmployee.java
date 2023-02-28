package databaseapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public  class FxmlDataBaseEmployee extends BorderPane {

    protected final Label labelPersonDetails;
    protected final HBox hBox;
    protected final Button newBut;
    protected final Button saveBut;
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

    
    Employee emp;
    ArrayList<Employee> employeeList;
    PreparedStatement pst ;
    ResultSet rs;
    ResultSet resultSet;
    public FxmlDataBaseEmployee(Connection con) throws SQLException {

    
             labelPersonDetails = new Label();
             hBox = new HBox();
             newBut = new Button();
             saveBut = new Button();
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
             //select data
             employeeList= new ArrayList<Employee>();
             try {
                 
                 
                 Statement stmt;
                 stmt = (Statement) con.createStatement();
                 
                 String str = "SELECT * FROM Employee";
                 
                  rs = (ResultSet) stmt.executeQuery(str);
                 
                 while (rs.next()) {
                     emp=new Employee();
                     String id = rs.getString("idEmp");
                     emp.setId(id);
                     String fname = rs.getString("firstNameEmp");
                     emp.setFname(fname);
                     String mname = rs.getString("middleNameEmp");
                     emp.setMname(mname);
                     String lname = rs.getString("lastNameEmp");
                     emp.setLname(lname);
                     String email = rs.getString("emailEmp");
                     emp.setEmail(email);
                     String phone = rs.getString("phoneEmp");
                     emp.setPhone(phone);
                     
                     employeeList.add(emp);
                     
                     idTextFild.setText(emp.getId());
                     idTextFild.setEditable(false);
                     firstNameTextFild.setText(emp.getFname());
                     firstNameTextFild.setEditable(false);
                     middleNameTextFild.setText(emp.getMname());
                     middleNameTextFild.setEditable(false);
                     lastNameTextFiled.setText(emp.getLname());
                     lastNameTextFiled.setEditable(false);
                     emailTextFild.setText(emp.getEmail());
                     emailTextFild.setEditable(false);
                     phoneTextFild.setText(emp.getPhone());
                     phoneTextFild.setEditable(false);
                     System.out.println(emp.getId()+ " - " + emp.getFname());
                     emp = null;
                     System.out.println("select data");
                 }
                 
                 
             } catch (SQLException ex) {
                 System.out.println("Got an exception!");
             }
             
           newBut.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
                 
                 public void handle(ActionEvent e){
                     
                     if(newBut.getText()=="New"){
                         idTextFild.clear();
                         firstNameTextFild.clear();
                         middleNameTextFild.clear();
                         lastNameTextFiled.clear();
                         emailTextFild.clear();
                         phoneTextFild.clear();
                         
                         
                         idTextFild.setEditable(true);
                         firstNameTextFild.setEditable(true);
                         middleNameTextFild.setEditable(true);
                         lastNameTextFiled.setEditable(true);
                         emailTextFild.setEditable(true);
                         phoneTextFild.setEditable(true);
                         
                         newBut.setText("Save");
                     }
                     else {
                         try {
                             String qury="INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?)";
                             
                             pst = con.prepareStatement(qury);
                             
                             pst.setString(1, idTextFild.getText());
                             // emp.setId(idTextFild.getText());
                             idTextFild.setEditable(false);
                             
                             pst.setString(2, firstNameTextFild.getText());
                             //emp.setFname(firstNameTextFild.getText());
                             firstNameTextFild.setEditable(false);
                             
                             pst.setString(3, middleNameTextFild.getText());
                             //emp.setMname(middleNameTextFild.getText());
                             middleNameTextFild.setEditable(false);
                             
                             pst.setString(4, lastNameTextFiled.getText());
                             //emp.setLname(lastNameTextFiled.getText());
                             lastNameTextFiled.setEditable(false);
                             
                             pst.setString(5, emailTextFild.getText());
                             //emp.setEmail(emailTextFild.getText());
                             emailTextFild.setEditable(false);
                             
                             pst.setString(6, phoneTextFild.getText());
                             //emp.setPhone(phoneTextFild.getText());
                             phoneTextFild.setEditable(false);
                             
                             pst.executeUpdate();
                             // System.out.println("save data rs ");
                             
                             employeeList.add(emp);
                             
                             newBut.setText("New");
                         } catch (SQLException ex) {
                             ex.printStackTrace();
                            
                         }
                     }
                 }
                 
             });
           
             
             updateBut.setMnemonicParsing(false);
             updateBut.setPrefHeight(31.0);
             updateBut.setPrefWidth(73.0);
             updateBut.setText("update");
             HBox.setMargin(updateBut, new Insets(0.0, 20.0, 0.0, 0.0));
             updateBut.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
                 
                 public void handle(ActionEvent e){
                     
                     String qury="Update Employee set FirstNameEmp=?,middleNameEmp=?,lastNameEmp=?,emailEmp=?,phoneEmp=? where IdEmp=?";
                     
                     try {
                         
                         idTextFild.setEditable(false);//.setDisable(true);
                         firstNameTextFild.setEditable(true);
                         middleNameTextFild.setEditable(true);
                         lastNameTextFiled.setEditable(true);
                         emailTextFild.setEditable(true);
                         phoneTextFild.setEditable(true);
                         pst = con.prepareStatement(qury);
                         pst.setString(6, idTextFild.getText());
                         pst.setString(1, firstNameTextFild.getText());
                         pst.setString(2, middleNameTextFild.getText());
                         pst.setString(3, lastNameTextFiled.getText());
                         pst.setString(4, emailTextFild.getText());
                         pst.setString(5, phoneTextFild.getText());
                         
                       
                        pst.executeUpdate();
                         
                        firstNameTextFild.setText(firstNameTextFild.getText());
                         middleNameTextFild.setText(middleNameTextFild.getText());
                         lastNameTextFiled.setText(lastNameTextFiled.getText());
                         emailTextFild.setText(emailTextFild.getText());
                         phoneTextFild.setText(phoneTextFild.getText());
                        
                         
                     } catch (SQLException ex) {
                         ex.printStackTrace();
                     }
                     
                     
                     
                 }
             });
             deleteBut.setMnemonicParsing(false);
             deleteBut.setPrefHeight(31.0);
             deleteBut.setPrefWidth(71.0);
             deleteBut.setText("Delete");
             HBox.setMargin(deleteBut, new Insets(0.0, 20.0, 0.0, 0.0));
             deleteBut.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
                 
                 public void handle(ActionEvent e){
                     
                     try {
                         String qury="delete from Employee where idEmp=?";
                         pst = con.prepareStatement(qury);
                         pst.setString(1, idTextFild.getText());

                         idTextFild.setText("");
                         firstNameTextFild.setText("");
                         middleNameTextFild.setText("");
                         lastNameTextFiled.setText("");
                         emailTextFild.setText("");
                         phoneTextFild.setText("");
                         
                         pst.executeUpdate();
                     } catch (SQLException ex) {
                         Logger.getLogger(FxmlDataBaseEmployee.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             });
            
             
       /* try {
            
             pst = con.prepareStatement("select * from employee",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
           
             resultSet = pst.executeQuery();
       
        } catch (SQLException ex) {
            Logger.getLogger(FxmlDataBaseEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            
             
             
             firstBut.setMnemonicParsing(false);
             firstBut.setPrefHeight(31.0);
             firstBut.setPrefWidth(68.0);
             firstBut.setText("First");
             HBox.setMargin(firstBut, new Insets(0.0, 20.0, 0.0, 0.0));
              pst = con.prepareStatement("select * from employee",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
           
                        resultSet = pst.executeQuery();
             firstBut.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
                 
                 public void handle(ActionEvent e){
                     
             
                     try {
                         
                         resultSet.first();
                         idTextFild.setText(resultSet.getString(1));
                         firstNameTextFild.setText(resultSet.getString(2));
                         middleNameTextFild.setText(resultSet.getString(3));
                         lastNameTextFiled.setText(resultSet.getString(4));
                         emailTextFild.setText(resultSet.getString(5));
                         phoneTextFild.setText(resultSet.getString(6)); 
                    } catch (SQLException ex) {
                         Logger.getLogger(FxmlDataBaseEmployee.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                 }
             });
             priveiousButt.setMnemonicParsing(false);
             priveiousButt.setPrefHeight(31.0);
             priveiousButt.setPrefWidth(88.0);
             priveiousButt.setText("Priveious");
             HBox.setMargin(priveiousButt, new Insets(0.0, 20.0, 0.0, 0.0));
             
             priveiousButt.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
                 
                 public void handle(ActionEvent e){
                     
             
                     try {
                         
                         
                         //resultSet.previous();
                         
                         if(resultSet.previous()){
                         
                            idTextFild.setText(resultSet.getString(1));
                            firstNameTextFild.setText(resultSet.getString(2));
                            middleNameTextFild.setText(resultSet.getString(3));
                            lastNameTextFiled.setText(resultSet.getString(4));
                            emailTextFild.setText(resultSet.getString(5));
                            phoneTextFild.setText(resultSet.getString(6)); 
                         
                         }
                         else{
                         
                            resultSet.first();
                            idTextFild.setText(resultSet.getString(1));
                            firstNameTextFild.setText(resultSet.getString(2));
                            middleNameTextFild.setText(resultSet.getString(3));
                            lastNameTextFiled.setText(resultSet.getString(4));
                            emailTextFild.setText(resultSet.getString(5));
                            phoneTextFild.setText(resultSet.getString(6)); 
                         
                         }
                         
                         
                    } catch (SQLException ex) {
                         Logger.getLogger(FxmlDataBaseEmployee.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                 }
             });
             
             
             nextButt.setMnemonicParsing(false);
             nextButt.setPrefHeight(31.0);
             nextButt.setPrefWidth(63.0);
             nextButt.setText("Next");
             HBox.setMargin(nextButt, new Insets(0.0, 20.0, 0.0, 0.0));
             
             nextButt.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
                 
                 public void handle(ActionEvent e){
                     
             
                     try {
                        
                        // resultSet.next();
                         
                         if(resultSet.next()){
                         
                             idTextFild.setText(resultSet.getString(1));
                            firstNameTextFild.setText(resultSet.getString(2));
                            middleNameTextFild.setText(resultSet.getString(3));
                            lastNameTextFiled.setText(resultSet.getString(4));
                            emailTextFild.setText(resultSet.getString(5));
                            phoneTextFild.setText(resultSet.getString(6)); 
                         
                         }
                         else{
                         
                            resultSet.last();
                            idTextFild.setText(resultSet.getString(1));
                            firstNameTextFild.setText(resultSet.getString(2));
                            middleNameTextFild.setText(resultSet.getString(3));
                            lastNameTextFiled.setText(resultSet.getString(4));
                            emailTextFild.setText(resultSet.getString(5));
                            phoneTextFild.setText(resultSet.getString(6)); 
                         
                         }
                         
                         
                    } catch (SQLException ex) {
                         Logger.getLogger(FxmlDataBaseEmployee.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                 }
             });
             
             lastButt.setMnemonicParsing(false);
             lastButt.setPrefHeight(31.0);
             lastButt.setPrefWidth(66.0);
             lastButt.setText("Last");
             HBox.setMargin(lastButt, new Insets(0.0, 20.0, 0.0, 0.0));
             lastButt.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
                 
                 public void handle(ActionEvent e){
                     
             
                     try {
  
                         resultSet.last();
                         idTextFild.setText(resultSet.getString(1));
                         firstNameTextFild.setText(resultSet.getString(2));
                         middleNameTextFild.setText(resultSet.getString(3));
                         lastNameTextFiled.setText(resultSet.getString(4));
                         emailTextFild.setText(resultSet.getString(5));
                         phoneTextFild.setText(resultSet.getString(6)); 
                    } catch (SQLException ex) {
                         Logger.getLogger(FxmlDataBaseEmployee.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                 }
             });
             
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
             //hBox.getChildren().add(saveBut);
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
    
    
    public class Employee {

        private  String id;
        private  String fname;
        private  String mname;
        private  String lname;
        private  String email;
        private  String phone;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getMname() {
            return mname;
        }

        public void setMname(String mname) {
            this.mname = mname;
        }

        public String getLname() {
            return lname;
        }

        public void setLname(String lname) {
            this.lname = lname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
       

    }
    
}
    

