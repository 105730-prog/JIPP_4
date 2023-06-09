package libProject;

import com.sun.jdi.IntegerValue;

import java.util.*;

public class Bookshelf {
    private List<Book> books = new ArrayList<>();
    private Set<String> authors = new HashSet<>();
    private Map<Integer, Book> bookNumbers = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public void addBook() {
        System.out.println("Type Book Name");
        String name = scanner.nextLine();

        System.out.println("Type an Author");
        String author = scanner.nextLine();

        System.out.println("Type ISBN Number");
        int isbnNumber = Integer.valueOf(scanner.nextLine());

        System.out.println("Is It in PDF Document ? (Y/N)");
        String isOnlineString = scanner.nextLine();

        boolean isOnline;

        if (isOnlineString.equals("Y")){
            isOnline = true;
        }
        else{
            isOnline = false;
        }

        Book book = new Book(name, author, isbnNumber, isOnline);

        authors.add(author);
        bookNumbers.put(isbnNumber, book);
        books.add(book);
    }

    public void displayAuthors() {
        for(String author : authors){
            System.out.println(author);
        }
    }

    public void displayBookByIsbnNumber(){
        System.out.println("Type a ISBN Number");

            Integer isbnNumber = Integer.valueOf(scanner.nextLine()); // 6 - digit number
            Book book = bookNumbers.get(isbnNumber);

            book.displayBookInformation();
    }

    public void displayBooks() {
        for (Book book : books) {
            book.displayBookInformation();
        }
    }
}
