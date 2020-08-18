/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jasle
 */
public class Assignment6 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) //main method
    {
         launch(args);
          }
    @Override
    public void start(Stage stage) throws IOException
    {
       Parent root = FXMLLoader.load(getClass().getResource("Assignment6.fxml"));       
        Scene scene=new Scene(root);
        stage.setTitle("Book details");
        stage.setScene(scene);
        stage.show();
    }
    
}
