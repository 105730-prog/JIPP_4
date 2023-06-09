package libProject;

public class Book {
    private String name;
    private String author;
    private int isbnNumber;
    private boolean isOnline;

    public Book(String name, String author, int isbnNumber, boolean isOnline) {
        this.name = name;
        this.author = author;
        this.isbnNumber = isbnNumber;
        this.isOnline = isOnline;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getIsbnNumber() {
        return isbnNumber;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void displayBookInformation() {
        System.out.println("Name: " + name);
        System.out.println("Author: " + author);
        System.out.println("ISBN Number: " + isbnNumber);
        String isOnlineString = isOnline ? "PDF" : "Paper";
        System.out.println("Book Format: " + isOnlineString);
        System.out.println(" ");
    }
}