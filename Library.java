import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Library data
        String[] subjects = {"C", "Java", "Python", "Data Structures", "Algorithms"};
        int[] rackNumbers = {1, 2, 3, 4, 5};
        String[][] books = {
            {"C Programming Language", "Head First C", "C Primer Plus"},
            {"Effective Java", "Java: The Complete Reference", "Core Java Volume I"},
            {"Python Crash Course", "Automate the Boring Stuff with Python", "Learning Python"},
            {"Introduction to Algorithms", "Data Structures and Algorithms in Java", "Data Structures Using C and C++"},
            {"The Algorithm Design Manual", "Introduction to Algorithms", "Algorithms Unlocked"}
        };
        int[][] bookCounts = {
            {5, 3, 2},
            {4, 5, 6},
            {6, 4, 2},
            {3, 3, 2},
            {4, 2, 1}
        };

        while (true) {
            // Display menu options
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display all books");
            System.out.println("2. Search for a book");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Display all books
                    System.out.println("\nBooks available in the library:");
                    for (int i = 0; i < subjects.length; i++) {
                        System.out.println("Subject: " + subjects[i] + ", Rack No.: " + rackNumbers[i]);
                        for (int j = 0; j < books[i].length; j++) {
                            System.out.println("  - " + books[i][j] + " (Available: " + bookCounts[i][j] + ")");
                        }
                    }
                    break;

                case 2:
                    // Search for a book
                    System.out.print("\nEnter the subject to search: ");
                    scanner.nextLine(); // Consume newline
                    String searchSubject = scanner.nextLine();
                    int foundIndex = -1;

                    for (int i = 0; i < subjects.length; i++) {
                        if (subjects[i].equalsIgnoreCase(searchSubject)) {
                            foundIndex = i;
                            break;
                        }
                    }

                    if (foundIndex != -1) {
                        System.out.println("Books available for " + subjects[foundIndex] + ":");
                        for (int j = 0; j < books[foundIndex].length; j++) {
                            System.out.println("  - " + books[foundIndex][j] + " (Available: " + bookCounts[foundIndex][j] + ")");
                        }
                    } else {
                        System.out.println("Subject not found in the library.");
                    }
                    break;

                case 3:
                    // Borrow a book
                    System.out.print("\nEnter the subject to borrow a book from: ");
                    scanner.nextLine(); // Consume newline
                    String borrowSubject = scanner.nextLine();
                    foundIndex = -1;

                    for (int i = 0; i < subjects.length; i++) {
                        if (subjects[i].equalsIgnoreCase(borrowSubject)) {
                            foundIndex = i;
                            break;
                        }
                    }

                    if (foundIndex != -1) {
                        System.out.println("Books available for " + subjects[foundIndex] + ":");
                        for (int j = 0; j < books[foundIndex].length; j++) {
                            System.out.println((j + 1) + ". " + books[foundIndex][j] + " (Available: " + bookCounts[foundIndex][j] + ")");
                        }

                        System.out.print("Choose the book number to borrow: ");
                        int bookChoice = scanner.nextInt();
                        if (bookChoice >= 1 && bookChoice <= books[foundIndex].length) {
                            if (bookCounts[foundIndex][bookChoice - 1] > 0) {
                                bookCounts[foundIndex][bookChoice - 1]--;
                                System.out.println("You have successfully borrowed \"" + books[foundIndex][bookChoice - 1] + "\".");
                            } else {
                                System.out.println("No copies available for \"" + books[foundIndex][bookChoice - 1] + "\".");
                            }
                        } else {
                            System.out.println("Invalid book choice.");
                        }
                    } else {
                        System.out.println("Subject not found in the library.");
                    }
                    break;

                case 4:
                    // Return a book
                    System.out.print("\nEnter the subject to return a book to: ");
                    scanner.nextLine(); // Consume newline
                    String returnSubject = scanner.nextLine();
                    foundIndex = -1;

                    for (int i = 0; i < subjects.length; i++) {
                        if (subjects[i].equalsIgnoreCase(returnSubject)) {
                            foundIndex = i;
                            break;
                        }
                    }

                    if (foundIndex != -1) {
                        System.out.println("Books available for " + subjects[foundIndex] + ":");
                        for (int j = 0; j < books[foundIndex].length; j++) {
                            System.out.println((j + 1) + ". " + books[foundIndex][j] + " (Available: " + bookCounts[foundIndex][j] + ")");
                        }

                        System.out.print("Choose the book number to return: ");
                        int bookChoice = scanner.nextInt();
                        if (bookChoice >= 1 && bookChoice <= books[foundIndex].length) {
                            bookCounts[foundIndex][bookChoice - 1]++;
                            System.out.println("You have successfully returned \"" + books[foundIndex][bookChoice - 1] + "\".");
                        } else {
                            System.out.println("Invalid book choice.");
                        }
                    } else {
                        System.out.println("Subject not found in the library.");
                    }
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
