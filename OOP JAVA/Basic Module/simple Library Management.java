import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Book> library = new ArrayList<>();
        
        library.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        library.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        library.add(new Book("1984", "George Orwell", 1949));
        
        boolean running = true;
        while (running) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add a book");
            System.out.println("2. View all books");
            System.out.println("3. Search for a book by title");
            System.out.println("4. Check out a book");
            System.out.println("5. Return a book");
            System.out.println("6. Sort books");
            System.out.println("7. View available books only");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            
            switch (choice) {
                case 1:
                    addBook(scanner, library);
                    break;
                    
                case 2:
                    viewAllBooks(library);
                    break;
                    
                case 3:
                    searchBooks(scanner, library);
                    break;
                    
                case 4:
                    checkOutBook(scanner, library);
                    break;
                    
                case 5:
                    returnBook(scanner, library);
                    break;
                    
                case 6:
                    sortBooks(scanner, library);
                    break;
                    
                case 7:
                    viewAvailableBooks(library);
                    break;
                    
                case 8:
                    System.out.println("Thank you for using the Library Management System. Goodbye!");
                    running = false;
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
    
    private static void addBook(Scanner scanner, ArrayList<Book> library) {
        System.out.println("\n----- Add a New Book -----");
        
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        
        int year = 0;
        boolean validYear = false;
        while (!validYear) {
            System.out.print("Enter publication year: ");
            try {
                year = Integer.parseInt(scanner.nextLine());
                validYear = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please enter a number.");
            }
        }
        
        Book newBook = new Book(title, author, year);
        library.add(newBook);
        
        System.out.println("Book added successfully: " + newBook);
    }
    
    private static void viewAllBooks(ArrayList<Book> library) {
        System.out.println("\n----- All Books in Library -----");
        
        if (library.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        
        for (int i = 0; i < library.size(); i++) {
            System.out.println((i + 1) + ". " + library.get(i));
        }
    }
    
    private static void searchBooks(Scanner scanner, ArrayList<Book> library) {
        System.out.println("\n----- Search Books -----");
        
        System.out.print("Enter search term (title or author): ");
        String searchTerm = scanner.nextLine().toLowerCase();
        
        System.out.println("Search results:");
        boolean found = false;
        
        for (int i = 0; i < library.size(); i++) {
            Book book = library.get(i);
            if (book.getBookTitle().toLowerCase().contains(searchTerm) || 
                book.getAuthor().toLowerCase().contains(searchTerm)) {
                System.out.println((i + 1) + ". " + book);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No books found matching \"" + searchTerm + "\"");
        }
    }
    
    private static void checkOutBook(Scanner scanner, ArrayList<Book> library) {
        System.out.println("\n----- Check Out a Book -----");
        
        if (library.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        
        System.out.println("Available books:");
        boolean hasAvailable = false;
        
        for (int i = 0; i < library.size(); i++) {
            Book book = library.get(i);
            if (book.isAvailable()) {
                System.out.println((i + 1) + ". " + book);
                hasAvailable = true;
            }
        }
        
        if (!hasAvailable) {
            System.out.println("No books are currently available.");
            return;
        }
        
        System.out.print("Enter the number of the book to check out: ");
        try {
            int bookNumber = Integer.parseInt(scanner.nextLine());
            
            if (bookNumber < 1 || bookNumber > library.size()) {
                System.out.println("Invalid book number.");
                return;
            }
            
            Book selectedBook = library.get(bookNumber - 1);
            
            if (selectedBook.checkOut()) {
                System.out.println("Book checked out successfully: " + selectedBook);
            } else {
                System.out.println("Book is already checked out.");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
    
    private static void returnBook(Scanner scanner, ArrayList<Book> library) {
        System.out.println("\n----- Return a Book -----");
        
        if (library.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        
        System.out.println("Checked out books:");
        boolean hasCheckedOut = false;
        
        for (int i = 0; i < library.size(); i++) {
            Book book = library.get(i);
            if (!book.isAvailable()) {
                System.out.println((i + 1) + ". " + book);
                hasCheckedOut = true;
            }
        }
        
        if (!hasCheckedOut) {
            System.out.println("No books are currently checked out.");
            return;
        }
        
        System.out.print("Enter the number of the book to return: ");
        try {
            int bookNumber = Integer.parseInt(scanner.nextLine());
            
            if (bookNumber < 1 || bookNumber > library.size()) {
                System.out.println("Invalid book number.");
                return;
            }
            
            Book selectedBook = library.get(bookNumber - 1);
            
            if (selectedBook.returnBook()) {
                System.out.println("Book returned successfully: " + selectedBook);
            } else {
                System.out.println("Book was not checked out.");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
    
    private static void sortBooks(Scanner scanner, ArrayList<Book> library) {
        System.out.println("\n----- Sort Books -----");
        
        if (library.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. Publication Year");
        System.out.print("Enter your choice: ");
        
        try {
            int sortChoice = Integer.parseInt(scanner.nextLine());
            
            switch (sortChoice) {
                case 1:
                    Collections.sort(library, new Comparator<Book>() {
                        @Override
                        public int compare(Book b1, Book b2) {
                            return b1.getBookTitle().compareToIgnoreCase(b2.getBookTitle());
                        }
                    });
                    System.out.println("Books sorted by title.");
                    break;
                    
                case 2:
                    Collections.sort(library, new Comparator<Book>() {
                        @Override
                        public int compare(Book b1, Book b2) {
                            return b1.getAuthor().compareToIgnoreCase(b2.getAuthor());
                        }
                    });
                    System.out.println("Books sorted by author.");
                    break;
                    
                case 3:
                    Collections.sort(library, new Comparator<Book>() {
                        @Override
                        public int compare(Book b1, Book b2) {
                            return Integer.compare(b1.getPublicationYear(), b2.getPublicationYear());
                        }
                    });
                    System.out.println("Books sorted by publication year.");
                    break;
                    
                default:
                    System.out.println("Invalid choice.");
                    return;
            }
            
            viewAllBooks(library);
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
    
    private static void viewAvailableBooks(ArrayList<Book> library) {
        System.out.println("\n----- Available Books -----");
        
        if (library.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        
        boolean found = false;
        for (int i = 0; i < library.size(); i++) {
            Book book = library.get(i);
            if (book.isAvailable()) {
                System.out.println((i + 1) + ". " + book);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No books are currently available.");
        }
    }
}
