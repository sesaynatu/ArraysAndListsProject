/**
 * Name: Taphanatu Sesay
 * Date: March 22, 2026
 * Assignment: 3.2 Project - Arrays and Lists
 * Description: This application demonstrates calculator memory functions
 * using a single memory value and a collection of integers.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ArraysAndListsApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Integer singleMemoryValue = null;
        ArrayList<Integer> values = new ArrayList<>();

        int choice;

        System.out.println("==========================================");
        System.out.println("Week 3 Project - Arrays and Lists");
        System.out.println("Name: Taphanatu Sesay");
        System.out.println("Date: March 22, 2026");
        System.out.println("==========================================");
        System.out.println("Welcome to the calculator memory program.");
        System.out.println("This application lets you manage a single memory value");
        System.out.println("and a collection of up to 10 integer values.");

        do {
            System.out.println("\nMenu");
            System.out.println("1. Store single memory value");
            System.out.println("2. Retrieve single memory value");
            System.out.println("3. Clear single memory value");
            System.out.println("4. Replace single memory value");
            System.out.println("5. Add integers to collection");
            System.out.println("6. Display all stored integers");
            System.out.println("7. Display count of stored integers");
            System.out.println("8. Remove an individual value from the collection");
            System.out.println("9. Add additional values if fewer than 10 exist");
            System.out.println("10. Get sum of all values");
            System.out.println("11. Get average of all values");
            System.out.println("12. Get difference of the first and last values");
            System.out.println("13. Quit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a single integer value to store: ");
                    singleMemoryValue = input.nextInt();
                    System.out.println("Stored single memory value: " + singleMemoryValue);
                    break;

                case 2:
                    if (singleMemoryValue == null) {
                        System.out.println("No single memory value is currently stored.");
                    } else {
                        System.out.println("Retrieved single memory value: " + singleMemoryValue);
                    }
                    break;

                case 3:
                    singleMemoryValue = null;
                    System.out.println("Single memory value has been cleared.");
                    break;

                case 4:
                    if (singleMemoryValue == null) {
                        System.out.println("No value exists yet. Please store a value first.");
                    } else {
                        System.out.print("Enter the new value: ");
                        singleMemoryValue = input.nextInt();
                        System.out.println("Single memory value replaced with: " + singleMemoryValue);
                    }
                    break;

                case 5:
                    if (values.size() >= 10) {
                        System.out.println("The collection already has 10 values. No more can be added.");
                    } else {
                        System.out.print("How many integers would you like to add? ");
                        int amount = input.nextInt();

                        if (amount <= 0) {
                            System.out.println("You must enter at least one value.");
                        } else {
                            int spacesLeft = 10 - values.size();

                            if (amount > spacesLeft) {
                                System.out.println("Only " + spacesLeft + " value(s) can be added.");
                                amount = spacesLeft;
                            }

                            for (int i = 0; i < amount; i++) {
                                System.out.print("Enter integer #" + (i + 1) + ": ");
                                values.add(input.nextInt());
                            }

                            System.out.println("Values added successfully.");
                        }
                    }
                    break;

                case 6:
                    if (values.isEmpty()) {
                        System.out.println("No values are currently stored.");
                    } else {
                        System.out.println("Stored Values:");
                        System.out.println("Index   Value");
                        for (int i = 0; i < values.size(); i++) {
                            System.out.println(i + "       " + values.get(i));
                        }
                    }
                    break;

                case 7:
                    System.out.println("Count of stored integers: " + values.size());
                    break;

                case 8:
                    if (values.isEmpty()) {
                        System.out.println("The collection is empty. Nothing to remove.");
                    } else {
                        System.out.println("Stored Values:");
                        System.out.println("Index   Value");
                        for (int i = 0; i < values.size(); i++) {
                            System.out.println(i + "       " + values.get(i));
                        }

                        System.out.print("Enter the index of the value to remove: ");
                        int removeIndex = input.nextInt();

                        if (removeIndex >= 0 && removeIndex < values.size()) {
                            int removedValue = values.remove(removeIndex);
                            System.out.println("Removed value: " + removedValue);
                        } else {
                            System.out.println("Invalid index.");
                        }
                    }
                    break;

                case 9:
                    if (values.size() >= 10) {
                        System.out.println("The collection already contains 10 values.");
                    } else {
                        int spacesLeft = 10 - values.size();
                        System.out.println("You can add up to " + spacesLeft + " more value(s).");
                        System.out.print("How many additional values would you like to add? ");
                        int additional = input.nextInt();

                        if (additional <= 0) {
                            System.out.println("No values added.");
                        } else {
                            if (additional > spacesLeft) {
                                System.out.println("Only " + spacesLeft + " value(s) can be added.");
                                additional = spacesLeft;
                            }

                            for (int i = 0; i < additional; i++) {
                                System.out.print("Enter additional integer #" + (i + 1) + ": ");
                                values.add(input.nextInt());
                            }

                            System.out.println("Additional values added successfully.");
                        }
                    }
                    break;

                case 10:
                    if (values.isEmpty()) {
                        System.out.println("No values are stored, so the sum is 0.");
                    } else {
                        int sum = 0;
                        for (int num : values) {
                            sum += num;
                        }
                        System.out.println("Sum of all values: " + sum);
                    }
                    break;

                case 11:
                    if (values.isEmpty()) {
                        System.out.println("No values are stored, so the average cannot be calculated.");
                    } else {
                        int sum = 0;
                        for (int num : values) {
                            sum += num;
                        }
                        double average = (double) sum / values.size();
                        System.out.println("Average of all values: " + average);
                    }
                    break;

                case 12:
                    if (values.size() < 2) {
                        System.out.println("At least two values are needed to calculate the difference.");
                    } else {
                        int firstValue = values.get(0);
                        int lastValue = values.get(values.size() - 1);
                        int difference = firstValue - lastValue;
                        System.out.println("Difference of first and last values: " + difference);
                    }
                    break;

                case 13:
                    System.out.println("Thank you for using this calculator memory application.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a number from 1 to 13.");
            }

        } while (choice != 13);

        input.close();
    }
}