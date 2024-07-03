import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Library {
    Map<String, Book> books;

    // Create a class constructor for the Library class
    public Library() {
        books = new HashMap<>();
    }

    public boolean checkBookExists(String title) {
        return books.containsKey(title);
    }

    public void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        String lowerCaseTitle = title.toLowerCase();

        System.out.print("Enter author: ");
        String author = scanner.nextLine().toLowerCase();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        if (checkBookExists(lowerCaseTitle)) {
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
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        String lowerCaseTitle = title.toLowerCase();

        System.out.print("Enter quantity to borrow: ");
        int quantity = scanner.nextInt();


        /*
         Check if the requested number of books is available in the library.
         If the books are available, update the quantity and display a success message.
         If not, display an error message.
        */
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

    public void returnBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        String lowerCaseTitle = title.toLowerCase();

        System.out.print("Enter quantity to return: ");
        int quantity = scanner.nextInt();

        /*
         Check if the books being returned belong to the library system.
         If they do, update the quantity and display a success message.
         If not, display an error message.
        */
        if (checkBookExists(lowerCaseTitle)) {
            Book book = books.get(lowerCaseTitle);
            book.setQuantity(book.getQuantity() + quantity);
            System.out.println("Successfully returned " + quantity + " copies of the book \"" + title + "\".");
        } else {
            System.out.println("The book \"" + title + "\" could not be found in the library.");
        }
    }
}