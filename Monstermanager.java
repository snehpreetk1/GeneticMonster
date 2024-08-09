package org.example;

import java.io.IOException;
import java.util.ArrayList;

public class Monstermanager {

    static class MonsterManager {
        private ArrayList<Monster> monsters = new ArrayList<>();

        public void addMonster(Monster m) {
            monsters.add(m);
        }

        public void breedMonsters(int index1, int index2) {
            Monster parent1 = monsters.get(index1);
            Monster parent2 = monsters.get(index2);

            String name = parent1.name + "-" + parent2.name + " Jr.";
            String color = parent1.color + "-" + parent2.color;
            int strength = (parent1.strength + parent2.strength) / 2;
            int speed = (parent1.speed + parent2.speed) / 2;

            Monster offspring = new Monster(name, color, strength, speed) {
                @Override
                public void performSpecialAbility() {
                    // Define special ability
                }
            };

            monsters.add(offspring);
            System.out.println("Offspring created: " + offspring);
        }

        public void saveGame(String filename) throws IOException {
            FileManager.saveMonsters(monsters, filename);
        }

        public void loadGame(String filename) throws IOException {
            monsters = FileManager.loadMonsters(filename);
        }

        public void displayMonsters(boolean detailed) {
            for (Monster monster : monsters) {
                if (detailed) {
                    System.out.println(monster.toString());
                } else {
                    System.out.println(monster.name);
                }
            }
        }
    }
}
