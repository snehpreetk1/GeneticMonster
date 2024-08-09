package org.example;

import java.io.IOException;
import java.util.Scanner;

class GameLauncher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Monstermanager.MonsterManager manager = new Monstermanager.MonsterManager();

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Create Monster");
            System.out.println("2. View Monsters");
            System.out.println("3. Breed Monsters");
            System.out.println("4. Save Game");
            System.out.println("5. Load Game");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter color:");
                    String color = scanner.nextLine();
                    System.out.println("Enter strength:");
                    int strength = scanner.nextInt();
                    System.out.println("Enter speed:");
                    int speed = scanner.nextInt();

                    Monster monster = new Monster(name, color, strength, speed) {
                        @Override
                        public void performSpecialAbility() {
                            // Define special ability
                        }
                    };

                    manager.addMonster(monster);
                    break;

                case 2:
                    System.out.println("View Monsters (Detailed? true/false):");
                    boolean detailed = scanner.nextBoolean();
                    manager.displayMonsters(detailed);
                    break;

                case 3:
                    System.out.println("Enter index of first monster to breed:");
                    int index1 = scanner.nextInt();
                    System.out.println("Enter index of second monster to breed:");
                    int index2 = scanner.nextInt();
                    manager.breedMonsters(index1, index2);
                    break;

                case 4:
                    try {
                        manager.saveGame("monsters_data.txt");
                    } catch (IOException e) {
                        System.out.println("Error saving game: " + e.getMessage());
                    }
                    break;

                case 5:
            }
        }
    }
}
