import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    void displayContact() {
        System.out.println("Name: " + name + ", Phone: " + phone);
    }
}

public class Main {

    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n📞 Contact Management System developed by Monty");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact by Name");
            System.out.println("4. Sort Contacts by Name");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    sortContacts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    static void addContact() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        contacts.add(new Contact(name, phone));
        System.out.println("✅ Contact added successfully!");
    }

    static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (Contact c : contacts) {
                c.displayContact();
            }
        }
    }

    static void searchContact() {
        System.out.print("Enter name to search: ");
        String searchName = scanner.nextLine();

        boolean found = false;

        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(searchName)) {
                c.displayContact();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    static void sortContacts() {
        Collections.sort(contacts, Comparator.comparing(c -> c.name.toLowerCase()));
        System.out.println("📂 Contacts sorted alphabetically.");
    }
}
