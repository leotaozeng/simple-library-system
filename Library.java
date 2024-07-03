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
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        String lowerCaseTitle = title.toLowerCase();

        System.out.print("Enter author: ");
        String author = scanner.nextLine().toLowerCase();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        if (books.containsKey(lowerCaseTitle)) {
            // The book already exists, we update the quantity
            books.get(lowerCaseTitle).addQuantity(quantity);
            System.out.println("Successfully updated the quantity of the existing book \"" + title + "\".");
        } else {
            // The book is new, we add it to the library
            books.put(lowerCaseTitle, new Book(lowerCaseTitle, author, quantity));
            System.out.println("Successfully added the book \"" + title + "\" to the library.");
        }
    }

    public void borrowBook(Scanner scanner) {
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        String lowerCaseTitle = title.toLowerCase();

        System.out.print("Enter quantity to borrow: ");
        int quantity = scanner.nextInt();

        if (books.containsKey(lowerCaseTitle)) {
            if (books.get(lowerCaseTitle).borrowBook(quantity)) {
                System.out.println("Successfully borrowed " + quantity + " copies of the book \"" + title + "\".");
            } else {
                System.out.println("Not enough copies are available to borrow.");
            }
        } else {
            System.out.println("The book \"" + title + "\" could not be found in the library.");
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

    public boolean bookExists(String title) {
        return books.containsKey(title);
    }
}