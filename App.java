/**
 * Name: Taphanatu Sesay
 * Date: 3/22/2026
 * Project Week 3: Arrays and Lists
 * Description:
 * This program demonstrates part of a calculator application's
 * memory functions using a single value and a collection of integers.
 */

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CalculatorMemory memory = new CalculatorMemory();
        boolean running = true;

        // Title line
        System.out.println("==============================================");
        System.out.println("Project Week 3 - Arrays and Lists");
        System.out.println("Created by: Grace Sesay");
        System.out.println("==============================================");

        // Welcome message and instructions
        System.out.println("\nWelcome to the Calculator Memory Application!");
        System.out.println("This program allows you to use a single memory value");
        System.out.println("and also store up to 10 integer values in a list.");
        System.out.println("Choose an option from the menu to continue.");

        while (running) {
            System.out.println("\n--------------- MENU ---------------");
            System.out.println("1. Store single value in memory");
            System.out.println("2. Retrieve single memory value");
            System.out.println("3. Clear single memory value");
            System.out.println("4. Replace single memory value");
            System.out.println("5. Add integer values to collection");
            System.out.println("6. Display all values in collection");
            System.out.println("7. Display count of values in collection");
            System.out.println("8. Remove a value from collection");
            System.out.println("9. Get sum of collection values");
            System.out.println("10. Get average of collection values");
            System.out.println("11. Get difference of first and last values");
            System.out.println("12. Quit");
            System.out.print("Enter your choice: ");

            int choice;
            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number from 1 to 12.");
                input.next();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter a single numeric value to store: ");
                    if (input.hasNextDouble()) {
                        double value = input.nextDouble();
                        memory.storeSingleValue(value);
                        System.out.println("Single memory value stored successfully.");
                    } else {
                        System.out.println("Invalid input. Please enter a numeric value.");
                        input.next();
                    }
                    break;

                case 2:
                    if (memory.hasSingleValue()) {
                        System.out.println("Stored single memory value: " + memory.retrieveSingleValue());
                    } else {
                        System.out.println("No single memory value is currently stored.");
                    }
                    break;

                case 3:
                    memory.clearSingleValue();
                    System.out.println("Single memory value has been cleared.");
                    break;

                case 4:
                    System.out.print("Enter a new numeric value to replace the current one: ");
                    if (input.hasNextDouble()) {
                        double newValue = input.nextDouble();
                        memory.replaceSingleValue(newValue);
                        System.out.println("Single memory value replaced successfully.");
                    } else {
                        System.out.println("Invalid input. Please enter a numeric value.");
                        input.next();
                    }
                    break;

                case 5:
                    if (memory.isCollectionFull()) {
                        System.out.println("The collection already has 10 values. No more can be added.");
                    } else {
                        System.out.print("How many integer values would you like to add? ");
                        if (input.hasNextInt()) {
                            int amount = input.nextInt();

                            if (amount <= 0) {
                                System.out.println("Please enter a number greater than 0.");
                            } else {
                                for (int i = 0; i < amount; i++) {
                                    if (memory.isCollectionFull()) {
                                        System.out.println("The collection is now full. No more values can be added.");
                                        break;
                                    }

                                    System.out.print("Enter integer value #" + (i + 1) + ": ");
                                    if (input.hasNextInt()) {
                                        int number = input.nextInt();
                                        memory.addValue(number);
                                        System.out.println(number + " added to the collection.");
                                    } else {
                                        System.out.println("Invalid input. Only integers are allowed.");
                                        input.next();
                                        i--;
                                    }
                                }
                            }
                        } else {
                            System.out.println("Invalid input. Please enter an integer.");
                            input.next();
                        }
                    }
                    break;

                case 6:
                    memory.displayValues();
                    break;

                case 7:
                    System.out.println("Count of values stored: " + memory.getCount());
                    break;

                case 8:
                    if (memory.getCount() == 0) {
                        System.out.println("The collection is empty. Nothing to remove.");
                    } else {
                        System.out.print("Enter the integer value to remove: ");
                        if (input.hasNextInt()) {
                            int removeValue = input.nextInt();
                            if (memory.removeValue(removeValue)) {
                                System.out.println(removeValue + " was removed from the collection.");
                            } else {
                                System.out.println(removeValue + " was not found in the collection.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter an integer.");
                            input.next();
                        }
                    }
                    break;

                case 9:
                    if (memory.getCount() == 0) {
                        System.out.println("The collection is empty. Sum cannot be calculated.");
                    } else {
                        System.out.println("Sum of all values: " + memory.getSum());
                    }
                    break;

                case 10:
                    if (memory.getCount() == 0) {
                        System.out.println("The collection is empty. Average cannot be calculated.");
                    } else {
                        System.out.println("Average of all values: " + memory.getAverage());
                    }
                    break;

                case 11:
                    if (memory.getCount() < 2) {
                        System.out.println("At least two values are needed to find the difference.");
                    } else {
                        System.out.println("Difference of first and last values: " + memory.getDifferenceFirstLast());
                    }
                    break;

                case 12:
                    running = false;
                    System.out.println("\nThank you for using the Calculator Memory Application!");
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid menu choice. Please select a number from 1 to 12.");
            }
        }

        input.close();
    }
}