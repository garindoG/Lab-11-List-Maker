
import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        String choice;
        boolean quit = false;

        do {
            displayMenu(list);

            choice = SafeInput.getRegExString(
                    console,
                    "Enter your choice: ",
                    "[AaDdIiPpQq]"
            );

            switch (choice.toUpperCase()) {

                case "A":
                    addItem(console, list);
                    break;

                case "D":
                    deleteItem(console, list);
                    break;

                case "I":
                    insertItem(console, list);
                    break;

                case "P":
                    printList(list);
                    break;

                case "Q":
                    quit = SafeInput.getYNConfirm(
                            console,
                            "Are you sure you want to quit?"
                    );
                    break;
            }

        } while (!quit);

        System.out.println("Goodbye!");
        console.close();
    }

    // Displays the current list and menu
    public static void displayMenu(ArrayList<String> list) {

        System.out.println("\n===== LIST MAKER =====");

        if (list.isEmpty()) {
            System.out.println("Your list is currently empty.");
        } else {
            System.out.println("Current List:");

            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }

        System.out.println("\nA - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
    }

    // Adds an item to the end of the list
    public static void addItem(Scanner console, ArrayList<String> list) {

        System.out.print("Enter the item you want to add: ");
        String item = console.nextLine();

        list.add(item);

        System.out.println(item + " was added to your list!");
    }

    // Deletes an item from the list
    public static void deleteItem(Scanner console, ArrayList<String> list) {

        if (list.isEmpty()) {
            System.out.println("There are no items to delete.");
            return;
        }

        displayNumberedList(list);

        int itemNumber = SafeInput.getRangedInt(
                console,
                "Enter the number of the item to delete: ",
                1,
                list.size()
        );

        String removedItem = list.remove(itemNumber - 1);

        System.out.println(removedItem + " was deleted.");
    }

    // Inserts an item at a selected position
    public static void insertItem(Scanner console, ArrayList<String> list) {

        System.out.print("Enter the item you want to insert: ");
        String item = console.nextLine();

        int position = SafeInput.getRangedInt(
                console,
                "Enter the position where you want to insert it: ",
                1,
                list.size() + 1
        );

        list.add(position - 1, item);

        System.out.println(item + " was inserted into your list.");
    }

    // Prints the current list
    public static void printList(ArrayList<String> list) {

        if (list.isEmpty()) {
            System.out.println("Your list is empty.");
            return;
        }

        System.out.println("\n===== YOUR LIST =====");

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    // Displays the list with item numbers
    public static void displayNumberedList(ArrayList<String> list) {

        System.out.println("\n===== SELECT AN ITEM =====");

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}
