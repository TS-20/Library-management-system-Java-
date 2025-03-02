import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    boolean isIssued;

    Book(String title) {
        this.title = title;
        this.isIssued = false;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();
    
    void addBook(String title) {
        books.add(new Book(title));
        System.out.println("Book added: " + title);
    }
    
    void displayBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isIssued) {
                System.out.println(book.title);
            }
        }
    }
    
    void issueBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && !book.isIssued) {
                book.isIssued = true;
                System.out.println("Book issued: " + title);
                return;
            }
        }
        System.out.println("Book not available or already issued.");
    }
    
    void returnBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && book.isIssued) {
                book.isIssued = false;
                System.out.println("Book returned: " + title);
                return;
            }
        }
        System.out.println("Invalid return request.");
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    library.addBook(title);
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter book title to issue: ");
                    title = sc.nextLine();
                    library.issueBook(title);
                    break;
                case 4:
                    System.out.print("Enter book title to return: ");
                    title = sc.nextLine();
                    library.returnBook(title);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
