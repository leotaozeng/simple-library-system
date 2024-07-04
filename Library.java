import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Library {
    private final Map<String, Book> books; // A collection to store books, mapped by their title

    // Constructor to initialize the library with an empty collection of books
    public Library() {
        books = new HashMap<>();
    }

    /**
     * Method to check if a book exists in the library
     */
    public boolean checkBookExists(String title) {
        return books.containsKey(title);
    }

    /**
     * Method to add a book to the library
     * If the book already exists in the library, update the quantity
     * If the book is new, add it to the library
     */
    public void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        String lowerCaseTitle = title.toLowerCase();

        System.out.print("Enter author: ");
        String author = scanner.nextLine().toLowerCase();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        if (checkBookExists(lowerCaseTitle)) {
            books.get(lowerCaseTitle).addQuantity(quantity);
            System.out.println("Successfully updated the quantity of the existing book \"" + title + "\".");
        } else {
            books.put(lowerCaseTitle, new Book(lowerCaseTitle, author, quantity));
            System.out.println("Successfully added the book \"" + title + "\" to the library.");
        }
    }

    /**
     * Method to borrow a book from the library
     * Check if the requested number of books is available in the library
     * If the books are available, update the quantity and display a success message
     * If not, display an error message
     */
    public void borrowBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        String lowerCaseTitle = title.toLowerCase();

        System.out.print("Enter quantity to borrow: ");
        int quantity = scanner.nextInt();

        if (checkBookExists(lowerCaseTitle)) {
            Book book = books.get(lowerCaseTitle);
            if (book.borrow(quantity)) {
                System.out.println("Successfully borrowed " + quantity + " copies of the book \"" + title + "\".");
            } else {
                System.out.println("Not enough copies are available to borrow.");
            }
        } else {
            System.out.println("The book \"" + title + "\" could not be found in the library.");
        }
    }

    /**
     * Method to return a book to the library
     * Check if the books being returned belong to the library system
     * If they do, update the quantity and display a success message
     * If not, display an error message
     */
    public void returnBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        String lowerCaseTitle = title.toLowerCase();

        System.out.print("Enter quantity to return: ");
        int quantity = scanner.nextInt();

        if (checkBookExists(lowerCaseTitle)) {
            Book book = books.get(lowerCaseTitle);
            book.setQuantity(book.getQuantity() + quantity);
            System.out.println("Successfully returned " + quantity + " copies of the book \"" + title + "\".");
        } else {
            System.out.println("The book \"" + title + "\" could not be found in the library.");
        }
    }
}