package helljava;

import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alex
 */
public class listElement implements Serializable {

    private int bookId;
    private String bookName;
    private String bookAuthor;
    private String bookGenre;
    private int bookYear;
    private int bookAmount;
    private int bookPrice;
    private int bookRate;

    /**
     * @return the bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @param bookName the bookName to set
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * @return the bookAuthor
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * @param bookAuthor the bookAuthor to set
     */
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    /**
     * @return the bookGenre
     */
    public String getBookGenre() {
        return bookGenre;
    }

    /**
     * @param bookGenre the bookGenre to set
     */
    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    /**
     * @return the bookYear
     */
    public int getBookYear() {
        return bookYear;
    }

    /**
     * @param bookYear the bookYear to set
     */
    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    /**
     * @return the bookAmount
     */
    public int getBookAmount() {
        return bookAmount;
    }

    /**
     * @param bookAmount the bookAmount to set
     */
    public void setBookAmount(int bookAmount) {
        this.bookAmount = bookAmount;
    }

    /**
     * @return the bookPrice
     */
    public int getBookPrice() {
        return bookPrice;
    }

    /**
     * @param bookPrice the bookPrice to set
     */
    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    /**
     * @return the bookId
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * @param bookId the bookId to set
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /**
     * @return the bookRate
     */
    public int getBookRate() {
        return bookRate;
    }

    /**
     * @param bookRate the bookRate to set
     */
    public void setBookRate(int bookRate) {
        this.bookRate = bookRate;
    }

  
}
