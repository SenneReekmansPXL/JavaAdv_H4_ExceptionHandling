package be.pxl.ja.exercise;

import java.util.Scanner;

public class PetGame {

    public static void main(String[] args) throws PetTiredException {
        Scanner scanner = new Scanner(System.in);
        // Create a new pet with initial energy
        Pet timmy_de_brave_daggoe = new Pet(69);
        boolean gameRunning = true;

        System.out.println("Welcome to the Virtual Pet Care Game!");
        System.out.println("Take care of your pet by feeding and playing with it!");

        // Create game loop
        while (gameRunning) {
            System.out.println("\nYour pet's current energy: " + timmy_de_brave_daggoe.getEnergy()+ "/100");
            System.out.println("What would you like to do?");
            System.out.println("1. Feed the pet");
            System.out.println("2. Play with the pet");
            System.out.println("3. Exit game");

            int choice = scanner.nextInt();
            scanner.nextLine();
            // Use switch to handle the player's choice
            switch (choice){
                case 1:
                    try{
                        System.out.println("Choose food: ");
                        String food = scanner.nextLine();
                        timmy_de_brave_daggoe.feed(food);
                    }catch (WrongFoodException e){
                        System.out.println(e.getMessage());
                    }
                break;
                case 2:
                    try{
                        timmy_de_brave_daggoe.play();
                    } catch (PetTiredException e){
                        System.out.println(e.getMessage());
                    }
                break;
                case 3: gameRunning = false;
                    System.out.println("Thank you for playing the Virtual Pet Care Game!");
                break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");

            }


        }

        scanner.close();
    }
}
