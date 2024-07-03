import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Create a Library class
public class Library {
    Map<String, Book> books;

    // Create a class constructor for the Library class
    public Library() {
        books = new HashMap<>();
    }

    public void addBook(Scanner scanner) {
        // Prompt the user to enter the book title
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        // Prompt the user to enter the author
        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        // Prompt the user to enter the quantity
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        if (books.containsKey(title)) {
            System.out.println(books.get(title));
            books.get(title).addQuantity(quantity);
        } else {
            books.put(title, new Book(title, author, quantity));
        }
    }

    public void borrowBook(Scanner scanner) {
        // Prompt the user to enter the book title
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        // Prompt the user to enter the number of books to borrow
        System.out.print("Enter quantity to borrow: ");
        int quantity = scanner.nextInt();

        if (books.containsKey(title) && books.get(title).borrowBook(quantity)) {
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Error: Book not available or insufficient quantity.");
        }
    }

    public void returnBook(Scanner scanner) {
        // Prompt the user to enter the book title
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        // Prompt the user to enter the number of books to return
        System.out.print("Enter quantity to return: ");
        int quantity = scanner.nextInt();

        if (books.containsKey(title)) {
            books.get(title).returnBook(quantity);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Error: Book not available or insufficient quantity.");
        }
    }

//    public boolean bookExists(String title) {
//        return books.containsKey(title);
//    }
}
