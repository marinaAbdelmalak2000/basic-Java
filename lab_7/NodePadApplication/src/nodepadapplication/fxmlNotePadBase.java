package nodepadapplication;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public  class fxmlNotePadBase extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu menu;
    protected final MenuItem menuItemNew;
    protected final MenuItem menuItemOpen;
    protected final MenuItem menuItemSave;
    protected final MenuItem menuItemExit;
    protected final Menu menuEdit;
    protected final MenuItem menuItemCut;
    protected final MenuItem menuItemCopy;
    protected final MenuItem menuItemPast;
    protected final MenuItem menuItemDelete;
    protected final MenuItem menuItemSelectAll;
    protected final Menu menuHelp;
    protected final MenuItem menuItemAbout;
    protected final TextArea textArea;

    public fxmlNotePadBase(Stage stage) {

        menuBar = new MenuBar();
        menu = new Menu();
        menuItemNew = new MenuItem();
        menuItemOpen = new MenuItem();
        menuItemSave = new MenuItem();
        menuItemExit = new MenuItem();
        menuEdit = new Menu();
        menuItemCut = new MenuItem();
        menuItemCopy = new MenuItem();
        menuItemPast = new MenuItem();
        menuItemDelete = new MenuItem();
        menuItemSelectAll = new MenuItem();
        menuHelp = new Menu();
        menuItemAbout = new MenuItem();
        textArea = new TextArea();

        setId("myBorderPane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);
        menuBar.setId("myMenuBar");

        menu.setId("myMenuFile");
        menu.setMnemonicParsing(false);
        menu.setText("File");

        menuItemNew.setId("menuNew");
        menuItemNew.setMnemonicParsing(false);
        menuItemNew.setText("New");
        menuItemNew.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        
        menuItemNew.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
        
                public void handle(ActionEvent e){
                    
                        Alert alter=new Alert(AlertType.CONFIRMATION);
                        alter.setTitle("New");
                        alter.setHeaderText("Do you want to open new text?  ");
                        Optional<ButtonType> result = alter.showAndWait();
                        
                        if ( result.get() == ButtonType.OK) {
                            textArea.clear();
                            
                        }
                       
                }
        
        });

        menuItemOpen.setId("menuOpen");
        menuItemOpen.setMnemonicParsing(false);
        menuItemOpen.setText("Open");
        menuItemOpen.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));

        menuItemOpen.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
        
                public void handle(ActionEvent e){
                
                    FileChooser fc=new FileChooser();
                    File file =fc .showOpenDialog(stage);
                    if(file!=null){
                    
                        try {
                            FileInputStream fis=new FileInputStream(file);
                            int size =fis.available();
                            byte[]b=new byte[size];
                            fis.read(b);
                            textArea.setText(new String(b));
                            fis.close();
                            
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(fxmlNotePadBase.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(fxmlNotePadBase.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       
                        
                        
                    }
                    
                }
        
        });
                
        menuItemSave.setId("menuSave");
        menuItemSave.setMnemonicParsing(false);
        menuItemSave.setText("Save");
        menuItemSave.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));

        menuItemSave.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
        
                public void handle(ActionEvent e){
                
                    FileChooser fc=new FileChooser();
                    File file =fc .showSaveDialog(stage);
                    if(file!=null){
                    
                        try {
                            FileOutputStream fos=new FileOutputStream(file);
                             byte[]b=textArea.getText().getBytes();
                             fos.write(b);
                             fos.close();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(fxmlNotePadBase.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(fxmlNotePadBase.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       
                        
                        
                    }
                    
                }
        
        });
         
        menuItemExit.setId("menuExit");
        menuItemExit.setMnemonicParsing(false);
        menuItemExit.setText("Exit");
        menuItemExit.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
        
        menuItemExit.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
        
                public void handle(ActionEvent e){
                
                    System.exit(0);
                    
                }
        
        });
        
        menuEdit.setId("myMenuEdit");
        menuEdit.setMnemonicParsing(false);
        menuEdit.setText("Edit");

        menuItemCut.setId("menuCut");
        menuItemCut.setMnemonicParsing(false);
        menuItemCut.setText("Cut");

        menuItemCut.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
        
                public void handle(ActionEvent e){
                
                    textArea.cut();
                    
                }
        
        });
        menuItemCopy.setId("menuCopy");
        menuItemCopy.setMnemonicParsing(false);
        menuItemCopy.setText("Copy");
        
        menuItemCopy.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
        
                public void handle(ActionEvent e){
                
                    textArea.copy();
                    
                }
        
        });

        menuItemPast.setId("menuPast");
        menuItemPast.setMnemonicParsing(false);
        menuItemPast.setText("Past");

        menuItemPast.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
        
                public void handle(ActionEvent e){
                
                    textArea.paste();
                    
                }
        
        });
        menuItemDelete.setId("menuDelete");
        menuItemDelete.setMnemonicParsing(false);
        menuItemDelete.setText("Delete");
        
        menuItemDelete.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
        
                public void handle(ActionEvent e){
                    String text=textArea.getSelectedText();
                     
                    if(text!=null){ 
                        textArea.deletePreviousChar();
                              
                    }
                }
        
        });

        menuItemSelectAll.setId("menuSelectAll");
        menuItemSelectAll.setMnemonicParsing(false);
        menuItemSelectAll.setText("Select All");
        
        menuItemSelectAll.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
        
                public void handle(ActionEvent e){
                
                    textArea.selectAll();
                    
                }
        });

        menuHelp.setMnemonicParsing(false);
        menuHelp.setText("Help");

        menuItemAbout.setMnemonicParsing(false);
        menuItemAbout.setText("About");
        setTop(menuBar);
        menuItemAbout.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
        
                public void handle(ActionEvent e){
                
                    Alert alter=new Alert(AlertType.INFORMATION);
                    alter.setTitle("About");
                    alter.setHeaderText("Node Pad Application is contain ... ");
                    alter.show();
                    System.out.println("About");
                    
                }
        
        });

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        setCenter(textArea);

        menu.getItems().add(menuItemNew);
        menu.getItems().add(menuItemOpen);
        menu.getItems().add(menuItemSave);
        menu.getItems().add(menuItemExit);
        menuBar.getMenus().add(menu);
        menuEdit.getItems().add(menuItemCut);
        menuEdit.getItems().add(menuItemCopy);
        menuEdit.getItems().add(menuItemPast);
        menuEdit.getItems().add(menuItemDelete);
        menuEdit.getItems().add(menuItemSelectAll);
        menuBar.getMenus().add(menuEdit);
        menuHelp.getItems().add(menuItemAbout);
        menuBar.getMenus().add(menuHelp);

       
        
    }
    
    
}
