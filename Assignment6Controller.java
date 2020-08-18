 /*
* Programmer: Jasleen Kaur
* Program name : Assignment6 - To enter book details and performing various functions using buttons like storing them in arraylist, writing in file. 
* Date: 5 Aug,2020
*/
package assignment6;

 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jasleen
 */
public class Assignment6Controller implements Initializable {

    @FXML
    private TextField txt1,txt2,txt3,txt4,txt5;
    @FXML
    private TextArea txtArea;
    @FXML
    private Button btnSearch,btnAdd,btnSave,btnExit,btnWrite,btnNext,btnPrevious,btnEdit,btnDisplay;
   File myfile=new File("test.txt"); 
    static int record=0;
    PrintWriter output;
    Scanner input;
   
     ArrayList<Book> list=new ArrayList<Book>();//arraylist
    
    /**
     * This method is used to save the book details enter by the user into arraylist when save button is pressed.
     * @param event 
     */
     @FXML
    private void save(ActionEvent event)
    {
        Book b=new Book();
        b.setBookname(txt1.getText());
        b.setAuthor(txt2.getText());
        b.setPrice(Double.parseDouble(txt3.getText()));
        b.setQuantity(Integer.parseInt(txt4.getText()));
        if(record==list.size())
        {
            list.add(b);
            System.out.println("Record saved in arrayList");
        }
        else
        {
            list.set(record, b);
        }
    }
    /**
     * This method is used to add a new book detail when add button is pressed.
     * @param event 
     */
      @FXML
    private void add(ActionEvent event)
    {
        record=list.size();
        System.out.println("Add new record");
        txt1.clear();
        txt2.clear();
        txt3.clear();
        txt4.clear();        
    }
    /**
     * This method is used to write the book details into the file when write button is pressed.
     * @param event 
     */
    @FXML
    private void write(ActionEvent event) 
    {
        try
        {
            PrintWriter pr=new PrintWriter(myfile);
            System.out.println("printwiter pr empty file");
            pr.print("");
            pr.close();
            
            
            FileWriter fw=new FileWriter(myfile,true); //append mode
            output=new PrintWriter(fw);
            for(int i=0;i<list.size();i++)
            {
                output.println(list.get(i).getBookname()+","+list.get(i).getAuthor()+","+list.get(i).getPrice()+","+list.get(i).getQuantity());
                
            }
            System.out.println("Record saved in the file");
            output.close();
        }
        catch(Exception e)
        {
            System.out.println("error in writing the file");
        }
    }
    /**
     * This method is used to display exit screen when user clicks on exit button.
     * @param event 
     */
    @FXML
    private void exit(ActionEvent event)
    {
      Alert a=new Alert(Alert.AlertType.CONFIRMATION);
      a.setTitle("Exit message");
      a.setHeaderText("Confirmation");
      a.setContentText("press OK if you want to exit");
      a.showAndWait().ifPresent(response -> { 
        if(response == ButtonType.OK)
            {
                System.exit(0);
            }
         });      
    
   }
    /**
     * This method is used to edit a book detail.
     * @param event 
     */
    @FXML
    private void edit(ActionEvent event)
    {
        btnSave.setDisable(false);
        btnAdd.setDisable(true);
        if(record==0)
            btnPrevious.setDisable(true);
        else
            btnPrevious.setDisable(false);
        
        if(record==list.size()-1)
                btnNext.setDisable(true);
        else
                btnNext.setDisable(false);
    }
    /**
     * This method is used to display the previous record of book.
     * @param event 
     */
    @FXML
    private void previous(ActionEvent event)
    {
        try
        {
        record--;
        txt1.setText(list.get(record).getBookname());
        txt2.setText(list.get(record).getAuthor());
        txt3.setText(String.valueOf(list.get(record).getPrice()));
        txt4.setText(String.valueOf(list.get(record).getQuantity()));
        if(record==0)
            btnPrevious.setDisable(true);
        else
            btnPrevious.setDisable(false);
        
        if(record==list.size()-1)
                btnNext.setDisable(true);
        else
                btnNext.setDisable(false);
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("no previous record");
        }
    }
    /**
     * This method is used to display the next record of the book.
     * @param event 
     */
    @FXML
    private void next(ActionEvent event)
    {
        try
        {
        
        record++;
        txt1.setText(list.get(record).getBookname());
        txt2.setText(list.get(record).getAuthor());
        txt3.setText(String.valueOf(list.get(record).getPrice()));
        txt4.setText(String.valueOf(list.get(record).getQuantity()));
        
        if(record==0)
            btnPrevious.setDisable(true);
        else
            btnPrevious.setDisable(false);
        
        if(record==list.size()-1)
                btnNext.setDisable(true);
        else
                btnNext.setDisable(false);
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("no next records present");
        }
    }
    /**
     * This method is used to display the records of book in the text area.
     * @param event 
     */
     @FXML
    private void display(ActionEvent event)
    {
        txtArea.setText("");
       
        try
        {
            Scanner input=new Scanner(myfile);
            if(myfile.exists())
                    {
                        while(input.hasNext())
                        {
                            String s=input.next();
                            Scanner scn=new Scanner(s);
                            scn.useDelimiter(",");
                            String name=scn.next();
                            String author=scn.next();
                            double price=scn.nextDouble();
                            int books=scn.nextInt();
                            double total=price*books;
                            txtArea.appendText("Book name: "+name);
                            txtArea.appendText("\n Author name: "+author);
                            txtArea.appendText("\n Price of book: "+price);
                            txtArea.appendText("\n Number of books in stock : "+books);
                            txtArea.appendText("\n Total price: "+total+"\n");
                            txtArea.appendText("---------------------------\n");
                            
                            
                            
                        }
                    }
            input.close();
            
        }
        catch(IOException e)
                {
                    System.out.println("Error in file");
                }
         catch (InputMismatchException ex) 
        {
            System.out.println("invalid input");
        }
        
    }
    /**
     * This method is used to search the book name entered by the user in the arraylist.
     * @param event 
     */
    @FXML
    private void search(ActionEvent event)
    {
         String text="";
     String value = txt5.getText();
     for (Book books: list){
     if(books.getBookname().equals(value)){
         text = "Book name:"+books.getBookname()+"\t"+"Author name:"+books.getAuthor()+"\t"+"Price of book:"+books.getPrice()+"\t"+"Quantity:"+books.getQuantity();
        break;
     }
    
     else{
             text = "Book not found";
             }
      }
              txtArea.setText(text);

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }   
}
    

