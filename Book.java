 /*
* Programmer: Jasleen Kaur
* Program name :This class contains get and set methods.
* Date: 5 Aug,2020
*/
package assignment6;

/**
 *
 * @author jasle
 */
public class Book 
{
    private String bookname,author;
    private int quantity;
    private double price;

    public Book() {
    }

    public Book(String bookname, String author, int quantity, double price) {
        this.bookname = bookname;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
    }

    public String getBookname() {
        return bookname;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }   
}
