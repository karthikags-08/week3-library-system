


import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
            System.out.println("1. Add New Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Books");
            System.out.println("4. Register Member");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. View Library Statistics");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Year: ");
                    int year = sc.nextInt();
                    library.addBook(new Book(isbn, title, author, year));
                    break;

                case 2:
                    library.displayAllBooks();
                    break;

                case 3:
                    System.out.print("Enter keyword: ");
                    String key = sc.nextLine();
                    List<Book> results = library.searchBooks(key);
                    results.forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Member ID: ");
                    String id = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    library.registerMember(new Member(id, name));
                    break;

                case 5:
                    System.out.print("ISBN: ");
                    String bIsbn = sc.nextLine();
                    System.out.print("Member ID: ");
                    String mId = sc.nextLine();
                    library.borrowBook(bIsbn, mId);
                    break;

                case 6:
                    System.out.print("ISBN: ");
                    String rIsbn = sc.nextLine();
                    System.out.print("Member ID: ");
                    String rId = sc.nextLine();
                    library.returnBook(rIsbn, rId);
                    break;

                case 7:
                    library.displayStatistics();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
            }
        }
    }
}
