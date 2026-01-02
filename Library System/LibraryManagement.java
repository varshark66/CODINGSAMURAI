import java.util.Scanner;

class Book {
    String title;
    boolean isIssued;

    Book(String title) {
        this.title = title;
        this.isIssued = false;
    }
}

public class LibraryManagement {

    static Book[] books = {
        new Book("Java Programming"),
        new Book("Data Structures"),
        new Book("Operating Systems"),
        new Book("Computer Networks")
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n Varsha's Library Management System ");
            System.out.println("1. View Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    borrowBook(sc);
                    break;
                case 3:
                    returnBook(sc);
                    break;
                case 4:
                    System.out.println("Thank you for visiting");
                    break;
                default:
                    System.out.println("Invalid");
            }
        } while (choice != 4);

        sc.close();
    }

    static void displayBooks() {
        System.out.println("\nAvailable Books:");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " + books[i].title +
                    (books[i].isIssued ? " (Issued)" : " (Available)"));
        }
    }

    static void borrowBook(Scanner sc) {
        displayBooks();
        System.out.print("Enter book number to borrow: ");
        int num = sc.nextInt();

        if (num > 0 && num <= books.length && !books[num - 1].isIssued) {
            books[num - 1].isIssued = true;
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book unavailable");
        }
    }

    static void returnBook(Scanner sc) {
        System.out.print("Enter book number to return: ");
        int num = sc.nextInt();

        if (num > 0 && num <= books.length && books[num - 1].isIssued) {
            books[num - 1].isIssued = false;
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Invalid  request.");
        }
    }
}
