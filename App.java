import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    Library library = new Library(); // Create an object of class Library (This will call the constructor)

    public static void main(String[] args) {
        App system = new App();
        system.run();
    }

    public void run() {
        int choice;
        do {
            System.out.println("Welcome to the Library System!\nHere are the options:");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // Get the user's choice
            // nextInt() reads a int value from the user
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.addBook(scanner);
                    break;
                case 2:
                    library.borrowBook(scanner);
                    break;
                case 3:
                    library.returnBook(scanner);
                    break;
                case 4:
                    // Exit the program
                    break;
                default:
                    // Handle invalid input and display appropriate error messages
                    System.out.println("Invalid choice. Please try again.\n");
            }
        } while (choice != 4);
    }
}
